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
                referralcode = userList.get(i).getReferralCode();
                return referralcode;
            }
        }
        return referralcode;
    }

    @PostMapping("applyreferral")
    public boolean applyReferral(@RequestBody String data){
        String id="";
        User user=new User();
        int size=repo.findAll().size();
        for(int i=0;i<size;i++){
            if(userList.get(i).getApplied()){
                return false;
            }
            if(!userList.get(i).getApplied()){
                userList.get(i).setApplied(true);
                break;
            }
        }
        Random rand=new Random();
        int random=rand.nextInt(1000);
        Scratch card=new Scratch(true,random,"Yes","123",user);
        user.getScratchCards().add(card);
        return true;
    }

    @PostMapping("/fetch")
    public List<Scratch> fetch(@RequestBody String id){
        int size = repo.findAll().size();
        String referralcode = "";
        for (int i = 0; i < size; i++) {
            if (id.equals(userList.get(i).getId().toString())) {
                return userList.get(i).getScratchCards();
            }
        }
        List<Scratch> cards=new ArrayList<>();
        return cards;
    }

    @PostMapping("/Updatereward")
    public boolean updateReward(@RequestBody String id) {
        int size = repos.findAll().size();
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (id.equals(scratchList.get(i).getId().toString())) {
                return scratchList.get(i).getScratched();
            }
        }
        return status;
    }

}