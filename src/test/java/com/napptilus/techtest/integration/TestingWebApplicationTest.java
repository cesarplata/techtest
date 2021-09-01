package com.napptilus.techtest.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.napptilus.techtest.controller.PrecioController;

@SpringBootTest
public class TestingWebApplicationTest {

	@Autowired
	private PrecioController precioController;

	@Test
	public void test1() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(precioController).build();
		String body = "{\"appDate\" : \"2020-06-14-10.00.00\",  \"productId\" : 35455, \"brandId\" : 1}";

		mockMvc.perform(get("/api/Precio").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isOk()).andExpect(content().json(
						"{\"productId\": 35455,\"brandId\":1,\"priceList\": 1,\"startDate\": \"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\": 36}"));
	}

	@Test
	public void test2() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(precioController).build();
		String body = "{\"appDate\" : \"2020-06-14-16.00.00\",  \"productId\" : 35455, \"brandId\" : 1}";

		mockMvc.perform(get("/api/Precio").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isOk()).andExpect(content().json(
						"{\"productId\": 35455,\"brandId\":1,\"priceList\": 2,\"startDate\": \"2020-06-14-15.00.00\",\"endDate\":\"2020-06-14-18.30.00\",\"price\": 25}"));
	}

	@Test
	public void test3() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(precioController).build();
		String body = "{\"appDate\" : \"2020-06-14-21.00.00\",  \"productId\" : 35455, \"brandId\" : 1}";

		mockMvc.perform(get("/api/Precio").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isOk()).andExpect(content().json(
						"{\"productId\": 35455,\"brandId\":1,\"priceList\": 1,\"startDate\": \"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\": 36}"));
	}

	@Test
	public void test4() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(precioController).build();
		String body = "{\"appDate\" : \"2020-06-15-10.00.00\",  \"productId\" : 35455, \"brandId\" : 1}";

		mockMvc.perform(get("/api/Precio").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isOk()).andExpect(content().json(
						"{\"productId\": 35455,\"brandId\":1,\"priceList\": 3,\"startDate\": \"2020-06-15-00.00.00\",\"endDate\":\"2020-06-15-11.00.00\",\"price\": 31}"));
	}

	@Test
	public void test5() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(precioController).build();
		String body = "{\"appDate\" : \"2020-06-16-21.00.00\",  \"productId\" : 35455, \"brandId\" : 1}";

		mockMvc.perform(get("/api/Precio").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isOk()).andExpect(content().json(
						"{\"productId\": 35455,\"brandId\":1,\"priceList\": 4,\"startDate\": \"2020-06-15-16.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\": 39}"));
	}
}