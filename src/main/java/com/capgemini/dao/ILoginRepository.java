package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {

}
