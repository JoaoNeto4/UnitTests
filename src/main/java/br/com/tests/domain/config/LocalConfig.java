package br.com.tests.domain.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.tests.domain.User;
import br.com.tests.repositories.UserRepository;
import jakarta.annotation.PostConstruct;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void startDb() {
		User u1 = new User(null, "João", "joao@joao.com", "123");
		User u2 = new User(null, "Luiz", "luiz@luiz.com", "123");

		repository.saveAll(List.of(u1, u2));
	}
}