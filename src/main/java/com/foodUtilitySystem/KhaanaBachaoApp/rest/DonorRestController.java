package com.foodUtilitySystem.KhaanaBachaoApp.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodUtilitySystem.KhaanaBachaoApp.dao.DonationDetailsDAO;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationDetails;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationReceived;

@RestController
@RequestMapping("/api")
public class DonorRestController {
      
	private DonationDetailsDAO donorDao;
	public DonorRestController(DonationDetailsDAO donorDao){
		this.donorDao = donorDao;
	}
	
	@GetMapping("/donors")
	public List<DonationDetails> getAll(){
		return donorDao.showMyDonations();
	}
	
	@GetMapping("/received")
	public List<DonationReceived> getReceivedAll(){
		return donorDao.showReceived();
	}
}
