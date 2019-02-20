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
package lxd.zhihu.task;

import lxd.zhihu.entity.MessageInfo;
import lxd.zhihu.exception.RRException;
import lxd.zhihu.service.DingtalkService;
import lxd.zhihu.service.ZhihuNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DingtalkTask.class);

    @Autowired
    private DingtalkService dingtalkService;

    @Autowired
    private ZhihuNewsService zhihuNewsService;

    public void sendMessage(MessageInfo messageInfo){
        try {

            dingtalkService.sendMessage(messageInfo);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RRException("数据有误！");
        }

    }
}
