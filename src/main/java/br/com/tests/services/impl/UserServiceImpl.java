package br.com.tests.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tests.domain.User;
import br.com.tests.domain.dto.UserDTO;
import br.com.tests.repositories.UserRepository;
import br.com.tests.services.UserService;
import br.com.tests.services.exceptions.DataIntegratyViolationException;
import br.com.tests.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

	@Override
	public User create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}

	private void findByEmail(UserDTO obj) {
		Optional<User> user = repository.findByEmail(obj.getEmail());
		if (user.isPresent() && !user.get().getId().equals(obj.getId())) {
			throw new DataIntegratyViolationException("Email já cadastrado");
		}
	}

	@Override
	public User update(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}
	
}
