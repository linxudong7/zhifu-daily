/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZhihuClient
 * Author:   rubby
 * Date:     2019/2/20 10:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.zhihu;

import lxd.zhihu.enums.HttpType;
import lxd.zhihu.service.zhihu.requests.BaseZhihuRequest;
import lxd.zhihu.service.zhihu.responses.BaseZhihuResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
@Component
public class ZhihuClient {

    private static final Logger logger = LoggerFactory.getLogger(ZhihuClient.class);

    private static CloseableHttpClient client = HttpClients.createDefault();

    private String accessKey;
    private String secretKey;

    private static String generateSign(BaseZhihuRequest request) {
        // TODO:
        return "";
    }

    public BaseZhihuResponse getResponse(BaseZhihuRequest request) {

        // TODO:
        String sign = generateSign(request);

        BaseZhihuResponse baseZhihuResponse = new BaseZhihuResponse();
        CloseableHttpResponse httpResponse =null;
        baseZhihuResponse.setRequestId(request.getRequestId());
        try {
            if (HttpType.GET.getType().equals(request.getHttpType())) {
                HttpGet get = new HttpGet(request.getUri());
                httpResponse = client.execute(get);
            } else {
                HttpPost post = new HttpPost(request.getUri());
                httpResponse = client.execute(post);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonResult = null;
            try {
                jsonResult = EntityUtils.toString(httpResponse.getEntity());
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
            baseZhihuResponse.setData(jsonResult);
            if (!StringUtils.isBlank(jsonResult)) {
                baseZhihuResponse.setSuccess(true);
                baseZhihuResponse.setCode(200);
                baseZhihuResponse.setMsg("http请求成功");
            } else {
                baseZhihuResponse.setSuccess(false);
                baseZhihuResponse.setCode(-90);
                baseZhihuResponse.setMsg("Http请求失败");
            }

        }
        return baseZhihuResponse;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
