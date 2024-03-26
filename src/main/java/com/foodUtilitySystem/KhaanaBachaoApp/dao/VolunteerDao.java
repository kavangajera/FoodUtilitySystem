package com.foodUtilitySystem.KhaanaBachaoApp.dao;

import java.util.List;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.Volunteer;

public interface VolunteerDao {
    List<Volunteer>findByCity(String city);
    void donateFood(Volunteer v,int qty);
    void donateMoney(Volunteer v,double amount);
    void addRequest(Volunteer v);
}
