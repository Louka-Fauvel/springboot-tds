package edu.supavenir.ormtest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.supavenir.ormtest.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByFirstnameIgnoreCase(String firstname);
}
