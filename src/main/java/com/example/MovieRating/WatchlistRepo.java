package com.example.MovieRating;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepo extends JpaRepository<Watchlist, Integer> {
	List<Watchlist> findByUsername(String username);
}
