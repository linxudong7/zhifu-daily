package lxd.zhihu.aspect;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /**
     * 描述方法的实际作用
     */
    String description()  default "";

    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    String action() default "";
}
