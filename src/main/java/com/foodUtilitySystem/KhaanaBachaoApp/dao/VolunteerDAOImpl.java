package com.foodUtilitySystem.KhaanaBachaoApp.dao;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationDetails;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationReceived;
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
@Lazy
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
		if(volunteers.isEmpty()) {
			throw new FoodSaverNotFoundException("No food requests are made in city - "+city);
		}
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
			String msg ="Date of the food "+v.getFoodName()+" is expired . So kindly remove the request!!";
			DonationReceived dr = new DonationReceived(v.getUname(),msg);
			em.merge(dr);
		}
		
		if(LocalDate.now().compareTo(dueDate)>0) {
			
			throw new FoodSaverNotFoundException("Date is expired!");
		}
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String donor = auth.getName();  
		int curr_qty=v.getQty();
		String uname = v.getUname();
		String msg = "Donated Food: "+v.getFoodName()+" of "+qty+" to "+uname;
		DonationDetails ds = new DonationDetails(donor,msg);
		em.merge(ds);
		
		
		
	    String msg2 = "Received Food: "+v.getFoodName()+" of quantity "+qty+" from"+donor;
	    DonationReceived dr = new DonationReceived(uname,msg2);
		em.merge(dr);
		
		
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
		String msg1 = "Donated Rs."+amount+" to "+uname;
		DonationDetails ds = new DonationDetails(donor,msg1);
		em.merge(ds);
		String vol = uname;
		String msg2 = "Received Rs."+amount+" from "+donor;
		DonationReceived dr = new DonationReceived(vol,msg2);
		em.merge(dr);
	}
	@Override
	@Transactional
	public void addRequest(Volunteer v) {
		// TODO Auto-generated method stub
		em.persist(v);
	}
	@Override
	public List<Volunteer> findByName(String uname) {
		// TODO Auto-generated method stub
		TypedQuery<Volunteer>volunteers = em.createQuery("from Volunteer where uname=:name",Volunteer.class)
				.setParameter("name", uname);
		List<Volunteer>vs = volunteers.getResultList();
		if(vs.isEmpty()) {
			 throw new FoodSaverNotFoundException("You have not made any requests yet");
		}
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
