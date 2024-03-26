package com.foodUtilitySystem.KhaanaBachaoApp.dao;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationDetails;

import jakarta.persistence.EntityManager;
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
		TypedQuery<DonationDetails>ql = em.createQuery("from DonationDetails where donor=:name",DonationDetails.class);
		ql.setParameter("name",donor);
		List<DonationDetails>details = ql.getResultList();
		return details;
	}

}
