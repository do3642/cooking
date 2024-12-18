package com.example.cooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http //csrf()
		//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .authorizeRequests()
                .antMatchers("/").permitAll() // 공개 URL
                .anyRequest().permitAll() // 기본적으로 모든 요청 허용, 컨트롤러에서 @PreAuthorize("isAuthenticated()")로 특정맵핑 만 막을예정
            .and()
            .csrf().disable()
                .formLogin()
                    .loginPage("/login") 
                    .permitAll()
            .and()
                .logout()
                    .logoutUrl("/auth/logout") 
                    .logoutSuccessUrl("/")
                    .permitAll();

        return http.build();
    }
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		
		return authenticationConfiguration.getAuthenticationManager();
		
	}
}