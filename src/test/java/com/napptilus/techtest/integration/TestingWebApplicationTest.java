package com.napptilus.techtest.integration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.napptilus.techtest.model.Precio;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingWebApplicationTest {

	private String baseUrl = "http://localhost";

	@LocalServerPort
	private int port;

	private static RestTemplate restTemplate = null;

	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "").concat("/api");
	}

	@Test
	public void getPrecioTest() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// body
		
		String body = "{\"appDate\" : \"2020-06-14-10.00.00\",  \"productId\" : 35455, \"brandId\" : 1}";
		HttpEntity<String> entity = new HttpEntity<String>(body, headers);

		ResponseEntity<Precio> err = restTemplate.exchange(baseUrl.concat("/Precio"), HttpMethod.GET, entity,
				Precio.class);

		assertAll(() -> assertNotNull(err), () -> assertEquals(HttpStatus.NOT_FOUND, err.getStatusCode()),
				() -> assertNull(err.getBody()));
	}

//	@Test
//	public void getPrecioTest() throws Exception {
//		// Arrange
//		String json = "{\"appDate\": \"2020-06-14-10.00.00\",  \"productId\": 35455,\"brandId\": 1}";
//		var task = restTemplate.getForObject("http://localhost:" + port + "/Precio/", Precio.class);
//		// .andExpect(content().json("{\"productId\": 35455,\"brandId\":
//		// 4,\"priceList\": 1,\"startDate\": \"2020-06-14-05.00.00\",\"endDate\":
//		// \"2021-01-01-04.59.59\",\"price\": 36}"));
//	}

}
