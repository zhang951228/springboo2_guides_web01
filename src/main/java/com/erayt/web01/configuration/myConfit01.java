package com.erayt.web01.configuration;

import com.erayt.web01.domain.Person03;
import com.erayt.web01.domain.Quote;
import com.erayt.web01.repository.Person03Repository02;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import javax.jms.ConnectionFactory;


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

    @Bean
    public JmsListenerContainerFactory<?> myFactory01(CachingConnectionFactory jmsConnectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, jmsConnectionFactory);
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public CommandLineRunner loadDatas(Person03Repository02 person03Repository02){
        return args -> {
            person03Repository02.save(new Person03("Jack", "Bauer"));
            person03Repository02.save(new Person03("Chloe", "O'Brian"));
            person03Repository02.save(new Person03("Kim", "Bauer"));
            person03Repository02.save(new Person03("David", "Palmer"));
            person03Repository02.save(new Person03("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Person03 customer : person03Repository02.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Person03 customer = person03Repository02.findById(1L).get();
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
            log.info("--------------------------------------------");
            for (Person03 bauer : person03Repository02
                .findByLastNameStartsWithIgnoreCase("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");};
    }
}
