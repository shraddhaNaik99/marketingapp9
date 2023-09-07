package com.marketingapp9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp9.dto.LeadDto;
import com.marketingapp9.entity.Lead;
import com.marketingapp9.service.LeadService;
import com.marketingapp9.util.EmailService;

@Controller
public class LeadController {
  
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//http://localhost:8080/view
	@RequestMapping("/view")
	public String viewLeadPage() {
		return "create_Lead";
	}
	
	//ModelAttribute binds the form data in entity object, all these methods are called as handler methods. 
//	//http://localhost:8080/saveLead
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@ModelAttribute Lead lead, Model model) {
//		leadService.saveLead(lead);
//		emailService.sendEmail(lead.getEmail(),"Welcome","test");
//		model.addAttribute("msg", "Leaad is saved!!");
//		return "create_Lead";
//	}
	
//	//http://localhost:8080/saveLead
//	@RequestMapping("/saveLead")
//	public String saveOneLead(
//			@RequestParam("firstname") String firstname,
//			@RequestParam("lastname") String lastname,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile,
//			Model model) {
//		
//		Lead lead = new Lead();
//		lead.setFirstname(firstname);
//		lead.setLastname(lastname);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadService.saveLead(lead);
//		emailService.sendEmail(lead.getEmail(),"Welcome","test");
//		model.addAttribute("msg", "Leaad is saved!!");
//		return "create_Lead";
//	}
	
	//http://localhost:8080/saveLead
	@RequestMapping("/saveLead")
	public String saveOneLead(LeadDto dto, Model model) {
		Lead lead = new Lead();
		lead.setFirstname(dto.getFirstname());
		lead.setLastname(dto.getLastname());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(),"Welcome","test");
		model.addAttribute("msg", "Leaad is saved!!");
		return "create_Lead";
	}
	
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		System.out.println(leads);
		return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id")long id,ModelMap model) {
		leadService.deleteLead(id);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		System.out.println(leads);
		return "list_leads";
	}
	
	
	@RequestMapping("/update")
	public String getLeadById(@RequestParam("id")long id,ModelMap model) {
		Lead lead = leadService.getLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	//http://localhost:8080/updateLead
		@RequestMapping("/updateLead")
		public String updateOneLead(Lead lead,Model model) {

			leadService.saveLead(lead);
			List<Lead> leads = leadService.getLeads();
			model.addAttribute("leads", leads);
			return "list_leads";
			
		}
}

