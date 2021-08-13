package com.erayt.web01;

import com.erayt.web01.service.impl.StudentServiceImpl;
import com.erayt.web01.service.storage.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling
@SpringBootApplication
public class Web01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Web01Application.class, args);

        boolean student1 = run.containsBean("student");
        System.out.println(student1);
        boolean student2 = run.containsBean("student2");
        System.out.println(student2);
        StudentServiceImpl studentService = (StudentServiceImpl) run.getBean("studentServiceImpl");
        //studentService.findStudent(1);
    }

    /**
     * 服务器启动后执行该方法，服务器启动的后置处理。
     * @param ctx
     * @return
     */
    //@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

}
