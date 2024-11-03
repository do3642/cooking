package com.example.cooking.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
	
	
//	로그인페이지 이동
	@GetMapping("/auth/login")
	public String loginPage() {
		return "client/login";
	}
	
	
	
//	회원가입 이동
	@GetMapping("/auth/register")
	public String registerPage() {
		return "client/register";
	}
	
// 회원정보 조회: 인증된 사용자만 접근 가능
    @GetMapping("/userinfo")
    @PreAuthorize("isAuthenticated()")
    public String getUserInfo() {
        return "회원정보 페이지";
    }
	
	
}
