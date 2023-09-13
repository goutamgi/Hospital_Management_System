package com.hospital.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.manage.entity.Admission;

public interface AdmissionRepo extends JpaRepository<Admission, Long> {

}
