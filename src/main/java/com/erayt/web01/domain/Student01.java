package com.erayt.web01.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 14:27
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student01 {
    private long id;
    private String name;
    private String clz;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    @Override
    public String toString() {
        return "Student01{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", clz='" + clz + '\'' +
            '}';
    }
}
