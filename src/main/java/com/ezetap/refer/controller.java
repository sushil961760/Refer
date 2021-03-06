package com.ezetap.refer;

import org.springframework.beans.factory.annotation.Autowired;
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
        User user=repo.findByMobileNumber(id.getId());

        return user.getReferralCode();
    }

    @PostMapping("applyreferral")
    public Response applyReferral(@RequestBody Apply data){
        Response resp=new Response();
        User u3=repo.findByMobileNumber(data.getMobileNumber());
        User u2=repo.findByReferralCode(data.getReferral());

        if(u3.getApplied()){
            resp.setResponse(false);
            return resp;
        }
        Random rand=new Random();
        int random11=rand.nextInt(1000);
        int random12=rand.nextInt(1000);
        String random1=Integer.toString(rand.nextInt());
        String random2=Integer.toString(rand.nextInt());
        Scratch card1=new Scratch(false,random11,"Yes",random1,u2.getMobileNumber());
        Scratch card2=new Scratch(false,random12,"Yes",random2,u3.getMobileNumber());
        repos.save(card1);
        repos.save(card2);
        resp.setResponse(true);
        return resp;
    }

    @PostMapping("/fetch")
    public List<Scratch> fetch(@RequestBody Read id){
        List<Scratch> list=new ArrayList<>();
        for(int i=0;i<repos.findAll().size();i++){
            if(repos.findAll().get(i).getUserId().equals(id.getId())){
                list.add(repos.findAll().get(i));
            }
        }
        User user1=repo.findByMobileNumber(id.getId());
        return list;
    }

    @PostMapping("/Updatereward")
    public Response updateReward(@RequestBody Reader id) {
        Optional<Scratch> scratch=repos.findById(id.getId());
        Scratch scratch1=scratch.get();
        scratch1.setScratched(true);
        Response resp=new Response();
        resp.setResponse(true);
        return resp;
    }

}