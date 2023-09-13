package com.hospital.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.manage.entity.Presscription;

public interface PresscriptionRepo extends JpaRepository<Presscription, Long>{

}
