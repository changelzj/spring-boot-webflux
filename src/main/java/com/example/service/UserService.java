package com.example.service;

import com.example.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {
    Mono<User> findById(Integer id);
    
    Mono<Void> save(Mono<User> user);
    
    Flux<User> getAll();
}
