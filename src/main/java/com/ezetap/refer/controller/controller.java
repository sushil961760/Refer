package com.ezetap.refer.controller;
import com.ezetap.refer.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;
@RestController
public class controller {
    @Autowired
    userRepository repo;
    List<User> userList = repo.findAll();

    scratchRepository repos;
    List<Scratch> scratchList = repos.findAll();

    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/getmyreferral")
    public String getReferral(@RequestBody String id) {
        int size = repo.findAll().size();
        String referralcode = "";
        for (int i = 0; i < size; i++) {
            if (id.equals(userList.get(i).getId().toString())) {
                referralcode = userList.get(i).getMerchant_name() + id;
                return referralcode;
            }
        }
        return referralcode;
    }


    @PostMapping("/Updatereward")
    public boolean updateReward(@RequestBody String id) {
        int size = repos.findAll().size();
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (id.equals(scratchList.get(i).getId().toString())) {
                return scratchList.get(i).isStatus();
            }
        }
        return status;
    }

}