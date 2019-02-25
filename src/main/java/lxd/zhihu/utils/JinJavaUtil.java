/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JinJavaUtil
 * Author:   rubby
 * Date:     2019/2/23 22:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import lxd.zhihu.exception.BizException;

import java.io.IOException;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/23
 * @since 1.0.0
 */
public class JinJavaUtil {
    public static String toMardownText(HashMap<String, Object> context, String markdownTypeName) {
        String template = null;
        try {
            template = Resources.toString(Resources.getResource(markdownTypeName), Charsets.UTF_8);
        } catch (IOException e) {
            throw new BizException("知乎模板文件无法获取");
        }
        Jinjava jinjava = new Jinjava();
        String mardownText = jinjava.render(template, context);
        return mardownText;
    }

}
