package com.RestAPI.SpringRest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RestAPI.SpringRest.Entities.student;

public interface StudentRepository extends JpaRepository<student, Integer> {

}
