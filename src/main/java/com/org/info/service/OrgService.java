package com.org.info.service;

import java.util.List;

import com.org.info.entity.Employee;
import com.org.info.entity.Organization;

public interface OrgService {

	//public void manageOrg(Employee emp);
	public void incrementEmpCount(Employee employee);

	public List<Organization> getAllOrganizations();

	public Organization findById(Long valueOf);

}
