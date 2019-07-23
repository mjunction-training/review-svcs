package com.training.mjunction.product.review.data.relations;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.training.mjunction.product.review.data.nodes.Product;
import com.training.mjunction.product.review.data.nodes.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "REVIEWED")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "rating", "review", "user" })
public class Review {

	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Long id;

	@Property("rating")
	@JsonProperty("rating")
	private Integer rating;

	@Property("review")
	@JsonProperty("review")
	private String review;

	@StartNode
	@JsonIgnore
	private Product product;

	@EndNode
	@JsonProperty("user")
	private User user;

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Review other = (Review) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		if (rating == null) {
			if (other.rating != null) {
				return false;
			}
		} else if (!rating.equals(other.rating)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (product == null ? 0 : product.hashCode());
		result = prime * result + (rating == null ? 0 : rating.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", review=" + review + "]";
	}

}
