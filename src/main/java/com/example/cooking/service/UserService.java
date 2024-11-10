package com.example.cooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cooking.domain.Client;
import com.example.cooking.domain.RoleType;
import com.example.cooking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
// 회원가입 요청 서비스
	@Transactional //잘못가입방지
	public void register(Client client) {
		client.setRole(RoleType.USER);
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		userRepository.save(client);
	}
	
	// username으로 검색한 결과가 있으면 해당 객체를 리턴
		// 없으면 빈 객체를 리턴
		public Client getUser(String username) {
			Client findUser = userRepository.findByUsername(username).orElseGet(() ->{
				return new Client();
			});
			
			return findUser;
			
		}
		
		
// 더미데이터 중복발생안하게 닉네임 검색
	  public Client findByNickname(String nickname) {
	        return userRepository.findByNickname(nickname).orElse(null);
	  }
		
}
