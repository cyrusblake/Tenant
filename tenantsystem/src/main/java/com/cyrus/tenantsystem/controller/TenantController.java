package com.cyrus.tenantsystem.controller;

import com.cyrus.tenantsystem.model.Tenant;
import com.cyrus.tenantsystem.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
@CrossOrigin
public class TenantController {
    @Autowired
    private TenantService tenantService;

    @PostMapping("/add")
    public String add(@RequestBody Tenant tenant){
        tenantService.saveTenant(tenant);
        return "New tenant is added";

    }

    @GetMapping("/getAll")
    public List<Tenant> getAlltenants(){
        return tenantService.getAlltenants();
    }
}
