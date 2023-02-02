package com.app.consenso.controller;

 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@Controller
public class LoginController {
   @RequestMapping("/login")  
   public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
	  String email=request.getParameter("email");  
      String password=request.getParameter("password");
      String message;
      if(email != null && 
    		  !email.equals("") 
    		  && email.equals("jai") && 
    		  password != null && 
    		  !password.equals("") && 
    		  password.equals("123")){
    	  message = "Welcome " +email + ".";
	      return new ModelAndView("welcome", 
	    		  "message", message);  
 
      }else{
    	  message = "Wrong username or password.";
    	  return new ModelAndView("errorPage", 
    			  "message", message);
      }
   }
}