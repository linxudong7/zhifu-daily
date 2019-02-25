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

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lxd.zhihu.exception.BizException;

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
     * @param startDateStr 格式： 20180101
     * @param endDateStr 格式： 20181231
     * @return ["20180101",...,"20181231"]
     */
    public static List<String> getDateRange(String startDateStr, String endDateStr) {
        if (Strings.isNullOrEmpty(startDateStr)) {
            throw new IllegalException("开始时间参数缺少");
        }
        if (Strings.isNullOrEmpty(endDateStr)) {
            throw new IllegalException("结束时间参数缺少");
        }
        LocalDate startDate;
        LocalDate endDate;
        try {
            startDate = LocalDate.parse(startDateStr, yyyyMMdd);
            endDate = LocalDate.parse(endDateStr, yyyyMMdd);
        } catch (Exception e) {
            throw new IllegalException("时间格式有误");
        }
        int daysNum  = (int)(endDate.toEpochDay() - startDate.toEpochDay());
        if (daysNum < 0) {
            throw  new IllegalException("结束时间不能小于开始时间");
        }
        ArrayList<String> result = Lists.newArrayList();
        for (int i = 0; i < daysNum; i++) {
            result.add(startDate.format(yyyyMMdd));
            startDate = startDate.plusDays(1);
        }
        result.add(endDate.format(yyyyMMdd));
        return result;
    }
}
