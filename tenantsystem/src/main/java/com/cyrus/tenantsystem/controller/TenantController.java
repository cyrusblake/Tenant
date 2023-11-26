package com.cyrus.tenantsystem.controller;

import com.cyrus.tenantsystem.model.Tenant;
import com.cyrus.tenantsystem.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/find/{id}")
    public Optional<Tenant> getTenant(@PathVariable("id") Integer id){
        return tenantService.getTenant(id);
    }

    @GetMapping("/getAll")
    public List<Tenant> getAlltenants(){
        return tenantService.getAlltenants();
    }

    @PutMapping("/put/{id}")
    public void update(@PathVariable(value ="id") int id, @Validated @RequestBody Tenant tenant){
        tenantService.updateTenant(id, tenant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        tenantService.DeleteTenant(id);
    }

}
