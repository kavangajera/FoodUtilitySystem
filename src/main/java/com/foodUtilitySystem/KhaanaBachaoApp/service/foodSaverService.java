package com.foodUtilitySystem.KhaanaBachaoApp.service;

import java.util.List;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.FoodSavers;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.Volunteer;

public interface foodSaverService {
	  // operations for ADMIN
      List<FoodSavers>findAll();
      FoodSavers findById(int id);
      FoodSavers save(FoodSavers fs);
      void deleteById(int id);
}
