package com.ezetap.refer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;

@RestController
public class controller {

    @Autowired
    private static userRepositoryImpl repo;




    @Autowired
    private static scratchRepositoryImpl repos;



    @GetMapping("/home")
    public String home() {


        return "sf";
    }

    @PostMapping("/getmyreferral")
    public String getReferral(@RequestBody String id) {
        List<User> userList = repo.findAll();
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
        List<User> userList = repo.findAll();
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
        List<User> userList = repo.findAll();
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
        List<Scratch> scratchList = repos.findAll();
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