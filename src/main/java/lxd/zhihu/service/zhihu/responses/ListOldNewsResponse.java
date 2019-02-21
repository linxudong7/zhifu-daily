/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ListOldNewsResponse
 * Author:   rubby
 * Date:     2019/2/21 16:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.zhihu.responses;

import lxd.zhihu.entity.OldNewsEntity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/21
 * @since 1.0.0
 */
public class ListOldNewsResponse extends BaseZhihuResponse<List<OldNewsEntity>> {
    private List<OldNewsEntity> oldNewsEntities;

    public List<OldNewsEntity> getOldNewsEntities() {
        return oldNewsEntities;
    }

    public void setOldNewsEntities(List<OldNewsEntity> oldNewsEntities) {
        this.oldNewsEntities = oldNewsEntities;
    }
}
