package com.huifer.jenkinsspringboot.service;

import com.alibaba.fastjson.JSONException;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.huifer.jenkinsspringboot.entity.xz.TXz;
import com.huifer.jenkinsspringboot.mapper.TXzMapper;
import com.huifer.jenkinsspringboot.service.spider.XzSpider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
@Slf4j
public class ThreadDemo {

    @Autowired
    TXzMapper tXzMapper;
    @Autowired
    private XzSpider xzSpider;

    public void run() throws JSONException, IOException, InterruptedException, ExecutionException {
        int threadSize = Runtime.getRuntime().availableProcessors() + 1;
        //创建线程名
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        //创建线程池
        ExecutorService exc = new ThreadPoolExecutor(10, 10, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), namedThreadFactory);

        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 2; i <= 414; i++) {

            //申请单个线程执行类
            WorkThread call = new WorkThread(i);
            Future<Integer> future = exc.submit(call);
            futures.add(future);

        }

        for (Future<Integer> future : futures) {
            log.info("执行结果={}", future.get());
        }

        //关闭线程池
        exc.shutdown();

    }

    public void runUid() throws JSONException, IOException, InterruptedException, ExecutionException {
        int threadSize = Runtime.getRuntime().availableProcessors() + 1;

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService exc = new ThreadPoolExecutor(10, 10, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), namedThreadFactory);
        List<TXz> all = tXzMapper.findAll();

        List<Future<String>> futures = new ArrayList<>();
        for (TXz tXz : all) {

            String url = tXz.getUrl();

            WorkThreadUid call = new WorkThreadUid(url);
            Future<String> future = exc.submit(call);
            futures.add(future);

        }

        for (Future<String> future : futures) {
            log.info("执行结果={}", future.get());
        }

        //关闭线程池
        exc.shutdown();

    }

    class WorkThreadUid implements Callable<String> {

        private String i;

        public WorkThreadUid(String url) throws JSONException, IOException {
            this.i = url;
        }

        //数据回调
        public String call() throws Exception {
            // 执行函数全部放在这里
            String cityUsers = xzSpider.uidHistory(i);
            log.info(cityUsers);
            return cityUsers;
        }
    }

    /**
     * 执行爬虫的主要方法
     */
    class WorkThread implements Callable<Integer> {

        private int i;

        public WorkThread(int cityId) throws JSONException, IOException {
            this.i = cityId;
        }

        //数据回调
        public Integer call() throws Exception {
            // 执行函数全部放在这里
            String cityUsers = xzSpider.getCityUsers(i);
            log.info(cityUsers);
            return i;
        }
    }
}
