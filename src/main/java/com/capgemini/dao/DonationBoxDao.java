package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.DonationBox;

@Repository
public interface DonationBoxDao extends JpaRepository<DonationBox, String>{

}
