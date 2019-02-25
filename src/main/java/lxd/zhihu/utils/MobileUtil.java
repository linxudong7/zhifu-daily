/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MobileUtil
 * Author:   rubby
 * Date:     2019/2/25 14:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.utils;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import sun.plugin.viewer.context.IExplorerAppletContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/25
 * @since 1.0.0
 */
public class MobileUtil {
    public static List<String> getMobilesStr(String mobilesStr) {
        if (Strings.isNullOrEmpty(mobilesStr)) {
            throw new IllegalException("手机号参数不能为空");
        }
        String[] arrayMobileStr = StringUtils.split(mobilesStr,",");
        ArrayList<String> listMobileStr =Lists.newArrayList();
        for (String mobileStr: arrayMobileStr
             ) {
            if (! mobileStr.matches("^1[34578]\\d{9}$")) {
                throw new IllegalException("手机号格式有误");
            }
            listMobileStr.add(mobileStr);
        }
        return listMobileStr;
    }

}
