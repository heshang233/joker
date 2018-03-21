package com.joker.restful.holder;

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
}
