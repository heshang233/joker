package com.joker.restful.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangsy
 * @date 2018/4/8 14:14
 */
public class DownloadFilmFileThreadPool {

    private DownloadFilmFileThreadPool(){}
    /**
     * 添加下载文件任务
     *
     * @param runnable
     */
    public static void addTask(Runnable runnable) {
        ExecutorService pool = DownloadFilmFileThreadPoolWrapper.getPool();
        pool.submit(runnable);
    }

    /**
     * 通过内部类的懒加载模式实现线程安全的初始化线程池
     */
    private static class DownloadFilmFileThreadPoolWrapper {

        private static ExecutorService DELETE_THREAD_POOL = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        public static ExecutorService getPool() {
            return DELETE_THREAD_POOL;
        }
    }
}
