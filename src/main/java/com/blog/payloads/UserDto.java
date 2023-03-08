package com.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 4,message = "User name must be min of 4 characters")
	
	private String name;
	
	@Email(message = "Email address is not valid!!")	
	private String email;
		
	@NotEmpty
	@Size(min = 3 , max=10,message="password must be min of 3 chars and max of 10 chars !!")
	
	private String password;
	
	@NotEmpty
	private String about;
			
}
