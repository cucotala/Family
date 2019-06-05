package com.example.Family.v2.people;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.web.header.Header;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeletePeopleTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void givenAuthRequest_should200Ok() {




		ResponseEntity<Object> response1 = testRestTemplate.exchange("/auth/login",
																	 HttpMethod.POST,
																	 new HttpEntity<>(httpHeaders),
																	 Object.class);

		assertEquals("Cristian", response1.getBody().get) ;





		/*
		ResponseEntity<Object> response1 = testRestTemplate.exchange("/auth/login",
																	 HttpMethod.POST,
																	 new HttpEntity<>(response),
																	 Object.class);*/
		HttpHeaders httpHeaders2 = new HttpHeaders();
		httpHeaders2.setBearerAuth(response1.getBody().toString());


		ResponseEntity<Object> response = testRestTemplate.exchange("/people/3",
																	HttpMethod.DELETE,
																	new HttpEntity<>(httpHeaders2),
																	Object.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}
