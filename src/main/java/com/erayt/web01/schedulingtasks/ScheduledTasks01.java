package com.erayt.web01.schedulingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 15:54
 */

@Component
public class ScheduledTasks01 {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks01.class);
    private final AtomicLong counter = new AtomicLong();

    /**
     * 在线Cron表达式生成器
     * http://cron.qqe2.com/
     * 1、fixedDelay控制方法执行的间隔时间，是以上一次方法执行完开始算起，如上一次方法执行阻塞住了，那么直到上一次执行完，并间隔给定的时间后，执行下一次。
     * 2、fixedRate是按照一定的速率执行，是从上一次方法执行开始的时间算起，如果上一次方法阻塞住了，下一次也是不会执行，但是在阻塞这段时间内累计应该执行的次数，当不再阻塞时，一下子把这些全部执行掉，而后再按照固定速率继续执行。
     * 3、cron表达式可以定制化执行任务，但是执行的方式是与fixedDelay相近的，也是会按照上一次方法结束时间开始算起。
     * 4、initialDelay 。如： @Scheduled(initialDelay = 10000,fixedRate = 15000
     * 这个定时器就是在上一个的基础上加了一个initialDelay = 10000 意思就是在容器启动后,延迟10秒后再执行一次定时器,以后每15秒再执行一次该定时器。
     * ————————————————
     * 版权声明：本文为CSDN博主「Java程序源」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_34129814/article/details/85090162
     */
    //@Scheduled(fixedRate = 500)
    public Long sc01(){
        log.info("啊哈哈哈哈"+counter.incrementAndGet());
        return counter.incrementAndGet();
    }
}
