package com.example.MovieRating;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepo extends JpaRepository<MovieCast, Integer>{

}

