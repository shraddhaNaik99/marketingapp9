package com.marketingapp9.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.marketingapp9.entity.Lead;

@Service
public interface LeadService {
	@Bean
   public void saveLead(Lead lead);

public List<Lead> getLeads();

public void deleteLead(long id);

public Lead getLeadById(long id);


}
