package com.erayt.web01.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 14:27
 */

public class Student01 extends RepresentationModel<Student01> {
    private long id;
    private String name;
    private String clz;

    @JsonCreator
    public Student01(@JsonProperty("id")long id, @JsonProperty("name")String name, @JsonProperty("clz")String clz) {
        this.id = id;
        this.name = name;
        this.clz = clz;
    }

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
