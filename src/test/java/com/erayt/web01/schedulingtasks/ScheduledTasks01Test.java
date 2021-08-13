package com.erayt.web01.schedulingtasks;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 16:05
 */
@SpringBootTest
class ScheduledTasks01Test {

    @Test
    public void test01(){
        ScheduledTasks01 scheduledTasks01 = new ScheduledTasks01();

        Awaitility.await().atMost(6000, MILLISECONDS).until(() ->
            scheduledTasks01.sc01().equals(1000L));
    }
}