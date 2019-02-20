/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LatestNewsResponse
 * Author:   rubby
 * Date:     2019/2/20 10:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.zhihu.responses;

import lxd.zhihu.entity.LatestNewsEntity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class LatestNewsResponse extends BaseZhihuResponse {
    private LatestNewsEntity latestNewsEntity;

    public LatestNewsEntity getLatestNewsEntity() {
        return latestNewsEntity;
    }

    public void setLatestNewsEntity(LatestNewsEntity latestNewsEntity) {
        this.latestNewsEntity = latestNewsEntity;
    }
}
