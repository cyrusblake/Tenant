package com.cyrus.tenantsystem.service;

import com.cyrus.tenantsystem.model.Tenant;
import com.cyrus.tenantsystem.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public List<Tenant> getAlltenants() {
        return tenantRepository.findAll();
    }
}
