package com.kramar.purplist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

    @GetMapping("/access-denied")
    public @ResponseBody String accesDenied(){
        return "you have no permission to access this site";
    }
    
}
