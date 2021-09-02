package pu.mca.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pu.mca.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> getByEmailAndPassword(String email, String password);
	

}
