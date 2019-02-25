/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PropertiesTest
 * Author:   rubby
 * Date:     2019/2/24 22:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/24
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class PropertiesTest {
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        InputStream inStream = PropertiesTest.class.getClassLoader().getResourceAsStream("task.properties");
        properties.load(inStream);
        String invertel = properties.getProperty("task1.cronExpression");
        System.out.println(invertel);
        String msgType = properties.getProperty("task1.zhihuMsgType");
        System.out.println(msgType);
    }
}
