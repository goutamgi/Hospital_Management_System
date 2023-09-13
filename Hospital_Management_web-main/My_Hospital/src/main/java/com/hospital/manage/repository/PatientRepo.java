package com.hospital.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.manage.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

	

}
