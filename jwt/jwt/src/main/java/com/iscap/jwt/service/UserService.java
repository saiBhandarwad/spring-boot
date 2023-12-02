package com.iscap.jwt.service;

import com.iscap.jwt.model.User;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();


    public UserService() {
        store.add(new User(UUID.randomUUID().toString(),"sai","sai@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"ajay","ajay@gmail.com"));
    }
    public List<User> getUsers(){
        return this.store;
    }
}
