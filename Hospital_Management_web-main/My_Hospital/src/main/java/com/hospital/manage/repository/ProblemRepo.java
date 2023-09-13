package com.hospital.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.manage.entity.Problem;

public interface ProblemRepo extends JpaRepository<Problem, Long>{

}
