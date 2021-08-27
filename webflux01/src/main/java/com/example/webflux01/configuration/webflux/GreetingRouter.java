package com.example.webflux01.configuration.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
/**
 * @Auther: Z151
 * @Date: 2021/8/27 14:18
 */
@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(GreetingHandler greetingHandler){
        RouterFunction<ServerResponse> route = RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)),
            greetingHandler::hello);
        return route;
    }

}
