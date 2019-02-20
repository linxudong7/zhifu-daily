/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QueryOldNewsRequest
 * Author:   rubby
 * Date:     2019/2/20 9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.zhihu.requests;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class QueryOldNewsRequest extends BaseZhihuRequest {
    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public QueryOldNewsRequest(String uri, String httpType, String dateStr) {
        this.setUri(uri);
        this.setHttpType(httpType);
        this.setGenerateUri(uri + "/" + dateStr);
        this.dateStr = dateStr;
    }
}
