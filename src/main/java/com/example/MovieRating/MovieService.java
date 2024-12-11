package com.example.MovieRating;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	CastRepo castRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	WatchlistRepo watchRepo;
	
	//adding new movie details
	public MovieDetails addMovie(MovieDetails movie)
	{
		return movieRepo.save(movie);
	}
	
	//deleting movie details
	public String deleteMovie(int id)
	{
		Optional<MovieDetails> optionalMovie = movieRepo.findById(id);
		if(optionalMovie.isPresent())
		{
			movieRepo.delete(optionalMovie.get());
			return "Deleted successfully";
		}
		return "Movie not found";
	}
	
	//retrieving all movie details
	public List<MovieDetails> getMovieList()
	{
		return movieRepo.findAll();
	}
	
	//retrieving all movie details with matching genre
	public List<MovieDetails> getMovieByGenre(String genre)
	{
		return movieRepo.findByGenre(genre);
	}
	
	//retrieving all movie details with matching rating
	public List<MovieDetails> getMovieByRating(double rating)
	{
		return movieRepo.findByRating(rating);
	}
	
	//retrieving all movie details with matching name
	public List<MovieDetails> getMovieByName(String name)
	{
		return movieRepo.findByTitle(name);
	}
	
		
	//updating existing movie details
	public MovieDetails updateMovie(int id, MovieDetails newDetails)
	{
		Optional<MovieDetails> movieOpt = movieRepo.findById(id);
		if(movieOpt.isPresent())
		{
			MovieDetails movie = movieOpt.get();
			movie.setTitle(newDetails.getTitle());
			movie.setDescription(newDetails.getDescription());
			movie.setGener(newDetails.getGenre());
			movie.setRating(newDetails.getRating());
			return movie;
		}
		return null;
	}
	
	//get all movie cast details
	public List<MovieCast> castDetails()
	{
		return castRepo.findAll();
	}
	
	//check if user present
	public boolean validUser(String username, String Password)
	{
		Optional<Users> user=userRepo.findByNameAndPassword(username, Password);
		return user.isPresent();
	}
	
	//get watch list as per name
	public List<Watchlist> getWatchlist(String name)
	{
		return watchRepo.findByUsername(name);
	} 
	
}
