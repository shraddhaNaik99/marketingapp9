package com.marketingapp9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp9.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
