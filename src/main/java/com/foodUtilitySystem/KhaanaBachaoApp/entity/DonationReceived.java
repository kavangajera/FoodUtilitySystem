package com.foodUtilitySystem.KhaanaBachaoApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="donation_received")
public class DonationReceived {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name="volunteer")
	private String volunteer;
	@Column(name="history")
	private String history;
	DonationReceived(){
		 
	 }
	public DonationReceived(String volunteer, String history) {
		super();
		this.volunteer = volunteer;
		this.history = history;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(String volunteer) {
		this.volunteer = volunteer;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "DonationReceived [id=" + id + ", volunteer=" + volunteer + ", history=" + history + "]";
	}
	
}
