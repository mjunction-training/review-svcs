package com.training.mjunction.product.review.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.training.mjunction.product.review.data.nodes.Product;
import com.training.mjunction.product.review.data.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ReviewListener {

	@Autowired
	private ProductRepository repository;

	@RabbitListener(queues = "${spring.rabbitmq.queue.name}")
	public void save(@Payload final Product reviewed, @Header("action") final String action) {

		log.error(() -> "Received event " + reviewed + " " + action);

		switch (action) {

		case "create":

			log.error(() -> "Creating product " + reviewed);
			repository.save(reviewed);

			break;

		case "update":

			if (repository.existsById(reviewed.getId())) {
				log.error(() -> "Updating product " + reviewed);
				repository.save(reviewed);
			}

			break;

		case "delete":

			if (repository.existsById(reviewed.getId())) {
				log.error(() -> "Deleting product " + reviewed);
				repository.deleteByProductId(reviewed.getProductId());
			}

			break;

		default:

			log.error(() -> "Unknown action :" + action);

		}

	}

}
