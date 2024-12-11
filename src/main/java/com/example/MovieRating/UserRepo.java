package com.example.MovieRating;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Optional<Users> findByNameAndPassword(String name, String password);
}
