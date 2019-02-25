/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzTaskTest
 * Author:   rubby
 * Date:     2019/2/24 18:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.task;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lxd.zhihu.entity.StoryEntity;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.dingtalk.message.MarkdownMessage;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
import lxd.zhihu.utils.JinJavaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/24
 * @since 1.0.0
 */
@Component("quartzTaskTest")
public class QuartzTaskTest {

    @Autowired
    private ZhihuNewsService zhihuNewsService;

    public void run () {
        System.out.println("hello world");
    }
}
