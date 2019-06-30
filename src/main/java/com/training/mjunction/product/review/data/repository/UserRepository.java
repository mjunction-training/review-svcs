
package com.training.mjunction.product.review.data.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.mjunction.product.review.data.nodes.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

	User findByName(@Param("name") String name);
}
