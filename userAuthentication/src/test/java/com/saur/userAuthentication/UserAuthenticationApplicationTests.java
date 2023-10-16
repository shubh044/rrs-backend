package com.saur.userAuthentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sau.userAuthentication.controllers.AuthController;
import com.sau.userAuthentication.models.ERole;
import com.sau.userAuthentication.models.Role;
import com.sau.userAuthentication.payload.request.LoginRequest;

@SpringBootTest
class UserAuthenticationApplicationTests {
	
	@Autowired
    private AuthController authController;

	@Test
	void contextLoads() {
	}

	@Test
    void testAuthenticateUser() {
        // Create a sample LoginRequest object for testing
        LoginRequest loginRequest = new LoginRequest("123456","123456");

        // Call the method you want to test
        ResponseEntity<?> responseEntity = authController.authenticateUser(loginRequest);

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // Verify the HTTP status
        assertNotNull(responseEntity.getBody()); // Verify that the response body is not null
    }
	
	@Test
    void testGetRole() {
        // Create a sample Role object for testing
        Role role = new Role();
        role.setId("1");
        role.setName(ERole.USER);
        // Call the method you want to test
        Role savedRole = authController.getrole(role);

        // Assertions
        assertNotNull(savedRole); // Verify that the saved Role object is not null
    }
}
