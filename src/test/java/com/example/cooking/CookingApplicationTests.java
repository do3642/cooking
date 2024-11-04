package com.example.cooking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CookingApplicationTests {

	@Test
	void contextLoads() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pw = "1234abcd@#$@#";
		String encodePw = encoder.encode(pw);
		
		System.out.println("암호화 전 비번 : "+pw);
		System.out.println("암호화 후 비번 : "+encodePw);
		System.out.println("두개 비교 : " + pw.equals(encodePw));
		System.out.println("진짜 두개 비교 : " + encoder.matches(pw, encodePw));
	}

}
