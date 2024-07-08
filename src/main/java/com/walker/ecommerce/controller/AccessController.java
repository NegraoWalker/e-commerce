package com.walker.ecommerce.controller;

import com.walker.ecommerce.model.Access;
import com.walker.ecommerce.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccessController {
    @Autowired
    private AccessService accessService;

    @ResponseBody //Retorno da API será via Body
    @PostMapping("**/cadastrar-acesso") //URL mapeada para receber um JSON
    public ResponseEntity<Access> registerAccess(@RequestBody Access access) { //Recebe um JSON e transforma para um objeto da classe Access
        Access registerAccess = accessService.save(access);
        return new ResponseEntity<Access>(registerAccess, HttpStatus.OK);
    }
}
