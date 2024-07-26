package com.walker.ecommerce.controller;

import com.walker.ecommerce.exceptions.ExceptionIdNotFound;
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

    @PostMapping("**/cadastrar-acesso") //URL mapeada para receber um JSON
    public ResponseEntity<Access> registerAccess(@RequestBody Access access) { //Recebe um JSON e transforma para um objeto da classe Access
        Access registerAccess = accessService.save(access);
        return new ResponseEntity<Access>(registerAccess, HttpStatus.OK);
    }



////    @GetMapping("**/obter-acesso/{id}")
////    public ResponseEntity<Access> getAccessById(@PathVariable("id") Long id) {
////      Access access = accessService.findById(id).orElse(null);
//        if(access == null) {
//            throw new ExceptionIdNotFound("Não foi encontrado acesso para o id: " + id);
//        }
////    }
}
