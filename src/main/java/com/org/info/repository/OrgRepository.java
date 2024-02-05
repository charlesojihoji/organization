package com.org.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.info.entity.Organization;


public interface OrgRepository extends JpaRepository<Organization, Long> {

    public Organization findByOrgName(String orgName);
}
