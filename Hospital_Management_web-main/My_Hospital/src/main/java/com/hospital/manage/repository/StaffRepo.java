package com.hospital.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.manage.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Long>{
	
	
}
