/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QueryLatestNewsRequest
 * Author:   rubby
 * Date:     2019/2/20 9:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.zhihu.requests;


import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;

import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class QueryLatestNewsRequest extends BaseZhihuRequest<LatestNewsResponse> {
    public QueryLatestNewsRequest() {
        this.setUri("https://news-at.zhihu.com/api/4/news/latest");
        this.setHttpType("get");
        this.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));
    }
}
