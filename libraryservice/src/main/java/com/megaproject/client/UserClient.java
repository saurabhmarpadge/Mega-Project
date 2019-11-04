package com.megaproject.client;

import com.megaproject.fallback.UserClientFallback;
import com.megaproject.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${userservice.name}", fallback = UserClientFallback.class)
public interface UserClient {

	@GetMapping(value = "/user-service/users")
	ResponseEntity<List<User>> getAllUsers();

	@GetMapping(value = "/user-service/users/{user_id}")
	ResponseEntity<User> getUser(@PathVariable(value = "user_id") Long id);

	@PostMapping(value = "/user-service/users")
	ResponseEntity<User> addUser(@RequestBody User userRequest);

	@PutMapping(value = "/user-service/users")
	ResponseEntity<User> updateUser(@RequestBody User userRequest);

	@DeleteMapping(value = "/user-service/users/{user_id}")
	ResponseEntity<Object> deleteUser(@PathVariable(value = "user_id") Long id);

}
