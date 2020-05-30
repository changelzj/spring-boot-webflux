package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    @GetMapping("findById/{id}")
    public Mono<User> findById(@PathVariable("id") Integer id) {
        Mono<User> user = userService.findById(id);
        return user;
    }
    
    @GetMapping("list")
    public Flux<User> list(ServerWebExchange exchange) {
        Flux<User> all = userService.getAll();
        return all;
    }

    @GetMapping("save")
    public Mono<Void> save(@RequestBody User user) {
        Mono<Void> res = userService.save(Mono.just(user));
        return res;
    }
}
