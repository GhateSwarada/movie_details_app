package com.example.MovieRating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_cast")
public class MovieCast {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="mname")
	private String movieName;
	
    @Column
    (name = "male_lead")
    private String maleLead;

    @Column(name = "female_lead")
    private String femaleLead;

    private String director;
    private String producer;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMaleLead() {
        return maleLead;
    }

    public void setMaleLead(String maleLead) {
        this.maleLead = maleLead;
    }

    public String getFemaleLead() {
        return femaleLead;
    }

    public void setFemaleLead(String femaleLead) {
        this.femaleLead = femaleLead;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
