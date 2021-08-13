package com.erayt.web01.controller;

import com.erayt.web01.domain.Response;
import com.erayt.web01.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: Z151
 * @Date: 2021/8/11 15:14
 */
@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

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

    /**
     *  https://blog.csdn.net/lydms/article/details/105224210
     * @return
     */
    @GetMapping("/redis01")
    public String triggerRedis01(){
        String msg = "Hello from Redis!"+ UUID.randomUUID().toString().substring(0,10);
        stringRedisTemplate.convertAndSend("chat",msg);
        redisTemplate.boundValueOps("key1").set(msg);
        //redisTemplate.boundValueOps("key2").set(msg);
        Object key1 = redisTemplate.boundValueOps("key1").get();
        System.out.println("after set key1's values:"+key1);
        redisTemplate.delete("key1");
        key1 = redisTemplate.boundValueOps("key1").get();
        System.out.println("after delete,key1's value:"+key1);
        key1 = redisTemplate.boundValueOps("key2").get();
        System.out.println("after delete,key2's value:"+key1);
        return "trigger redis message Listener success。";
    }

}
