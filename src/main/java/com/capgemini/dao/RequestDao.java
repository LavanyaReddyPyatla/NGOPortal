package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;

public interface RequestDao extends JpaRepository<Request, Integer> {
	List<Request> findAllById(Integer id);
	List<Request> findByNeedyPeople(NeedyPeople needyPeople);
	
	//@EntityGraph(value = "Request.needyPeople", type = EntityGraphType.FETCH)

	@Query("from Request r inner join fetch r.needyPeople where r.needyPeople.needyPersonId = :id")
	List<Request> findByNeedyPeopleId(@Param("id") int id);

}
