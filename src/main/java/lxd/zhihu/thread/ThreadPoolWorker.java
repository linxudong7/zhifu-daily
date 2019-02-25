/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ThreadPoolWorker
 * Author:   rubby
 * Date:     2019/2/21 21:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.thread;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/21
 * @since 1.0.0
 */
public class ThreadPoolWorker {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("线程名称-%s").build();

    public static final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(
            Executors.newFixedThreadPool(8, namedThreadFactory));

    public static final ListeningExecutorService executorService2 = MoreExecutors.listeningDecorator(
            Executors.newFixedThreadPool(8, namedThreadFactory));
}
