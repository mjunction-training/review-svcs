package com.training.mjunction.product.review.data.relations;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.training.mjunction.product.review.data.nodes.Product;
import com.training.mjunction.product.review.data.nodes.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Sundar Gsv
 * @Date 06/11/18
 * @ClassDescription
 */
@Data
@ToString
@NoArgsConstructor
@RelationshipEntity(type = "REVIEWED")
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Property("rating")
	private String rating;

	@Property("review")
	private String review;

	@StartNode
	private Product product;

	@EndNode
	private User user;

}
