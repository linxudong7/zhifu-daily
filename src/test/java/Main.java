/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Main
 * Author:   rubby
 * Date:     2019/2/24 18:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/24
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        //初始化容器时，执行Myjob
        new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
    }

}
