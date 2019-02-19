/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: zhiFuDailyServiceImpl
 * Author:   rubby
 * Date:     2019/2/19 10:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lxd.educ.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxd.educ.entity.ZhifuDaily;
import com.lxd.educ.service.ZhiFuDailyService;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
@Service
public class ZhiFuDailyServiceImpl implements ZhiFuDailyService {
    @Override
    public ZhifuDaily getMessage() {
        //通过http请求拿到json串
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://news-at.zhihu.com/api/4/news/latest";
        HttpGet get = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String jsonResult = EntityUtils.toString(response.getEntity());
                //json转化为对象
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return objectMapper.readValue(jsonResult, ZhifuDaily.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
