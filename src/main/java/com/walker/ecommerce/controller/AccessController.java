package com.walker.ecommerce.controller;

import com.walker.ecommerce.model.Access;
import com.walker.ecommerce.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {
    @Autowired
    private AccessService accessService;

    @PostMapping("/cadastrar-acesso")
    public Access saveAccess(Access access) {
        return accessService.save(access);
    }
}
