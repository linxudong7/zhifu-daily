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

    private static String generateSign(BaseZhihuRequest request){
        // TODO:
        return "";
    }

    public BaseZhihuResponse getResponse(BaseZhihuRequest request){

        BaseZhihuResponse baseZhihuResponse = new BaseZhihuResponse();

        // TODO:
        String sign = generateSign(request);

        try {
            CloseableHttpResponse httpResponse = null;
            if ("get".equals(request.getHttpType())) {
                HttpGet get = new HttpGet(request.getGenerateUri());
                 httpResponse = client.execute(get);
            } else {
                HttpPost post = new HttpPost(request.getGenerateUri());
                httpResponse = client.execute(post);
            }

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String jsonResult = EntityUtils.toString(httpResponse.getEntity());
                baseZhihuResponse.setData(jsonResult);
                if (! StringUtils.isBlank(jsonResult)){
                    baseZhihuResponse.setSuccess(true);
                } else {
                    baseZhihuResponse.setSuccess(false);
                    baseZhihuResponse.setMsg("Http请求失败");
                }
            }
            logger.info("知乎http请求成功");
            return baseZhihuResponse;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
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
