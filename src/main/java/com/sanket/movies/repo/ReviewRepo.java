package com.sanket.movies.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sanket.movies.Review;

@Repository
public interface ReviewRepo extends MongoRepository<Review, ObjectId> {

}
