package com.cyrus.tenantsystem.service;

import com.cyrus.tenantsystem.model.Tenant;

import java.util.List;

public interface TenantService {

    public Tenant saveTenant(Tenant tenant);
    public List<Tenant> getAlltenants();
}
