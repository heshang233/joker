package com.joker.restful.thread;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author huangsy
 * @date 2018/4/8 14:11
 */
public class DownloadFilmFileHandler implements Runnable{


    private String uuid;

    public DownloadFilmFileHandler(String uuid){
        this.uuid = uuid;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            System.out.println("====================,uuid:"+uuid);

        }catch (Exception e){

        }
    }

    public static void downloadFilmFile(List<String> uuidList) {
        if (!CollectionUtils.isEmpty(uuidList)) {
            uuidList.forEach(uuid -> {
                DownloadFilmFileThreadPool.addTask(new DownloadFilmFileHandler(uuid));
            });
        }
    }
}
