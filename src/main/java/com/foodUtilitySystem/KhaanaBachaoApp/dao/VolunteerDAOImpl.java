package com.foodUtilitySystem.KhaanaBachaoApp.dao;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationDetails;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.Volunteer;
import com.foodUtilitySystem.KhaanaBachaoApp.rest.FoodSaverNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
@Repository
public class VolunteerDAOImpl implements VolunteerDao{

	
	private EntityManager em;
	private List<Volunteer>volunteers;
	@Autowired
	VolunteerDAOImpl(EntityManager em){
		this.em = em;
	}
	@Override
	public List<Volunteer> findByCity(String city) {
		// TODO Auto-generated method stub
		TypedQuery<Volunteer>vq = em.createQuery("from Volunteer where city=:city",Volunteer.class);
		vq.setParameter("city",city);
		volunteers = vq.getResultList();
		return volunteers;
	}

	@Override
	@Transactional
	public void donateFood(Volunteer v,int qty) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Volunteer>temp = em.createQuery("from Volunteer v where v.uname=:name",Volunteer.class)
					.setParameter("name",v.getUname());
			List<Volunteer>vs = temp.getResultList();
		}
		catch (NoResultException e) {
		    // Handle the case when no result is found
		    throw new FoodSaverNotFoundException("Volunteer not found with username - " + v.getUname());
		}
		String strdate = v.getDueDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dueDate = LocalDate.parse(strdate, formatter);
		if(LocalDate.now().compareTo(dueDate)>0) {
			throw new FoodSaverNotFoundException("Date is expired!");
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String donor = auth.getName();  
		int curr_qty=v.getQty();
		String uname = v.getUname();
		String msg = "Donated "+v.getFoodName()+" "+qty+" to "+uname;
		DonationDetails ds = new DonationDetails(donor,msg);
		em.merge(ds);
		v.setQty(curr_qty-qty);
		Volunteer v1=em.merge(v);
		
		if(v1.getQty()<=0) {
			em.remove(v1);
		}
	}

	@Override
	@Transactional
	public void donateMoney(Volunteer v,double amount) {
		try {
		TypedQuery<Volunteer>temp = em.createQuery("from Volunteer v where v.uname=:name",Volunteer.class)
				.setParameter("name",v.getUname());
		List<Volunteer>vs = temp.getResultList();
		}
		catch (NoResultException e) {
		    throw new FoodSaverNotFoundException("Volunteer not found with username - " + v.getUname());
		}
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String donor = auth.getName();
		String uname = v.getUname();
		String msg = "Donated Rs."+amount+" to "+uname;
		DonationDetails ds = new DonationDetails(donor,msg);
		em.merge(ds);
	}
	@Override
	@Transactional
	public void addRequest(Volunteer v) {
		// TODO Auto-generated method stub
		em.merge(v);
	}
	@Override
	public List<Volunteer> findByName(String uname) {
		// TODO Auto-generated method stub
		TypedQuery<Volunteer>volunteers = em.createQuery("from Volunteer where uname=:name",Volunteer.class)
				.setParameter("name", uname);
		List<Volunteer>vs = volunteers.getResultList();
		return vs;
	}
	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Volunteer v = em.find(Volunteer.class, id);
		em.remove(v);
	}

}
