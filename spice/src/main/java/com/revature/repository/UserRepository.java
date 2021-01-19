package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


	@Query(value = "SELECT * FROM users WHERE first_name=:firstName", nativeQuery = true)
	public List<User> findByName(@Param("firstName") String name);
}
