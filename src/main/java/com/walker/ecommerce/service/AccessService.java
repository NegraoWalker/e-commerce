package com.walker.ecommerce.service;

import com.walker.ecommerce.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {
    @Autowired
    private AccessRepository accessRepository;
}
