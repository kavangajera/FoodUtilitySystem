package com.foodUtilitySystem.KhaanaBachaoApp.dao;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationDetails;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationReceived;
import com.foodUtilitySystem.KhaanaBachaoApp.rest.FoodSaverNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository
public class DonationDetailsDaoImpl implements DonationDetailsDAO{

	private EntityManager em;
	DonationDetailsDaoImpl(EntityManager em){
		this.em = em;
	}
	@Override
	public List<DonationDetails> showMyDonations() {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String donor = auth.getName();
		List<DonationDetails>details;
		
		TypedQuery<DonationDetails>ql = em.createQuery("from DonationDetails d where d.donor=:name",DonationDetails.class)
		.setParameter("name",donor);
		details = ql.getResultList();
		
        if(details.isEmpty()) {
		throw new FoodSaverNotFoundException("You have not donated yet");
        }
		return details;	
	}
	@Override
	public List<DonationReceived> showReceived() {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String vol = auth.getName();
		List<DonationReceived>details;
		
		TypedQuery<DonationReceived>ql = em.createQuery("from DonationReceived d where d.volunteer=:name",DonationReceived.class)
		.setParameter("name",vol);
		details = ql.getResultList();
		
        if(details.isEmpty()) {
		throw new FoodSaverNotFoundException("You have not received any donations yet");
        }
		return details;	
	}

}
