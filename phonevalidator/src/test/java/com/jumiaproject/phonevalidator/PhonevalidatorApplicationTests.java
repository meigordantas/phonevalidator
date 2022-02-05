package com.jumiaproject.phonevalidator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PhonevalidatorApplicationTests {

	@Value("${regex.uganda}")
	String pattern;

	@Test
	void contextLoads() {
	}



}
