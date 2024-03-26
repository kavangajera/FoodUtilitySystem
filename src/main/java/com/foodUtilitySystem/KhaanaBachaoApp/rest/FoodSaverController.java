package com.foodUtilitySystem.KhaanaBachaoApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.FoodSavers;
import com.foodUtilitySystem.KhaanaBachaoApp.service.foodSaverService;

@RestController
@RequestMapping("/api")
public class FoodSaverController {
       
	private foodSaverService fs;
	private UserDetailsManager userDetailsManager;
	@Autowired
	FoodSaverController(foodSaverService fs,UserDetailsManager userDetailsManager){
		this.fs=fs;
		this.userDetailsManager = userDetailsManager;
	}
	
	@GetMapping("/foodSavers")
	public List<FoodSavers>getAllFS(){
		return fs.findAll();
	}
	
	@GetMapping("/foodSavers/{fs_id}")
	public FoodSavers getById(@PathVariable int fs_id) {
		return fs.findById(fs_id);
	}
	
	@PostMapping("/foodSavers")
	public FoodSavers createFS(@RequestBody FoodSavers foodSaver) {
		foodSaver.setId(0);
		FoodSavers newFs = fs.save(foodSaver);
		UserDetails f_saver = User.withUsername(newFs.getUname())
				.password("{bcrypt}"+hashPassword(newFs.getPassword()))
				.roles(newFs.getRole().toUpperCase())
				.build();
		userDetailsManager.createUser(f_saver); 
		return newFs;
	}
	
	@PutMapping("/foodSavers")
	public FoodSavers updateFS(@RequestBody FoodSavers foodSaver) {
		FoodSavers newFs = fs.save(foodSaver);
		return newFs;
	}
	
	@DeleteMapping("/foodSavers/{fs_id}")
	public String deleteFS(@PathVariable int fs_id) {
		FoodSavers foodSaver = fs.findById(fs_id);
		if(foodSaver==null) {
			throw new RuntimeException("FoodSaver NOT Found!!!");
		}
		fs.deleteById(fs_id);
		return "FoodSaver Deleted with id - "+fs_id;
	}
	
	//hashing
	private String hashPassword(String password) {
	    String salt = BCrypt.gensalt();
	    return BCrypt.hashpw(password, salt);
	}
	
}
