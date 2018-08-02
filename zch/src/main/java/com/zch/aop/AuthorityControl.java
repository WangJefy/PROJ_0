package com.zch.aop;

import com.zch.entity.Authority;
import com.zch.repository.AuthorityRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chensuo on 2018-7-31.
 *
 * 权限控制的切片类，每个controller的每个方法之前都有拦截，用来判断当前登录用户是否有权限访问即将执行的方法
 */

@Aspect
@Component
public class AuthorityControl {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Pointcut("execution(public * com.zch.controller.*.*(..))")
    public void authorityControl() {
    }

    @Before("authorityControl()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        if(AuthorityMapping.AUTH_MAPPING.containsKey(classMethod)){
            String mappingValue = AuthorityMapping.AUTH_MAPPING.get(classMethod);
            System.out.println("mapping value is : " + mappingValue);
        }

//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        System.out.println("URL : " + request.getRequestURL().toString());
//        System.out.println("HTTP_METHOD : " + request.getMethod());
//        System.out.println("IP : " + request.getRemoteAddr());
//        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

}
