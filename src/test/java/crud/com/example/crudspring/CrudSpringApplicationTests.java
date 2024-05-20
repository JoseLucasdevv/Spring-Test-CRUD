package crud.com.example.crudspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import crud.com.example.crudspring.DTO.UserDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CrudSpringApplicationTests {

	@Autowired
	private WebTestClient _webTestClient;

	long id = 20;

		UserDTO user = new UserDTO(id,"test",21,"123456");

	@Test
	void testCreateUserSuccess() {
		

			_webTestClient.post().uri("api/user").bodyValue(user).exchange().expectStatus().isOk().expectBody().jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].name")
			.isEqualTo(user.getName())
			.jsonPath("$[0].age")
			.isEqualTo(user.getAge())
			.jsonPath("$[0].cpf")
			.isEqualTo(user.getCpf());
		}

	@Test
	void testCreateUserFailure() {
		_webTestClient.post().uri("api/user").
		bodyValue(new UserDTO(id,"",10,""))
		.exchange
		().expectStatus()
		.isBadRequest();
	}


}
