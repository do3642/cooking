package com.example.cooking.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.cooking.domain.Client;
import com.example.cooking.dto.ResponseDTO;
import com.example.cooking.dto.UserDTO;
import com.example.cooking.service.UserService;

@Controller
public class ClientController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
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
	
	
//  회원가입 요청
	@PostMapping("/register")
	public String register(@Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		
		Client client = modelMapper.map(userDTO, Client.class);
// 아이디 중복 검사
		Client findUser = userService.getUser(client.getUsername());
		
		if (bindingResult.hasErrors()) {
		    // 에러 메시지 반환
			return "redirect:/register?error";
		}
		
		if(findUser.getUsername() == null) {
			 // 핸드폰 번호 통합
	        String fullPhoneNumber = userDTO.getPhonePart1() + "-" + userDTO.getPhonePart2() + "-" + userDTO.getPhonePart3();
	        client.setTel(fullPhoneNumber); // 통합된 핸드폰 번호 설정
		// 클라이언트에게 전달받은 user정보를 서비스로 넘겨줌
		userService.register(client);
		
		   redirectAttributes.addFlashAttribute("message", client.getUsername() + "님 회원 가입 성공");
	        return "redirect:/auth/login"; // 성공 후 로그인 페이지로 리다이렉트
		// OK에서 끝나면 OK를 넣어주고 .value 해야 해당 열거코드를 넣어줌
		}else {
			redirectAttributes.addFlashAttribute("error", client.getUsername() + "는 중복된 아이디입니다.");
	        return "redirect:/register"; // 중복 시 다시 회원가입 페이지로 리다이렉트
		}
	}
	
	
// 회원정보 조회: 인증된 사용자만 접근 가능
    @GetMapping("/userinfo")
    @PreAuthorize("isAuthenticated()")
    public String getUserInfo() {
        return "회원정보 페이지";
    }
	

}
