package com.project.serv;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.controller.ServletDataController;

public class RequestForwarder {

	private ServletDataController servC = new ServletDataController();
	
			public void data(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		switch(req.getRequestURI()) {
		case "/MochiCircle/user.json":
			servC.sendUserData(resp, req);
			break;
		case "/MochiCircle/allUsers.json":
			//function doesn't exist yet;
			break;
		}
	}
}
