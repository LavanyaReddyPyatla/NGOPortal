package com.capgemini.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.NeedyPeople;

@Repository
public interface NeedyPeopleDao extends JpaRepository<NeedyPeople, Integer> {

	List<NeedyPeople> findByNeedyPersonName(String name);

	Optional<NeedyPeople> findByPhone(String phone);

	Optional<NeedyPeople> findByEmail(String email);
}