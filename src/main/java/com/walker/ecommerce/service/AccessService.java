package com.walker.ecommerce.service;

import com.walker.ecommerce.model.Access;
import com.walker.ecommerce.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {
    @Autowired
    private AccessRepository accessRepository;

    public Access save(Access access) {
        return accessRepository.save(access);
    }
}
