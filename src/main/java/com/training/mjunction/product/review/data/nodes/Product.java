package com.training.mjunction.product.review.data.nodes;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.training.mjunction.product.review.data.relations.Review;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@NodeEntity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Property("name")
	@Index(unique = true)
	private String name;

	@Property("productId")
	@Index(unique = true)
	private String productId;

	@JsonIgnoreProperties("product")
	@Relationship(type = "REVIEWED", direction = Relationship.OUTGOING)
	private List<Review> reviewes;

}
