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
package lxd.zhihu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lxd.zhihu.entity.HotNewEntity;
import lxd.zhihu.entity.LatestNewsEntity;
import lxd.zhihu.entity.OldNewsEntity;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.zhihu.ZhihuClient;
import lxd.zhihu.service.zhihu.requests.QueryHotNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryOldNewsRequest;
import lxd.zhihu.service.zhihu.responses.BaseZhihuResponse;
import lxd.zhihu.service.zhihu.responses.HotNewsResponse;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
import lxd.zhihu.service.zhihu.responses.OldNewsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
@Service
public class ZhihuNewsServiceImpl implements ZhihuNewsService {

    private static final Logger logger = LoggerFactory.getLogger(ZhihuNewsServiceImpl.class);

    @Autowired
    private ZhihuClient zhihuClient;

    @Override
    public LatestNewsResponse queryLasestNews(QueryLatestNewsRequest request) {
        LatestNewsResponse latestNewsResponse = new LatestNewsResponse();
        try {
            BaseZhihuResponse zhihuResponse = zhihuClient.getResponse(request);
            BeanUtils.copyProperties(zhihuResponse, latestNewsResponse);
            String data = zhihuResponse.getData();
            LatestNewsEntity latestNewsEntity = JSON.parseObject(data, LatestNewsEntity.class);
            latestNewsResponse.setLatestNewsEntity(latestNewsEntity);
            logger.info("获取最新消息成功");
            return latestNewsResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return latestNewsResponse;
    }

    @Override
    public OldNewsResponse queryOldNewsByDate(QueryOldNewsRequest request) {
        OldNewsResponse oldNewsResponse = new OldNewsResponse();
        try {
            BaseZhihuResponse zhihuResponse = zhihuClient.getResponse(request);
            BeanUtils.copyProperties(zhihuResponse, oldNewsResponse);
            String data = zhihuResponse.getData();
            OldNewsEntity oldNewsEntity = JSON.parseObject(data, OldNewsEntity.class);
            oldNewsResponse.setOldNewsEntity(oldNewsEntity);
            logger.info("根据日期" + request.getDateStr() + "获取消息成功");
            return oldNewsResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return oldNewsResponse;
    }

    @Override
    public HotNewsResponse queryHotNews(QueryHotNewsRequest request) {
        HotNewsResponse hotNewsResponse = new HotNewsResponse();
        try {
            BaseZhihuResponse zhihuResponse = zhihuClient.getResponse(request);
            BeanUtils.copyProperties(zhihuResponse, hotNewsResponse);
            String data = zhihuResponse.getData();
            JSONObject jsonObjects = JSON.parseObject(data);
            JSONArray hotNewsEntites = jsonObjects.getJSONArray("recent");
            List<HotNewEntity> hotNewEntities = new ArrayList<HotNewEntity>();
            for (Object obj :hotNewsEntites) {
                JSONObject jsonObject = (JSONObject)obj;
                HotNewEntity hotNewEntity = new HotNewEntity();
                hotNewEntity.setNewsId(jsonObject.getLong("news_id"));
                hotNewEntity.setUrl(jsonObject.getString("url"));
                hotNewEntity.setThumbnail(jsonObject.getString("thumbnail"));
                hotNewEntity.setTitle(jsonObject.getString("title"));
                hotNewEntities.add(hotNewEntity);
            }
            hotNewsResponse.setHotNewEntities(hotNewEntities);
            logger.info("获取热门消息成功");
            return hotNewsResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return hotNewsResponse;
    }
}
