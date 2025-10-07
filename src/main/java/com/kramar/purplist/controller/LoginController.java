package com.kramar.purplist.controller;

import com.kramar.purplist.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LoginController {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/access-denied")
	public @ResponseBody String accesDenied(){
		return "you have no permission to access this site";
	}

	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLogin(@RequestBody AuthRequest req){
		try {
	    authenticationManager.authenticate(
		    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
	    );

			String token = jwtUtil.generateToken(req.getUsername());
			return ResponseEntity.ok(Map.of("token", token));
		} catch (AuthenticationException ex){
			return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
		}
	}
}
