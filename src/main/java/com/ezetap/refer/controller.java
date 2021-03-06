package com.ezetap.refer;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;

@RestController
public class controller {

    @Autowired
    private userRepository repo;

    @Autowired
    private scratchRepository repos;


    @PostMapping("/getmyreferral")
    public String getReferral(@RequestBody Read id) {
        Optional<User> user=repo.findById(id.getId());
        User user1=user.get();
        return user1.getReferralCode();

    }

    @PostMapping("applyreferral")
    public boolean applyReferral(@RequestBody Apply data){
        Optional<User> u1=repo.findById(data.getId());
        User u2=repo.findByReferralCode(data.getReferral());
        User u3=u1.get();
        if(u3.getApplied()){return false;}
        Random rand=new Random();
        int random11=rand.nextInt(1000);
        int random12=rand.nextInt(1000);
        String random1=Integer.toString(rand.nextInt());
        String random2=Integer.toString(rand.nextInt());
        Scratch card1=new Scratch(false,random11,"Yes",random1,u2);
        Scratch card2=new Scratch(false,random12,"Yes",random2,u3);

        repos.save(card1);
        repos.save(card2);
        return true;
    }

    @PostMapping("/fetch")
    public List<Scratch> fetch(@RequestBody Read id){
        Optional<User> user1=repo.findById(id.getId());
        User user=user1.get();
        return user.getScratchCards();

    }

    @PostMapping("/Updatereward")
    public boolean updateReward(@RequestBody Read id) {
        Optional<Scratch> scratch=repos.findById(id.getId());
        Scratch scratch1=scratch.get();
        scratch1.setScratched(true);
        return scratch1.getScratched();
    }

}