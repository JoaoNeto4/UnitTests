package br.com.tests.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Integer id;
	private String name;
	private String email;
	
	//@JsonIgnore 
	/*for GET does not return the password, but used for POST*/
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
}
