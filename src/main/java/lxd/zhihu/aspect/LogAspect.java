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
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
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
     * 拦截异常操作，有异常时执行
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        try {
            LogAnnotation logAnnotation = getAnnotationLog(joinPoint);
            if (logAnnotation == null) {
                return;
            }

            //{"exceptionSevice":"","stack":"","argus":["",""],"isSucess":"true","method":"callxxx"}
            logger.error("exceptionSevice：{}", joinPoint.getTarget().getClass().getName());
            logger.error("stack：{}", getStack(e));
            logger.error("argus：{}", JSONObject.toJSONString(joinPoint.getArgs()));
            //logger.error("isSucess：{}", );
            logger.error("method：{}", joinPoint.getSignature().getName());
            logger.error("exceptionMessage:{}", e.getMessage());


        } catch (Exception exp) {
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

    private static String getStack(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }

}
