package com.foodUtilitySystem.KhaanaBachaoApp.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.FoodSavers;
@Lazy
public interface FoodSaverRepository extends JpaRepository<FoodSavers,Integer>{

}
