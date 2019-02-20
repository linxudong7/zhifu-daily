/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DingtalkService
 * Author:   rubby
 * Date:     2019/2/19 16:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service;

import lxd.zhihu.entity.MessageInfo;
import lxd.zhihu.result.SendResult;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */

public interface DingtalkService {
    /**
     *发送一次消息
     * @param messageInfo
     * @return
     */
    SendResult sendMessage(MessageInfo messageInfo);
}
