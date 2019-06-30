package com.training.mjunction.product.review.data.nodes;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@NodeEntity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Property("name")
	@Index(unique = true)
	private String name;

	@Property("age")
	private Integer age;

	@JsonIgnore
	@Relationship(type = "REVIEWED", direction = Relationship.INCOMING)
	private List<Product> products;

}
