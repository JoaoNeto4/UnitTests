package br.com.tests.services;

import java.util.List;

import br.com.tests.domain.User;
import br.com.tests.domain.dto.UserDTO;

public interface UserService {
	
	User findById(Integer id);

	List<User> findAll();
	
	User create(UserDTO obj);
	
	User update(UserDTO obj);
	

}
