package com.erayt.web01;

import com.erayt.web01.domain.Person;
import com.erayt.web01.domain.Person02;
import com.erayt.web01.repository.PersonRepository;
import com.erayt.web01.service.impl.StudentServiceImpl;
import com.erayt.web01.service.storage.StorageProperties;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import static java.util.Arrays.asList;
import static java.util.stream.StreamSupport.stream;

import java.io.IOException;
import java.util.Arrays;

@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling
@SpringBootApplication
@EnableJms
@ClientCacheApplication(name = "AccessingDataGemFireApplication")
@EnableEntityDefinedRegions(
    basePackageClasses = Person02.class,
    clientRegionShortcut = ClientRegionShortcut.LOCAL
)
@EnableGemfireRepositories
//@ImportResource("/integration/integration.xml")
//@MapperScan
public class Web01Application {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext run = SpringApplication.run(Web01Application.class, args);


        //SpringApplication.exit(run);

/*        ConfigurableApplicationContext run = SpringApplication.run(Web01Application.class, args);

        System.out.println(run.containsBean("student"));
        System.out.println(run.containsBean("student2"));
        System.out.println(run.containsBean("redisConnectionFactory"));
        StudentServiceImpl studentService = (StudentServiceImpl) run.getBean("studentServiceImpl");*/
        //studentService.findStudent(1);
    }

    /**
     * 服务器启动后执行该方法，服务器启动的后置处理。
     * @param ctx
     * @return
     */
    @Bean
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
