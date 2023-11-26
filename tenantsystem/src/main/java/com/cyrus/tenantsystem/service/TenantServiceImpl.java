package com.cyrus.tenantsystem.service;

import com.cyrus.tenantsystem.model.Tenant;
import com.cyrus.tenantsystem.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public Optional<Tenant> getTenant(Integer id) {
        return tenantRepository.findById(id);
    }

    @Override
    public List<Tenant> getAlltenants() {
        return tenantRepository.findAll();
    }

    @Override
    public void updateTenant(int id,@Validated Tenant tenant) {
        Optional<Tenant> optionalTenant = tenantRepository.findAllById(id);

        if (optionalTenant.isPresent()){
            Tenant existingTenant = optionalTenant.get();
            existingTenant.setName(tenant.getName());
            existingTenant.setAddress(tenant.getAddress());
            tenantRepository.save(existingTenant);

        }



    }

    @Override
    public void DeleteTenant(int id) {
        tenantRepository.deleteById(id);
    }
}
