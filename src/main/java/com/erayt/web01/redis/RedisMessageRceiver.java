package com.erayt.web01.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: Z151
 * @Date: 2021/8/13 16:02
 */
public class RedisMessageRceiver {

    private static final Logger logger = LoggerFactory.getLogger(RedisMessageRceiver.class);
    private AtomicInteger atomicInteger = new AtomicInteger(0);

        public void myMessageReceiver(String message){
            logger.info("get message from redis:"+message+(new Date()).toString() +"     the numbers:"+atomicInteger.incrementAndGet());
        }


}
