package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Donation;

@Repository
public interface DonationDao extends JpaRepository<Donation, Integer>{

}
