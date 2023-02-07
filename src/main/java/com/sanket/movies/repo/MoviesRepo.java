package com.sanket.movies.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sanket.movies.Movie;

@Repository
public interface MoviesRepo extends MongoRepository<Movie, ObjectId> {
	Optional<Movie> findMoiveByImdbId(String imdbId);
}
