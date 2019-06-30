
package com.training.mjunction.product.review.data.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.training.mjunction.product.review.data.relations.Review;

@Repository
public interface ReviewRepository extends Neo4jRepository<Review, Long> {

}
