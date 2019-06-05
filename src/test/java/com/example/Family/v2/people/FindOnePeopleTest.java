package com.example.Family.v2.people;

import com.example.Family.v2.models.PersonModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindOnePeopleTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void givenValidId_should200Ok() {
		ResponseEntity<PersonModel> response = testRestTemplate.exchange("/people/3",
																		 HttpMethod.GET,
																		 new HttpEntity<>(new HttpHeaders()),
																		 PersonModel.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertTrue(response.getBody().getId().isPresent());
		assertEquals(3, response.getBody().getId().get().longValue());

	}

	@Test
	public void givenNotExist_should404(){
		ResponseEntity<PersonModel> response = testRestTemplate.exchange("/people/800",
																	   HttpMethod.GET,
																	   new HttpEntity<>(new HttpHeaders()),
																	   PersonModel.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());





	}

}
