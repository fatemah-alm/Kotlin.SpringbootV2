package com.coded.spring.ordering

import com.coded.spring.ordering.authentication.jwt.JwtService
import com.coded.spring.ordering.menu.Menu
import com.coded.spring.ordering.users.UserEntity
import com.coded.spring.ordering.users.UsersRepository
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.util.MultiValueMap
import kotlin.test.junit5.JUnit5Asserter.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	companion object {
		@JvmStatic
		@BeforeAll
		fun setUp(
			@Autowired usersRepository: UsersRepository,
			@Autowired passwordEncoder: PasswordEncoder,
		){
			usersRepository.deleteAll()
			val testUser = UserEntity(
				name = "coded",
				age = 18,
				username = "coded",
				password = passwordEncoder.encode("joincoded")
			)
			usersRepository.save(testUser)
		}
	}


	@Autowired
	lateinit var restTemplate: TestRestTemplate

	@Test
	fun contextLoads() {
	}

	@Test
	fun getMenu(@Autowired jwtService: JwtService){
		val token = jwtService.generateToken("coded")
		val headers = HttpHeaders(
			MultiValueMap.fromSingleValue(mapOf("Authorization" to "Bearer $token"))
		)
		val requestEntity = HttpEntity<String>(headers)

		val result = restTemplate.exchange(
			"/menu/v1/menu",
			HttpMethod.GET,
			requestEntity,
			emptyList<Menu>()::class.java
		)
		assertEquals(expected = HttpStatus.OK, actual = result.statusCode,message = "status code is OK" )
		assertEquals(expected = emptyList<Menu>(), actual = result.body, message = "output equals menu list")

	}






}
