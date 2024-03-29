package com.example.Family.v2.people;

import com.example.Family.v2.models.PersonModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAllPeopleTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	//public FindAllPeoplelTest() {}

	@Test
	public void givenValidId_should200OK() {
		ResponseEntity<List<PersonModel>> result =
				testRestTemplate.exchange("/people",
										  HttpMethod.GET,
										  new HttpEntity<>(new HttpHeaders()),
										  new ParameterizedTypeReference<List<PersonModel>>() {});

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNotNull(result.getBody());
	}

	@Test
	public void givenValidTerm_shouldSuccessWith200AndReturnList() {
		ResponseEntity<List<PersonModel>> result =
				testRestTemplate.exchange("/people",
										  HttpMethod.GET,
										  new HttpEntity<>(new HttpHeaders()),
										  new ParameterizedTypeReference<List<PersonModel>>() {});

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNotNull(result.getBody());
	}


}



