package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.DonationItem;

@Repository
public interface DonationItemDao extends JpaRepository<DonationItem, Integer>{

}
