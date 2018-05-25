package com.example.springboot.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebAspect {
    private Logger logger= LoggerFactory.getLogger(WebAspect.class);

    //定义切入点，下面的写法意思是对特定的方法切面
    @Pointcut("execution(public * com.example.springboot.controller.testController.find(OnefieldRequestVo))")
    //下面的写法意思是在这个包下面所有的类的所有的方法
    //@Pointcut("execution(public * com.example.springboot.controller..*.*(..))")
    public void webLog(){

    }

    //在执行切入点方法之前执行下面的代码
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        logger.info("首先进入dobefore的切面");
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    //在切入点方法执行完成后，得到返回结果后再执行这个方法
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

}
