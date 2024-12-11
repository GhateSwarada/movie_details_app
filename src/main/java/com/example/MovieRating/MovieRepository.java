package com.example.MovieRating;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieDetails, Integer>{
	
	List<MovieDetails> findByTitle(String title);
	
	List<MovieDetails> findByGenre(String genre);
	
	List<MovieDetails> findByRating(double rating);
	
	Optional<MovieDetails> findById(int id);
}
