/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OldNewsResponse
 * Author:   rubby
 * Date:     2019/2/20 17:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.zhihu.responses;

import lxd.zhihu.entity.OldNewsEntity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class OldNewsResponse extends BaseZhihuResponse {
    private OldNewsEntity oldNewsEntity;

    public OldNewsEntity getOldNewsEntity() {
        return oldNewsEntity;
    }

    public void setOldNewsEntity(OldNewsEntity oldNewsEntity) {
        this.oldNewsEntity = oldNewsEntity;
    }
}
