package com.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.Users;

public class ServletDataController {

	public boolean sendUserData(HttpServletResponse resp, HttpServletRequest req)
	{
		resp.setContentType("text/json");
		
		HttpSession session = req.getSession();
		Users user = new Users();
		
		if(session.getAttribute("userId") != null)
		{
			user.setId((Integer) session.getAttribute("userId"));
			user.setUsername((String) session.getAttribute("username"));
			user.setFirstname((String) session.getAttribute("firstName"));
			user.setLastname((String) session.getAttribute("lastName"));
			user.setEmail((String) session.getAttribute("userEmail"));
		}
		
		//if a user has logged in...
		if (session.getAttribute("userId") != null)
		{
			try {
				resp.getWriter().println(new ObjectMapper().writeValueAsString(user));
			return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			try {
				Users tempUser = new Users();
				resp.getWriter().println(new ObjectMapper().writeValueAsString(tempUser));
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
}
