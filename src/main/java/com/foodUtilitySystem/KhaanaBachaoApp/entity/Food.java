package com.foodUtilitySystem.KhaanaBachaoApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="food_details")
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	@Column(name="food_name")
	private String foodName;
	@Column(name="description")
	private String description;
	@Column(name="scoville_scale")
	private String spicy_level;
	
	Food(){
		
	}
	
	
	public Food(String foodName, String description, String spicy_level) {
		super();
		this.foodName = foodName;
		this.description = description;
		this.spicy_level = spicy_level;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpicy_level() {
		return spicy_level;
	}
	public void setSpicy_level(String spicy_level) {
		this.spicy_level = spicy_level;
	}


	@Override
	public String toString() {
		return "Food [id=" + id + ", foodName=" + foodName + ", description=" + description + ", spicy_level="
				+ spicy_level + "]";
	}
	
}
