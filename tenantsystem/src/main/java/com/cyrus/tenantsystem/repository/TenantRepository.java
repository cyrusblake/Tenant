package com.cyrus.tenantsystem.repository;

import com.cyrus.tenantsystem.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
}
