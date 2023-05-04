package com.fpt.websocket.controller;

import org.springframework.stereotype.Controller;

import com.fpt.websocket.service.AccountService;
import com.fpt.websocket.service.AttachmentService;
import com.fpt.websocket.service.GroupService;
import com.fpt.websocket.service.MessageService;

@Controller
public class ActionController {
	private AccountService accountServices;
	private MessageService messageServices;
	private GroupService groupService;
	private AttachmentService attachmentService;
	
	public String addUserToGroup() {
		return "/";
	}
	
	public String removeUserFromGroup() {
		return "/";
	}
	
	public void singleChat() {
		
	}
	
	public void groupChat() {
		
	}
	
	public void blockUser() {
		
	}
}
