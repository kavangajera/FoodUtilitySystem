package com.foodUtilitySystem.KhaanaBachaoApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodUtilitySystem.KhaanaBachaoApp.dao.VolunteerDao;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.Volunteer;

@RestController
@RequestMapping("/api")
public class VolunteerController {
     private VolunteerDao vdao;
     
     @Autowired
     VolunteerController(VolunteerDao vdao){
    	 this.vdao = vdao;
     }
     
     @GetMapping("/volunteers/{city}")
     public List<Volunteer>findAllByCity(@PathVariable String city){
    	 return vdao.findByCity(city);
     }
     
     @PutMapping("/volunteers/food/{qty}")
     public String donateFood(@RequestBody Volunteer v,@PathVariable int qty) {
    	 vdao.donateFood(v, qty);
    	 return "Donated food - "+v.getFoodName()+" of qty - "+qty;
     }
     
     @PostMapping("/volunteers")
     public String addReq(@RequestBody Volunteer v) {
    	 vdao.addRequest(v);
    	 return "Requst Added!";
     }
     
     @PutMapping("/volunteers/money/{money}")
     public String donateMoney(@RequestBody Volunteer v,@PathVariable double money) {
    	 vdao.donateMoney(v, money);
    	 return "Donated Rs."+money;
     }
     @GetMapping("/volunteers")
     public List<Volunteer> showProfile() {
    		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		 String vol = auth.getName();
    		 return vdao.findByName(vol);
    	 }
     @DeleteMapping("/volunteers/{v_id}")
     public String deleteById(@PathVariable int v_id) {
    	 vdao.deleteById(v_id);
    	 return "Volunteer with Request id - "+v_id+" is Deleted !";
     }
     
}
