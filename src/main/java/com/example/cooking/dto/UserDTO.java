package com.example.cooking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	@NotNull(message = "username은 null이면 안됩니다.")
	@NotBlank(message = "username은 반드시 입력하셔야 합니다.")
	@Size(min = 2, max = 40, message = "username은 2~40글자로 입력해야 합니다.")
	private String username;
	
	@Size(min = 4, max = 100, message = "password는 4~40글자로 입력해야 합니다.")
	private String password;
	
	@NotNull(message = "email은 null이면 안됩니다.")
	@NotBlank(message = "email은 반드시 입력하셔야 합니다.")
	@Email(message = "email형식으로 입력하셔야 합니다.")
	@Size(max = 40, message = "email은 40글자 이하로 입력해야 합니다.")  
	private String email;
	
    private String nickname;
    private String phonePart1;
    private String phonePart2;
    private String phonePart3;
}