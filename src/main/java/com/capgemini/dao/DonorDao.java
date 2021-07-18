package com.capgemini.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Donor;

@Repository
public interface DonorDao extends JpaRepository<Donor, Integer> {

	Optional<Donor> findByDonorEmail(String donorEmail);
}
