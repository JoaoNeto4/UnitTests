package br.com.tests.services;

import java.util.List;

import br.com.tests.domain.User;

public interface UserService {
	
	User findById(Integer id);

	List<User> findAll();
	

}
