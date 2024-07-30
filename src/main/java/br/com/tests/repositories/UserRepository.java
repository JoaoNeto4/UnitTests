package br.com.tests.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tests.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
