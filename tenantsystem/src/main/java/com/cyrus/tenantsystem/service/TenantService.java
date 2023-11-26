package com.cyrus.tenantsystem.service;

import com.cyrus.tenantsystem.model.Tenant;

import java.util.List;
import java.util.Optional;

public interface TenantService {

    public Tenant saveTenant(Tenant tenant);

    public Optional<Tenant> getTenant(Integer id);

    public List<Tenant> getAlltenants();

    public void updateTenant(int id, Tenant tenant);

    public void DeleteTenant(int id);
}
