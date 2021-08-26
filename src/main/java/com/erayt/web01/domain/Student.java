package com.erayt.web01.domain;

import java.io.Serializable;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 14:27
 */


public class Student implements Serializable {
    private long id;
    private String name;
    private String clz;

    private static final long serialVersionUID = -1193558920511888049L;

    public Student(long id, String name, String clz) {
        this.id = id;
        this.name = name;
        this.clz = clz;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClz() {
        return clz;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", clz='" + clz + '\'' +
            '}';
    }
}
