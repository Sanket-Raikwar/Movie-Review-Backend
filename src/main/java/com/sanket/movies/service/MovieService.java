package com.sanket.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.movies.Movie;
import com.sanket.movies.repo.MoviesRepo;

@Service
public class MovieService {

	@Autowired
	private MoviesRepo moviesRepo;

	public List<Movie> allMovies() {
		return moviesRepo.findAll();

	}

	public Optional<Movie> singleMovie(String imdbId) {
		return moviesRepo.findMoiveByImdbId(imdbId);
	}
}
