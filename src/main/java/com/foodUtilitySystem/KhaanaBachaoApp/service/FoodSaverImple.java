package com.foodUtilitySystem.KhaanaBachaoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodUtilitySystem.KhaanaBachaoApp.dao.FoodSaverRepository;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.FoodSavers;


import jakarta.transaction.Transactional;

@Service
public class FoodSaverImple implements foodSaverService{

	private FoodSaverRepository fs;
	
	@Autowired
	FoodSaverImple(FoodSaverRepository fs){
		this.fs = fs;
	}
	
	@Override
	public List<FoodSavers> findAll() {
		// TODO Auto-generated method stub
		return fs.findAll();
	}

	@Override
	public FoodSavers findById(int id) {
		// TODO Auto-generated method stub
		Optional<FoodSavers> foodSaver = fs.findById(id);
		FoodSavers theFoodSaver =null;
		if(foodSaver.isPresent()) {
			theFoodSaver = foodSaver.get();
		}
		else {
			throw new RuntimeException("FoodSaver not found");
		}
		return theFoodSaver;
		}

	@Override
	@Transactional
	public FoodSavers save(FoodSavers foodSaver) {
		// TODO Auto-generated method stub
		return fs.save(foodSaver);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub 
		fs.deleteById(id);
		
	}
       
}
