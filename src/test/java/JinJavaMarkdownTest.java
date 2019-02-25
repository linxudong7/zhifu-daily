/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JinJavaMarkdownTest
 * Author:   rubby
 * Date:     2019/2/23 17:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/23
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class JinJavaMarkdownTest {
    @Test
    public void personTest() throws IOException {
        Map<String, String> students = ImmutableMap.<String, String>builder().
                put("201601", "王大锤").
                put("201602", "李铁华").
                put("201603", "崔大建").build();
        List<String> tasks = ImmutableList.<String>builder()
                .add("炼金术")
                .add("魔造学")
                .add("圣光术")
                .add("冲锋")
                .add("丢人").build();
        Map<String, Object> context = Maps.newHashMap();
        context.put("name", "黑暗大法师");
        context.put("students", students);
        context.put("tasks", tasks);


        String template = Resources.toString(Resources.getResource("person.html"), Charsets.UTF_8);
        Jinjava jinjava = new Jinjava();
        String renderedTemplate = jinjava.render(template, context);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(renderedTemplate);
    }
    @Test
    public void jinjavaTest() {



    }

}
