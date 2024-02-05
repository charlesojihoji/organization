package com.org.info.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.info.entity.Employee;
import com.org.info.entity.Organization;
import com.org.info.service.OrgService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

	@Autowired
	private OrgService orgService;
	
	@PostMapping("/manageorg")
	public String manageOrganization(@RequestBody Employee emp) {
		
		orgService.incrementEmpCount(emp);
		
		return "Employee count added successfully in the organization database";
	}
	
	@GetMapping("/allOrg")
	public ResponseEntity<List<Organization>> getAllOrganizations() {
		
		return ResponseEntity.ok(orgService.getAllOrganizations());
		
	}
}
