package com.megaproject.fallback;

import com.megaproject.client.UserClient;
import com.megaproject.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserClientFallback implements UserClient {

	@Override
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ArrayList<>());
	}

	@Override
	public ResponseEntity<User> getUser(Long id) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}

	@Override
	public ResponseEntity<User> addUser(User userRequest) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}

	@Override
	public ResponseEntity<User> updateUser(User userRequest) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}

	@Override
	public ResponseEntity<Object> deleteUser(Long id) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}
}