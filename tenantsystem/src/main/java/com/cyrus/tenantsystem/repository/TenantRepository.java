package com.cyrus.tenantsystem.repository;

import com.cyrus.tenantsystem.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {


    Optional<Tenant> findAllById(Integer id);


}
