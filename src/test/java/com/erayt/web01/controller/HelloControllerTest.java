package com.erayt.web01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Auther: Z151
 * @Date: 2021/8/11 17:22
 */
//@SpringBootTest
//@AutoConfigureMockMvc
class HelloControllerTest {

    //@Autowired
    private MockMvc mvc;


    public void seHello() throws Exception {

/*        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("Greetings from Spring Boot!"));*/
    }

}