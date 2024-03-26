package com.foodUtilitySystem.KhaanaBachaoApp.dao;

import java.util.List;

import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationDetails;
import com.foodUtilitySystem.KhaanaBachaoApp.entity.DonationReceived;

public interface DonationDetailsDAO {
     List<DonationDetails>showMyDonations();
     List<DonationReceived>showReceived();
}
