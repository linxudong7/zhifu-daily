/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DateUtil
 * Author:   rubby
 * Date:     2019/2/21 21:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/21
 * @since 1.0.0
 */
public class DateUtil {
    private static DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 获取时间区间
     * @param dateRangeStr 格式： 20180101/20181231
     * @return ["20180101",...,"20181231"]
     */
    public static List<String> getDateRange(String dateRangeStr) {
        if (StringUtils.isBlank(dateRangeStr)) {
            return null;
        }
        String[] tmp = dateRangeStr.split("/");
        LocalDate startDate = LocalDate.parse(tmp[0], yyyyMMdd);
        LocalDate endDate = LocalDate.parse(tmp[1], yyyyMMdd);
        ArrayList<String> result = Lists.newArrayList();
        do {
            result.add(startDate.format(yyyyMMdd));
            startDate = startDate.plusDays(1);
        } while (startDate.isBefore(endDate));
        result.add(endDate.format(yyyyMMdd));
        return result;
    }
}
