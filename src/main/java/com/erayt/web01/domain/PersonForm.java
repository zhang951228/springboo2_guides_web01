package com.erayt.web01.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Auther: Z151
 * @Date: 2021/8/16 17:49
 */
public class PersonForm {

    @Size(min = 2,max = 10)
    @NotNull
    private String name;

    @Min(18)
    @Max(200)
    @NotNull
    private Integer  age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonForm{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
