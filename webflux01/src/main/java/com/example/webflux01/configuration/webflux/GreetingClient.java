package com.example.webflux01.configuration.webflux;

import com.example.webflux01.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Auther: Z151
 * @Date: 2021/8/27 14:26
 */
@Component
public class GreetingClient {

    private final WebClient webClient;

    public GreetingClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getMessage() {
        Mono<String> map = this.webClient.get().uri("/hello").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Greeting.class)
            .map(Greeting::getMessage);
        return map;

    }
}
