/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DingtalkTask
 * Author:   rubby
 * Date:     2019/2/19 16:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lxd.educ.task;

import com.lxd.educ.entity.MessageInfo;
import com.lxd.educ.exception.RRException;
import com.lxd.educ.service.DingtalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
@Component
public class DingtalkTask {

    @Autowired
    private DingtalkService dingtalkService;

    public void sendMessage(MessageInfo messageInfo){
        try {
            dingtalkService.sendMessage(messageInfo);

        } catch (Exception e) {
            throw new RRException("数据有误！");
        }

    }
}
