package com.example.cooking.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CookingWebMvcConfig implements WebMvcConfigurer {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
