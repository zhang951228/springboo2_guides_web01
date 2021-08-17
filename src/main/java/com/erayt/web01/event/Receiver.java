package com.erayt.web01.event;

import com.erayt.web01.domain.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: Z151
 * @Date: 2021/8/16 23:05
 */
@Component
public class Receiver {
    @JmsListener(destination = "myqueue",containerFactory = "myFactory01")
    public void receiverEmail(Email email){
        System.out.println(" this is Receiver.receiverEmail method :"+email);
    }
}
