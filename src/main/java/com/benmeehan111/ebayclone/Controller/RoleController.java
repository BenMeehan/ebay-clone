package com.benmeehan111.ebayclone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.benmeehan111.ebayclone.Models.Role;
import com.benmeehan111.ebayclone.Services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/add")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }
}
