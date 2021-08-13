package com.erayt.web01.controller;

import com.erayt.web01.domain.Response;
import com.erayt.web01.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: Z151
 * @Date: 2021/8/11 15:14
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String seHello(@RequestParam(value = "name1",defaultValue = "World") String name, String password){
        String logStr = String.format("调用seHello, 传入参数  %s!   %s!",name,password);
        System.out.println(logStr);
        return  logStr;
    }
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/stu")
    public List<Student> seeStudent(@RequestParam(value = "name",required = false,defaultValue = "") String name,
                                    @RequestParam(value = "age",required = false,defaultValue = "0")long age,
                                    @RequestParam(value = "clz",required = false,defaultValue = "")String clz){

        List<Student> students = new LinkedList<>();
        Student student = new Student(counter.incrementAndGet(), name, clz);
        students.add(student);
        student = new Student(age, String.format(template,name), clz);
        students.add(student);
        return students;
    }
    @GetMapping("/stu2")
    public Response<List<Student>> response01(@RequestParam(value = "name",required = false,defaultValue = "") String name,
                                              @RequestParam(value = "age",required = false,defaultValue = "0")long age,
                                              @RequestParam(value = "clz",required = false,defaultValue = "")String clz){
        List<Student> students = new LinkedList<>();
        Student student = new Student(counter.incrementAndGet(), name, clz);
        students.add(student);
        student = new Student(age, String.format(template,name), clz);
        students.add(student);
       student = new Student(age, String.format(template,name), clz);
        students.add(student);
        Response response = new Response();
        response.setResponse(students);
        return response;

    }

}
