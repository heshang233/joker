package com.joker.restful.dto;

import java.time.Instant;

/**
 * @author huangsy
 * @date 2018/3/16 9:38
 */
public class TestDTO {

    private String testStr;

    private Instant now = Instant.now();

    public TestDTO(){
    }

    public TestDTO(String testStr){
        this.testStr = testStr;
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public Instant getNow() {
        return now;
    }

    public void setNow(Instant now) {
        this.now = now;
    }
}
