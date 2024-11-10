package com.example.cooking.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.cooking.domain.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private Client client;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> roleList = new ArrayList<>();
		
		roleList.add(()->{
			return "ROLE_" + client.getRole();
		});
		
		return roleList;
	}

	@Override
	public String getPassword() {

		
		return  client.getPassword();
		// "{noop}" = 암호화하지 않겠다 
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return client.getUsername();
	}
	
	public int getPostCount() {
	    return client.getPostCount(); // Client에서 직접 가져오는 방식
	}

	//만료된 계정인지 리턴시켜주는 메서드(만료안됨 : true)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
		
	}

	//계정이 잠겼는지 리턴시켜주는 메서드 (안잠김 : true)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//자격증명 만료된건지 리턴 (오래된 비밀번호 변경 시키려는 팝업같은거)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정 비활성화 여부를 리턴 (휴면계정)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public String getNickname() {
        return client.getNickname(); // 닉네임 반환
    }

}