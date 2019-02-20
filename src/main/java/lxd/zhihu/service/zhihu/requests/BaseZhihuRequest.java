/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseZhihuRequest
 * Author:   rubby
 * Date:     2019/2/20 9:57
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
public class BaseZhihuRequest {

    private String uri;

    private String httpType;

    private String generateUri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHttpType() {
        return httpType;
    }

    public void setHttpType(String httpType) {
        this.httpType = httpType;
    }

    public String getGenerateUri() {
        return generateUri;
    }

    public void setGenerateUri(String generateUri) {
        this.generateUri = generateUri;
    }
}
