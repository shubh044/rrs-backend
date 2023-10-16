package com.capg.paymentgateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.capg.paymentgateway.dto.Order;

@SpringBootTest
class PaymentGatewayApplicationTests {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}
	
	@Test
    public void testPayment() {
        // Create an Order object with appropriate data
        Order order = new Order();
        order.setPrice(100.0);
        order.setCurrency("USD");
        order.setMethod("paypal");
        order.setIntent("sale");
        order.setDescription("Test payment");

        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:" + port + "/pay", order, String.class);

        // Add assertions to verify the response as needed
        // For example, you can assert that the response should contain "redirect:"
    }

}
