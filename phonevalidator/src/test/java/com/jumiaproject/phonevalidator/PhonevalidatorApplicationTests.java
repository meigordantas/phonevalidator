package com.jumiaproject.phonevalidator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

@SpringBootTest
class PhonevalidatorApplicationTests {

	@Value("${regex.uganda}")
	String pattern;

	@Test
	void contextLoads() {
	}

	@Test
	void printRegexPattern() {
		System.out.println(pattern);
	}

	@Test
	void splitTest() {
		String str = "(212) 1234567";

		System.out.println(str.replaceAll("[()]", "").split("\\ ", 2)[0]);
	}
}
