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

@Data
@NoArgsConstructor
@RelationshipEntity(type = "REVIEWED")
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Property("rating")
	private Integer rating;

	@Property("review")
	private String review;

	@StartNode
	private Product product;

	@EndNode
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
