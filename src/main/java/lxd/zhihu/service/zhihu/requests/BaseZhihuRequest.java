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

import lxd.zhihu.service.zhihu.responses.BaseZhihuResponse;

/**
 * 知乎统一请求值
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class BaseZhihuRequest<T extends BaseZhihuResponse> {

    private String uri;

    private String httpType;

    private String requestId;

    private T response;

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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
