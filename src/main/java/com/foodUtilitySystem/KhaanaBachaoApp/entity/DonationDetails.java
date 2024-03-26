package com.foodUtilitySystem.KhaanaBachaoApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="donation_details")
public class DonationDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
    @Column(name="donor")
    private String donor;
	
	@Column(name="history")
	private String history;
	
	public DonationDetails() {
		
	}

	public DonationDetails( String donor, String history) {
		super();
		this.donor = donor;
		this.history = history;
	}

	public String getDonor() {
		return donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public DonationDetails(int volId, String history) {
		super();
		
		this.history = history;
	}

	@Override
	public String toString() {
		return "DonationDetails [id=" + id + ", donor=" + donor + ", history=" + history + "]";
	}
	
}
