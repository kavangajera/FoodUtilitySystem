package com.foodUtilitySystem.KhaanaBachaoApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="volunteer_details")
public class Volunteer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name="username")
	private String uname;
	
	@Column(name="city")
	private String city;
	@Column(name="food_name")
	private String foodName;
	@Column(name="quantity")
	private int qty;
	@Column(name="due_date")
	private String dueDate;
	public Volunteer() {
		
	}
	public Volunteer(String uname, String city, String foodName, int qty, String dueDate) {
		super();
		this.uname = uname;
		this.city = city;
		this.foodName = foodName;
		this.qty = qty;
		this.dueDate = dueDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", uname=" + uname + ", city=" + city + ", foodName=" + foodName + ", qty=" + qty
				+ ", dueDate=" + dueDate + "]";
	}
	
	
}
