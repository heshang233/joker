package com.joker.restful.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/4/12 10:04
 */
public class ThreadTest {
    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            ids.add("test"+i);
        }
        DownloadFilmFileHandler.downloadFilmFile(ids);
        System.out.println("=================");
    }
}
