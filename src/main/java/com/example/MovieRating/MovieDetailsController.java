package com.example.MovieRating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MovieDetailsController {
	
	@Autowired
	MovieService movieService;
	
	//login page
	@GetMapping("/")
	public String loginPage()
	{
		return "login";
	}
	
	@PostMapping("loginCheck")
	public String validateLogin(@RequestParam ("username") String name, @RequestParam ("password") String pass, Model model)
	{
		boolean result = movieService.validUser(name, pass);
		if(result==true) 
		{
			return "homePage";
		}
		model.addAttribute("errorMessage", "Invalid Username or Password");
		return "login";
	}
	
	//retrieving all the movies
	@GetMapping("/getMoviesList")
	public ModelAndView movieList() 
	{
		ModelAndView mav= new ModelAndView("movies");
		List<MovieDetails> list = movieService.getMovieList();
		mav.addObject("movies", list);
		return mav;
	}
	
	
	//for deleting movie
	@GetMapping("/deleteMovie")
	public String delMovie()
	{
		return "deleteMovie";
	}
	
	//deleting movie from list
	@GetMapping("/delMovie")
	public ModelAndView movieAfterDel(@RequestParam ("mid") String mid, Model model) 
	{
		int id= Integer.parseInt(mid);
		
		String result=movieService.deleteMovie(id);
		if(result.equals("Movie not found"))
		{

			ModelAndView mav= new ModelAndView("deleteMovie");
			model.addAttribute("errorMsg", "Invalid movie id");
			return mav;
		}
		ModelAndView mav= new ModelAndView("movies");
		List<MovieDetails> list = movieService.getMovieList();
		mav.addObject("movies", list);
		return mav;
	}
	
	
	
	//for movies by genre
	@GetMapping("/getByGenre")
	public String getByGenre()
	{
		return "movieGen";
	}
	
	//retrieving movies by genre
	@GetMapping("/genMovie")
	public ModelAndView movieByGenre(@RequestParam ("gen") String gen) 
	{
		List<MovieDetails> list = movieService.getMovieByGenre(gen);
	    ModelAndView mav = new ModelAndView("movies");
	    mav.addObject("movies", list);
	    return mav;
	}
	
	
	//for movies by rating
	@GetMapping("/getByRating")
	public String getByRating()
	{
		return "movieRat";
	}
	
	//retrieving movies by rating
	@GetMapping("/ratMovie")
	public ModelAndView movieByRating(@RequestParam ("rat") String rat) 
	{
		double r= Double.parseDouble(rat);
		List<MovieDetails> list = movieService.getMovieByRating(r);
	    ModelAndView mav = new ModelAndView("movies");
	    mav.addObject("movies", list);
	    return mav;
	}
	
	//for movies by name
	@GetMapping("/getByName")
	public String getByName()
	{
		return "movieName";
	}
		
	//retrieving movies by name
	@GetMapping("/nameMovie")
	public ModelAndView movieByName(@RequestParam ("n") String n) 
	{
		List<MovieDetails> list = movieService.getMovieByName(n);
		ModelAndView mav = new ModelAndView("movies");
		mav.addObject("movies", list);
		return mav;
	}
	
	//for insert movie
	@GetMapping("/insertMovie")
	public String movieRec()
	{
		return "movieInsert";
	}
	
	//inserting record 
	@GetMapping("/insertRec")
	public ModelAndView newMovieList(@RequestParam ("n") String name, @RequestParam ("r") String rat, 
			@RequestParam ("des") String d, @RequestParam ("g") String genre, @RequestParam ("i") String img) 
	{
		MovieDetails m1= new MovieDetails();
		m1.setTitle(name);
		m1.setDescription(d);
		m1.setGener(genre);
		m1.setImgPath(img);
		double r= Double.parseDouble(rat);
		m1.setRating(r);
		movieService.addMovie(m1);
		ModelAndView mav= new ModelAndView("movies");
		List<MovieDetails> list = movieService.getMovieList();
		mav.addObject("movies", list);
		return mav;
	} 
	
	//for update 
	@GetMapping("/updateMovie")
	public String updateMovie()
	{
		return "movieUpdate";
	}
	
	//updating movie 
	@GetMapping("/movieUpdate")
	public ModelAndView updateMovieList(@RequestParam ("title") String name, @RequestParam ("rating") String r, 
			@RequestParam ("des") String d, @RequestParam ("genre") String g, @RequestParam ("path") String img, @RequestParam ("id") int mid) 
	{
		MovieDetails m1= new MovieDetails();
		m1.setTitle(name);
		m1.setDescription(d);
		m1.setGener(g);
		m1.setRating(Double.parseDouble(r));
		m1.setImgPath(img);
		movieService.updateMovie(mid, m1);
		ModelAndView mav= new ModelAndView("movies");
		List<MovieDetails> list = movieService.getMovieList();
		mav.addObject("movies", list);
		return mav;
	}
	
	@GetMapping("/getMovieCast")
	public ModelAndView castList() 
	{
		ModelAndView mav= new ModelAndView("movieCast");
		List<MovieCast> list = movieService.castDetails();
		mav.addObject("movieCast", list);
		return mav;
	}

	@GetMapping("/watchLists")
	public String listForm()
	{
		return "watchListForm";
	}
	
	@GetMapping("/getWatchList")
	public ModelAndView watchList(@RequestParam ("username") String name) 
	{
		ModelAndView mav= new ModelAndView("watchList");
		List<Watchlist> list = movieService.getWatchlist(name);
		mav.addObject("watchList", list);
		return mav;
	}
}
