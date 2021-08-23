package com.erayt.web01.controller;

import com.erayt.web01.domain.*;
import com.erayt.web01.repository.CustomerRepository;
import com.erayt.web01.repository.PersonRepository;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static java.util.Arrays.asList;
import static java.util.stream.StreamSupport.stream;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: Z151
 * @Date: 2021/8/11 15:14
 */
//@RestController
@Controller
public class HelloController implements WebMvcConfigurer {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/hello1")
    public String seHello(@RequestParam(value = "name1",defaultValue = "World") String name, String password){
        String logStr = String.format("调用seHello, 传入参数  %s!   %s!",name,password);
        System.out.println(logStr);
        return  logStr;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
            /*等同于如下代码
            @GetMapping("/results")
            public String postResult(){
                return "results";
            }*/
    }

    @GetMapping("/form1")
    public String showForm(PersonForm personForm){
        System.out.println(personForm);
        jmsTemplate.convertAndSend("myqueue",new Email("to","body","title","additional"));
        return "form1";
    }

    @GetMapping("/home")
    public String home(){
        return "hello";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/")
    public String hello2(){
        return "hello";
    }

    @GetMapping("/admin")
    public String hello3(){
        return "/admin/admin";
    }
   @GetMapping("/welcome")
    public String hello4(){
        return "/welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        System.out.println(personForm);
        if (bindingResult.hasErrors()) {
            return "form1";
        }
        return "redirect:/results";
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @ResponseBody
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

    @ResponseBody
    @RequestMapping("/greeting")
    //@GetMapping("/greeting")
    public Student01 testhateoas(@RequestParam(value = "name",required = false,defaultValue = "name1") String name,
                                        @RequestParam(value = "age",required = false,defaultValue = "0")long age,
                                        @RequestParam(value = "clz",required = false,defaultValue = "clz1")String clz){
        Student01 student01 = new Student01(age,name,clz);
        student01.add(linkTo(methodOn(HelloController.class).testhateoas(name,age,clz)).withSelfRel());
        //return new ResponseEntity<>(student01, HttpStatus.OK);
        return student01;
    }
    @ResponseBody
    @RequestMapping("/greeting2")
    //@GetMapping("/greeting")
    public Student01 testhateoas2(@RequestParam(value = "name",required = false,defaultValue = "name1") String name,
                                        @RequestParam(value = "age",required = false,defaultValue = "0")long age,
                                        @RequestParam(value = "clz",required = false,defaultValue = "clz1")String clz){
        Student01 student01 = new Student01(age,name,clz);
        student01.add(new Link("啊哈哈"));
        //return new ResponseEntity<>(student01, HttpStatus.OK);
        return student01;
    }

    @ResponseBody
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

    //@Autowired
    private JobLauncher jobLauncher;
    //@Resource(name="importUserJob1")
    private Job job;

    //改为请求方式调用springbatch
    @GetMapping("/runJob")
    @ResponseBody
    public String runJob(){
        JobParameters title = new JobParametersBuilder().addLong("title", System.currentTimeMillis()).toJobParameters();
        try {
            JobExecution run = jobLauncher.run(job, title);
            //run.getStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功调用";
    }


    @Autowired
    private PersonRepository personRepository;

    @ResponseBody
    @GetMapping("/testGemFile01")
    public String testGemFile01(){
        Person02 alice = new Person02("Adult Alice", 40);
        Person02 bob = new Person02("Baby Bob", 1);
        Person02 carol = new Person02("Teen Carol", 13);

        System.out.println("Before accessing data in Apache Geode...");

        asList(alice, bob, carol).forEach(person -> System.out.println("\t" + person));

        System.out.println("Saving Alice, Bob and Carol to Pivotal GemFire...");

        personRepository.save(alice);
        personRepository.save(bob);
        personRepository.save(carol);

        System.out.println("Lookup each person by name...");

        asList(alice.getName(), bob.getName(), carol.getName())
            .forEach(name -> System.out.println("\t" + personRepository.findByName(name)));

        System.out.println("Query adults (over 18):");

        stream(personRepository.findByAgeGreaterThan(18).spliterator(), false)
            .forEach(person -> System.out.println("\t" + person));

        System.out.println("Query babies (less than 5):");

        stream(personRepository.findByAgeLessThan(5).spliterator(), false)
            .forEach(person -> System.out.println("\t" + person));

        System.out.println("Query teens (between 12 and 20):");

        stream(personRepository.findByAgeGreaterThanAndAgeLessThan(12, 20).spliterator(), false)
            .forEach(person -> System.out.println("\t" + person));

        return "success";
    }

    @Autowired
    private CustomerRepository repository;

    @ResponseBody
    @GetMapping("/mongo/01")
    public String mongoDbTest01(){
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

        return "MONGODBSUCCESS";
    }



}
