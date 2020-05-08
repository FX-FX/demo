package com.example.log;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 繁星
 */
@Aspect
public class LogConfig {

    private static final Logger logger = LoggerFactory.getLogger(LogConfig.class);

    @Pointcut("@annotation(com.example.log.PrintLog)")
    public void log(){

    }

    @Around("log()")
    public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();
        try {
            logger.info("execute method:{} params:{}",  methodName, getParam(pjp));
        } catch (Exception e) {
            logger.info("execute method:{} params:{}", methodName, "参数存在不可序列化对象，暂无日志输出！");
        }
        try {
            Object ret = pjp.proceed();
            try {
                logger.info("method:{} response data:{}", methodName, JSON.toJSONString(ret));
            } catch (Exception e) {
                logger.info("method:{} response data:{}", methodName,"返回值存在不可序列化对象，暂无日志输出！");
            }
            return ret;
        } catch (Exception e) {
            logger.error("execute method:{} exception:{}", methodName, e);
            throw e;
        }
    }

    private String getParam(ProceedingJoinPoint pjp){
        //获取请求参数：
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        //获取请求参数类型
        String[] parameterNames = ms.getParameterNames();
        //获取请求参数值
        Object[] parameterValues = pjp.getArgs();
        StringBuilder param = new StringBuilder();
        //组合请求参数，进行日志记录
        if (parameterNames != null && parameterNames.length > 0) {
            for (int i = 0; i < parameterNames.length; i++) {
                if (parameterValues[i] instanceof BindingResult) {
                    continue;
                }
                if ((parameterValues[i] instanceof HttpServletRequest)
                        || (parameterValues[i] instanceof HttpServletResponse)
                        || (parameterValues[i] instanceof HttpSession)
                        || (parameterValues[i] instanceof MultipartFile)){
                    param
                            .append("[")
                            .append(parameterNames[i]).append("=").append(parameterValues[i])
                            .append("]");
                } else {
                    param
                            .append("[")
                            .append(parameterNames[i]).append("=")
                            .append(JSON.toJSONString(parameterValues[i]).length() > 500
                                    ? JSON.toJSONString(parameterValues[i]).substring(0,500) + "......"
                                    :JSON.toJSONString(parameterValues[i]))
                            .append("]");
                }
            }
        }
        return param.toString();
    }

}
