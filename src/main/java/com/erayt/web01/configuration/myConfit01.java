package com.erayt.web01.configuration;

import com.erayt.web01.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Auther: Z151
 * @Date: 2021/8/11 16:32
 */
@Component
public class myConfit01 {
    private static final Logger log = LoggerFactory.getLogger(myConfit01.class);
    class  student{
        private String name ;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    @Bean
    private student student(){

        student student = new student();
        student.setAge("11");
        student.setAge("张三");
        return student;
    }
    //@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    //@Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

        return args -> {
            log.info("开始执行后置函数。");
            Quote quote = restTemplate.getForObject(
                "https://quoters.apps.pcfone.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
