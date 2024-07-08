package com.walker.ecommerce;

import com.walker.ecommerce.controller.AccessController;
import com.walker.ecommerce.model.Access;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ECommerceApplication.class)
public class ECommerceApplicationTests {

	@Autowired
	private AccessController accessController;

	@Test
	@DisplayName("Testa se a API registra um novo acesso")
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
