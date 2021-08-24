package com.erayt.web01.domain.message;

/**
 * @Auther: Z151
 * @Date: 2021/8/24 11:16
 */
public class HelloMessage {

    private String name;

    public HelloMessage(String name) {
        this.name = name;
    }

    public HelloMessage() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
