/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExceutorsTest
 * Author:   rubby
 * Date:     2019/2/21 17:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lxd.zhihu.entity.OldNewsEntity;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.zhihu.requests.QueryOldNewsRequest;
import lxd.zhihu.service.zhihu.responses.ListOldNewsResponse;
import lxd.zhihu.service.zhihu.responses.OldNewsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/21
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class ExceutorsTest {

    @Autowired
    private ZhihuNewsService zhihuNewsService;

    @Test
    public void test() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("线程名称-%s").build();

        ExecutorService pool = new ThreadPoolExecutor(4, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        final ListOldNewsResponse listOldNewsResponse = new ListOldNewsResponse();
        final ArrayList<OldNewsEntity> oldNewsEntities = new ArrayList<OldNewsEntity>();

        for (int i = 0; i < 100; i++) {
                pool.execute(new Runnable() {
                    QueryOldNewsRequest queryOldNewsRequest = new QueryOldNewsRequest("20190220");
                    OldNewsResponse oldNewsResponse = zhihuNewsService.queryOldNewsByDate(queryOldNewsRequest);
                    @Override
                    public void run() {
                        OldNewsEntity oldNewsEntity = oldNewsResponse.getOldNewsEntity();
                        oldNewsEntities.add(oldNewsEntity);
                    }
                });
            }
        System.out.println(oldNewsEntities.toArray().toString());
        pool.shutdown();

    }

}

