/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DingtalkChatbotClient
 * Author:   rubby
 * Date:     2019/2/22 15:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.dingtalk;

import com.alibaba.fastjson.JSONObject;
import lxd.zhihu.service.dingtalk.message.Message;
import lxd.zhihu.service.dingtalk.response.SendResult;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/22
 * @since 1.0.0
 */
@Component
public class DingtalkChatbotClient {

    private static HttpClient httpclient = HttpClients.createDefault();

    public SendResult send(String webHookToken, Message message) throws IOException {

        HttpPost httppost = new HttpPost(String.format("https://oapi.dingtalk.com/robot/send?access_token=%s",webHookToken));
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
        StringEntity se = new StringEntity(message.toJsonString(), "utf-8");
        httppost.setEntity(se);

        SendResult sendResult = new SendResult();
        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            JSONObject obj = JSONObject.parseObject(result);

            Integer errcode = obj.getInteger("errcode");
            sendResult.setErrorCode(errcode);
            sendResult.setErrorMsg(obj.getString("errmsg"));
            sendResult.setIsSuccess(errcode.equals(0));
        }

        return sendResult;
    }
}
