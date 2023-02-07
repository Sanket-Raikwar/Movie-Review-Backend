package com.sanket.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.sanket.movies.Movie;
import com.sanket.movies.Review;
import com.sanket.movies.repo.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Review createReview(String reviewBody, String imdbId) {
		Review review = reviewRepo.insert(new Review(reviewBody));

		mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
				.apply(new Update().push("reviewIds").value(review)).first();

		return review;

	}

}
