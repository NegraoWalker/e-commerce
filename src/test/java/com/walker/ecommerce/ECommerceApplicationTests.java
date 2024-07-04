package com.walker.ecommerce;

import com.walker.ecommerce.controller.AccessController;
import com.walker.ecommerce.model.Access;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ECommerceApplication.class)
class ECommerceApplicationTests {
	@Autowired
	private AccessController accessController;

	@Test
	public void testRegistrationAccess() {
		Access access = new Access();
		access.setDescription("ROLE_ADMIN");
		accessController.saveAccess(access);
	}

}
