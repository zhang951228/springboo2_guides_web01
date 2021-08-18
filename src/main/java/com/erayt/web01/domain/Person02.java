package com.erayt.web01.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region(value="People")
public class Person02 {

    @Id
    private String name;

    private int age;

    @PersistenceConstructor
    public Person02(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
