package com.sanket.movies.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.movies.Review;
import com.sanket.movies.service.ReviewService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping
	public ResponseEntity<Review> creatReview(@RequestBody Map<String, String> payload) {
		return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
				HttpStatus.CREATED);
	}

}
