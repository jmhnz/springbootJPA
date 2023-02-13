package com.springbootpractice.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@Transactional
class PracticeTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllProductsSuccessfully() throws Exception {
		ResultActions result = mockMvc.perform(get("/products"));

		result.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].id").exists())
				.andExpect(jsonPath("$.[0].name").value("product1"))
				.andExpect(jsonPath("$.[0].price").value(1.01));
	}

	@Test
	public void saveProductSuccessfully() throws Exception {
		String body ="{\"name\":\"product\", \"price\":1.11}";

		ResultActions result = mockMvc.perform(post("/products").content(body).contentType(MediaType.APPLICATION_JSON_VALUE));

		result.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").value("product"))
				.andExpect(jsonPath("$.price").value(1.11));
	}

	@Test
	public void saveProductFailedInvalidPrice() throws Exception {
		String body ="{\"name\":\"product\", \"price\":}";

		ResultActions result = mockMvc.perform(post("/products").content(body).contentType(MediaType.APPLICATION_JSON_VALUE));

		result.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.code").value(400));
	}

	@Test
	public void saveProductFailedInvalidctProduName() throws Exception {
		String body ="{\"name\":\"\", \"price\":1}";

		ResultActions result = mockMvc.perform(post("/products").content(body).contentType(MediaType.APPLICATION_JSON_VALUE));

		result.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.code").value(400));
	}

	@Test
	public void saveSaleSuccessfully() throws Exception {
		String body ="{\n" +
				"   \"lineItemsList\":[\n" +
				"      {\n" +
				"         \"productId\":\"1\",\n" +
				"         \"quantity\":\"2\"\n" +
				"      },\n" +
				"      {\n" +
				"         \"productId\":2,\n" +
				"         \"quantity\":2\n" +
				"      }\n" +
				"   ]\n" +
				"}";

		ResultActions result = mockMvc.perform(post("/sales").content(body).contentType(MediaType.APPLICATION_JSON_VALUE));

		result.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("totalPrice").value(6.02))
				.andExpect(jsonPath("saleDiscount").value(0))
				.andExpect(jsonPath("$.lineItemsList[0].productPrice").value(1.01))
				.andExpect(jsonPath("$.lineItemsList[0].quantity").value(2))
				.andExpect(jsonPath("$.lineItemsList[0].subTotal").value(2.02))
				.andExpect(jsonPath("$.lineItemsList[0].itemDiscount").value(0))
				.andExpect(jsonPath("$.lineItemsList[1].productPrice").value(2))
				.andExpect(jsonPath("$.lineItemsList[1].quantity").value(2))
				.andExpect(jsonPath("$.lineItemsList[1].subTotal").value(4))
				.andExpect(jsonPath("$.lineItemsList[1].itemDiscount").value(0));
	}

	@Test
	public void saveSaleWithSaleDiscountSuccessfully() throws Exception {
		String body ="{\n" +
				"   \"saleDiscount\":2,\n" +
				"   \"lineItemsList\":[\n" +
				"      {\n" +
				"         \"productId\":\"1\",\n" +
				"         \"quantity\":\"2\"\n" +
				"      },\n" +
				"      {\n" +
				"         \"productId\":2,\n" +
				"         \"quantity\":2\n" +
				"      }\n" +
				"   ]\n" +
				"}";

		ResultActions result = mockMvc.perform(post("/sales").content(body).contentType(MediaType.APPLICATION_JSON_VALUE));

		result.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("totalPrice").value(4.02))
				.andExpect(jsonPath("saleDiscount").value(2))
				.andExpect(jsonPath("$.lineItemsList[0].productPrice").value(1.01))
				.andExpect(jsonPath("$.lineItemsList[0].quantity").value(2))
				.andExpect(jsonPath("$.lineItemsList[0].subTotal").value(1.35))
				.andExpect(jsonPath("$.lineItemsList[0].itemDiscount").value(0.67))
				.andExpect(jsonPath("$.lineItemsList[1].productPrice").value(2))
				.andExpect(jsonPath("$.lineItemsList[1].quantity").value(2))
				.andExpect(jsonPath("$.lineItemsList[1].subTotal").value(2.67))
				.andExpect(jsonPath("$.lineItemsList[1].itemDiscount").value(1.33));
	}

}
