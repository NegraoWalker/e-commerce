package com.walker.ecommerce;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.walker.ecommerce.controller.AccessController;
import com.walker.ecommerce.model.Access;
import com.walker.ecommerce.repository.AccessRepository;
import com.walker.ecommerce.service.AccessService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ECommerceApplicationTests {

    @Autowired
    private AccessController accessController;
    @Autowired
    private AccessService accessService;
    @Autowired
    private AccessRepository accessRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Test
    @DisplayName("Testa se a API registra um novo acesso")
    public void testRestApiRegistrationAccess() throws Exception {
        DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);
        MockMvc mockMvc = defaultMockMvcBuilder.build();

        Access access = new Access();
        access.setDescription("ROLE_ADMIN_MOCK_TEST");

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.post("/cadastrar-acesso")
                        .content(objectMapper.writeValueAsString(access))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));

        System.out.println("Retorno da API: " + resultActions.andReturn().getResponse().getContentAsString());
    }


    @Test
    @DisplayName("Testa se o controlador da API registra um novo acesso")
    public void testRegistrationAccess() {
        Access access = new Access();
        access.setDescription("ROLE_ADMIN_TEST_JUNIT");
        ResponseEntity<Access> responseEntity = accessController.registerAccess(access);
        assertNotNull(responseEntity); // Verifica se o responseEntity não é nulo

        Access registerAccess = responseEntity.getBody();
        assertTrue(registerAccess.getId() > 0);
        assertEquals("ROLE_ADMIN_TEST_JUNIT",registerAccess.getAuthority());
    }
    
}