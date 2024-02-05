package com.org.info.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.info.entity.Employee;
import com.org.info.entity.Organization;
import com.org.info.repository.OrgRepository;

@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgRepository orgRepository;

	public void incrementEmpCount(Employee employee) {

		Organization org = orgRepository.findByOrgName(employee.getOrgName());

		if (org != null) {
			org.setEmpCount(org.getEmpCount() + 1);
			orgRepository.save(org);
		} else {
			// Handle the case where the organization does not exist for the employee
			//So save the new record of the new organization
			
			Organization newOrg = new Organization(employee.getOrgName(), 1);
			newOrg.setId(1L);
			
			orgRepository.save(newOrg);
			System.out.print("saved");
		List<Organization> orgList=	orgRepository.findAll();
		System.out.print("orgList");
			
		}
	}

	@Override
	public List<Organization> getAllOrganizations() {

		List<Organization> theList = null;
		
		try {
			
			theList = orgRepository.findAll();
		
		}catch(Exception e) {
			
			throw new InternalError();
		}
		return theList;
	}

	@Override
	public Organization findById(Long valueOf) {

		return orgRepository.findById(valueOf).get();
		
	}
}
