
package com.training.mjunction.product.review.data.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.mjunction.product.review.data.nodes.Product;

@Repository
public interface ProductRepository extends Neo4jRepository<Product, Long> {

	@Query("MATCH (p:Product)-[r: REVIEWED]->(u:User) WHERE p.productId = {productId} RETURN p,r,u LIMIT {limit}")
	Product findByProductId(@Param("productId") String productId, @Param("limit") int limit);

	@Query("MATCH (p:Product)-[r: REVIEWED]->(u:User) WHERE p.name = {productName} RETURN p,r,u LIMIT {limit}")
	Product findByProductName(@Param("productName") String productName, @Param("limit") int limit);

	@Query("MATCH (p:Product {productId: {productId}}) DETACH DELETE p")
	void deleteByProductId(@Param("productId") String productId);

}
