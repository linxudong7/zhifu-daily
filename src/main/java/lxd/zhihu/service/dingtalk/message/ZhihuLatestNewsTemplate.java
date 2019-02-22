/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZhihuLatestNewsTemplate
 * Author:   rubby
 * Date:     2019/2/22 18:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.dingtalk.message;

import lxd.zhihu.entity.LatestNewsEntity;
import lxd.zhihu.entity.StoryEntity;
import lxd.zhihu.service.dingtalk.requests.DingtalkMarkdownRequest;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/22
 * @since 1.0.0
 */
public class ZhihuLatestNewsTemplate {
    public static MarkdownMessage getMarkdownType(DingtalkMarkdownRequest request, LatestNewsEntity latestNewsEntity) {
        //构建MarkdownMessage信息
        MarkdownMessage markdownMessage = new MarkdownMessage();
        markdownMessage.setTitle("知乎日报");
        markdownMessage.setMsgType(request.getMsgType());
        if (request.getAtMobiles().size() == 0) {
            markdownMessage.setAtAll(true);
        } else {
            markdownMessage.setAtMobiles(request.getAtMobiles());
            for (String mobile : request.getAtMobiles()
            ) {
                markdownMessage.add("@" + mobile);
            }
        }
        markdownMessage.add("\n\n");
        markdownMessage.add(MarkdownMessage.getHeaderText(3, "知乎日报"));

        List<StoryEntity> stories = latestNewsEntity.getStories();
        for (StoryEntity story : stories
        ) {
            markdownMessage.add(MarkdownMessage.getLinkText(story.getTitle(), "https://news-at.zhihu.com/story/" + story.getId()));
            markdownMessage.add("\n\n");
            for (String image : story.getImages()
            ) {
                markdownMessage.add(MarkdownMessage.getImageText(image));
                markdownMessage.add("\n\n");
            }
        }
        markdownMessage.add(latestNewsEntity.getDate() + "发布");
        markdownMessage.add(MarkdownMessage.getLinkText("知乎", "https://news-at.zhihu.com/"));
        return markdownMessage;
    }
}
