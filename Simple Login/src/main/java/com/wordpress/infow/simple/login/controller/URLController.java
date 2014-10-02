package com.wordpress.infow.simple.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class URLController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();

		model.addObject("title", "Simple Login - Spring Security");
		model.addObject("message", "This is welcome page!");
		model.setViewName("index");

		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();

		model.addObject("title", "Simple Login - Spring Security");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/private**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {
		ModelAndView model = new ModelAndView();

		model.addObject("title", "Simple Login - Spring Security");
		model.addObject("message", "This is protected page - Private Page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		ModelAndView model = new ModelAndView();

		model.addObject("title", "Simple Login - Spring Security");
		model.addObject("message", "Logout page!");
		model.setViewName("logout");

		return model;
	}

}
