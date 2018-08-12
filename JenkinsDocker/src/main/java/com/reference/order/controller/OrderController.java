package com.reference.order.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reference.order.entity.OrderEntity;
//import com.reference.order.listener.Receiver;
import com.reference.order.repository.OrderMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	private final OrderMongoRepository orderRepository;

	public OrderController(OrderMongoRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	// Basic inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

	@GetMapping(value = "/test")
	public ResponseEntity<String> testMpping() {
		return Optional.ofNullable("Success").map(ResponseEntity::ok)
				.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@GetMapping(value = "/test1")
	public ResponseEntity<String> testMapping() {
		return Optional.ofNullable("Success").map(ResponseEntity::ok)
				.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public OrderEntity addOrder(@RequestBody OrderEntity entity) {
		// LOG.info("Saving user.");
		return orderRepository.save(entity);
	}

	@RequestMapping(value = "/getOrder/{orderId}", method = RequestMethod.GET)
	public Optional<OrderEntity> getOrder(@PathVariable Integer orderId) {
		LOGGER.info("get Order", orderId);

		return orderRepository.findById(orderId);
	}

	@RequestMapping(value = "/updateOrder/{orderId}", method = RequestMethod.PUT)
	public OrderEntity updateOrder(@RequestBody OrderEntity entity) {
		LOGGER.info("updated", entity);

		return orderRepository.save(entity);
	}

	@RequestMapping(value = "/deleteOrder/{orderId}", method = RequestMethod.GET)
	public void deleteOrder(@PathVariable Integer orderId) {
		LOGGER.info("deleted", orderId);

		orderRepository.deleteById(orderId);
	}
	
}