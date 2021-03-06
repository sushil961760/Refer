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

    @GetMapping("/home")
    public String home() {
        return "sf";
    }

    @PostMapping("/getmyreferral")
    public String getReferral(@RequestBody Read id) {
        Read reader=id;
        List<User> userList = repo.findAll();
        int size = repo.findAll().size();
        System.out.println(size);
        String referralcode = "";
        for (int i = 0; i < size; i++) {
            if (reader.getId()==userList.get(i).getId()) {
                referralcode = userList.get(i).getReferralCode();
                return referralcode;
            }
        }
        return referralcode;
    }

    @PostMapping("applyreferral")
    public boolean applyReferral(@RequestBody Apply data){
        List<User> userList = repo.findAll();
        String id="";
        User user=new User();
        int size=repo.findAll().size();
        for(int i=0;i<size;i++){
            if(data.getId()==repo.findAll().get(i).getId()&&userList.get(i).getApplied()){
                return false;
            }
            if(data.getId()==repo.findAll().get(i).getId()&&!userList.get(i).getApplied()){
                userList.get(i).setApplied(true);
                user=repo.findAll().get(i);
                break;
            }
        }
        Random rand=new Random();
        int random=rand.nextInt(1000);
        String random1=Integer.toString(rand.nextInt());
        Scratch card=new Scratch(true,random,"Yes",random1,user);
        user.scratchCards.add(card);
        repo.save(user);
        return true;
    }

    @PostMapping("/fetch")
    public List<Scratch> fetch(@RequestBody Read id){
        Read reader=id;
        List<User> userList = repo.findAll();
        int size = repo.findAll().size();
        String referralcode = "";
        for (int i = 0; i < size; i++) {
            if (reader.getId()==userList.get(i).getId()) {
                return userList.get(i).getScratchCards();
            }
        }
        List<Scratch> cards=new ArrayList<>();
        return cards;
    }

    @PostMapping("/Updatereward")
    public boolean updateReward(@RequestBody Read id) {
        Read reader=id;
        System.out.println(reader.getId());
        List<Scratch> scratchList = repos.findAll();
        int size = repos.findAll().size();
        System.out.println(size);
        boolean status = false;
        for (int i = 0; i < size; i++) {
            System.out.println(scratchList.get(i).getId());
            if (reader.getId()==scratchList.get(i).getId()) {
                System.out.println("inside");
                return scratchList.get(i).getScratched();
            }
        }
        return status;
    }

}