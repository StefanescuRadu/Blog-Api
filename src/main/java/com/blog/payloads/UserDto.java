package com.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class UserDto {
	
	private int id;
	
	@NotNull
	@Size(min = 4, message = "Username must be minimum of 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid")
	private String email;
	
	@NotNull
	@Size(min = 3, max = 10, message = "Password must be min of 3 characters and maximum of 10")
	private String password;
	
	@NotNull
	private String about;
}
