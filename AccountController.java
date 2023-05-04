package com.fpt.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.websocket.models.Account;
import com.fpt.websocket.service.AccountService;
import com.fpt.websocket.util.SendMailUtil;
import com.fpt.websocket.util.ValidateUserUtil;

@Controller
public class AccountController {
	private AccountService accoutService;
	private ValidateUserUtil validate = new ValidateUserUtil();
	private SendMailUtil sendMail = new SendMailUtil();
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	public AccountController(AccountService accoutService) {
		this.accoutService = accoutService;
	}

	public AccountController() {
	}

	@GetMapping("/register")
	public String register() {
		return "/signup";
	}

	@PostMapping("/register")
	public String register(Account account) {
		if (validate.isValidUserInformation(account)) {

			return "/register";
		} else {
			try {
				accoutService.register(account);
				sendMail.sendMailSimple();
			} catch (Exception e) {
				logger.debug("ERROR: " + e.getMessage());
			}
			return "redirect: /login";
		}
	}
	
	
	@GetMapping
	public String confirmEmail(@RequestParam("token") String token) {
		try {
			if(accoutService.confirmEmail(token)) {
				return "/";
			}else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/";
	}
	
	@PostMapping
	public String changePassword(String password) {
		return "/";
	}
	
	@PostMapping
	public String updateProfile(Account account) {
		try {
			accoutService.updateProfile(account);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/";
	}
	
}
