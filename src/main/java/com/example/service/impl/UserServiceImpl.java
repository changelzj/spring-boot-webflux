package com.example.service.impl;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    
    private Map<Integer, User> map = new HashMap<>();
    {
        map.put(1, new User("zzz","m",20));
        map.put(2, new User("eee","m",19));
        map.put(3, new User("vvv","f",25));
        map.put(4, new User("ddd","f",17));
        
        
    }
    
    @Override
    public Mono<User> findById(Integer id) {
        return Mono.justOrEmpty(map.get(id));
    }

    @Override
    public Mono<Void> save(Mono<User> mono) {
        return mono.doOnNext(e -> {
            int id = map.size() + 1;
            map.put(id, e);
        }).thenEmpty(Mono.empty());
    }

    @Override
    public Flux<User> getAll() {
        return Flux.fromIterable(map.values());
    }
}
