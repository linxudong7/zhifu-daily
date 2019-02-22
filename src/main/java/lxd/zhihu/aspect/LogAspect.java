/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LogAspect
 * Author:   rubby
 * Date:     2019/2/22 13:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 日志切面
 *
 * @author rubby
 * @create 2019/2/22
 * @since 1.0.0
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(lxd.zhihu.aspect.LogAnnotation)")
    public void logPointCut() {

    }

    /**
     * 前置通知 用于拦截操作，在方法返回后执行
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    /**
     * 拦截异常操作，有异常时执行
     *
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e);
    }

    private void handleLog(JoinPoint joinPoint, Exception e) {
        try {
            //获得注解
            LogAnnotation logAnnotation = getAnnotationLog(joinPoint);
            if (logAnnotation == null) {
                return;
            }
            //类名
            String className = joinPoint.getTarget().getClass().getName();
            //方法名
            String methodName = joinPoint.getSignature().getName();

            MethodSignature ms = (MethodSignature) joinPoint.getSignature();
            //入参key
            String[] parameterNames = ms.getParameterNames();
            //入参value
            Object[] arguments = joinPoint.getArgs();
            Method method = ms.getMethod();

            //String action = logAnnotation.action();
            //String title = logAnnotation.title();
            //打印日志，如有需要还可以存入数据库
            //logger.info(">>>>>>>>>>>>>模块名称：{}",title);
            //logger.info(">>>>>>>>>>>>>操作名称：{}",action);
            logger.debug(">>>>>>>>>>>>>className：{}", className);
            logger.debug(">>>>>>>>>>>>>methodName：{}", methodName);
            logger.debug(">>>>>>>>>>>>>methodSignature:{}", ms);
            logger.debug(">>>>>>>>>>>>>arguments:{}", JSONObject.toJSONString(arguments));
            logger.debug(">>>>>>>>>>>>>parameterNames:{}", JSONObject.toJSONString(parameterNames));
            logger.debug(">>>>>>>>>>>>>method:{}", JSONObject.toJSONString(method));

        } catch (Exception exp) {
            // 记录本地异常日志
            logger.error("====系统抛出前置通知异常====");
            logger.error("异常信息:{}", exp.getMessage());
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private static LogAnnotation getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(LogAnnotation.class);
        }
        return null;
    }

}
