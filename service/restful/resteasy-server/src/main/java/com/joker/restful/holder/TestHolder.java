package com.joker.restful.holder;

import java.io.File;
import java.io.FileFilter;

/**
 * @author huangsy
 * @date 2018/3/21 11:32
 */
public class TestHolder {
    private static final ThreadLocal<TestHolder> cache = new ThreadLocal<>();

    private String enable;

    private TestHolder(String enable){
        this.enable = enable;
    }

    public static String isEnabled(){
        TestHolder holder = cache.get();
        if (holder == null) {
            return "null";
        }
        return holder.enable;
    }

    public static void disable(String enable) {
        TestHolder holder = new TestHolder(enable);
        cache.set(holder);
    }

    public static void enable(String enable) {
        TestHolder holder = new TestHolder(enable);
        cache.set(holder);
    }

    public static void remove(){
        cache.remove();
    }

    public static void main(String[] args) {
        File file = new File("D://ftptest");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.toString());
        }
    }
}
