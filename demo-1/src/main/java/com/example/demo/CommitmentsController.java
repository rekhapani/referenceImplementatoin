package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/")
public class CommitmentsController {

	

	
	// Basic inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";

		@RequestMapping("/")
		public String welcome(Map<String, Object> model) {
			model.put("message", this.message);
			return "welcome";
		}

		@GetMapping(value ="/test")
		public ResponseEntity<String> testMpping(
				) {
			return Optional.ofNullable("Success").map(ResponseEntity::ok)
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		}
		
		@GetMapping(value ="/test1")
		public ResponseEntity<String> testMapping(
				) {
			return Optional.ofNullable("Success").map(ResponseEntity::ok)
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		}
	
}
