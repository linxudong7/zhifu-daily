/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZhihuNewsService
 * Author:   rubby
 * Date:     2019/2/19 10:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service;


import lxd.zhihu.service.zhihu.requests.QueryHotNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryOldNewsRequest;
import lxd.zhihu.service.zhihu.responses.HotNewsResponse;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
import lxd.zhihu.service.zhihu.responses.OldNewsResponse;


/**
 * 知乎新闻
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */

public interface ZhihuNewsService {
    /**
     * 每日最新消息
     * @param request
     * @return
     */
    LatestNewsResponse queryLasestNews(QueryLatestNewsRequest request);

    /**
     * 根据date查询过往消息
     * @param request
     * @return
     */
    OldNewsResponse queryOldNewsByDate(QueryOldNewsRequest request);

    /**
     * 热门消息
     * @param request
     * @return
     */
    HotNewsResponse queryHotNews(QueryHotNewsRequest request);
}
