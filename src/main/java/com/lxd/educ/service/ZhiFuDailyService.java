/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZhiFuDailyService
 * Author:   rubby
 * Date:     2019/2/19 10:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lxd.educ.service;


import com.lxd.educ.entity.ZhifuDaily;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */

public interface ZhiFuDailyService {
    /**
     * 接收新闻
     * @return 每日新闻
     */
    ZhifuDaily getMessage();
}
