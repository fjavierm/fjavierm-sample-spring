package com.wordpress.infow.quotewallspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordpress.infow.quotewallspring.model.AddQuote;
import com.wordpress.infow.quotewallspring.model.Quote;
import com.wordpress.infow.quotewallspring.model.SearchQuote;
import com.wordpress.infow.quotewallspring.service.QuoteService;

@Controller
@RequestMapping ("/index")
public class IndexController {

	@Autowired
	private QuoteService quoteService;

	@RequestMapping (method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("quotes", this.quoteService.findAllSorted());
		this.initFormObsjects(model);

		return "index";
	}

	@RequestMapping (method = RequestMethod.POST, params = { "search" })
	public String findByAuthor(Model model, @ModelAttribute ("searchQuoteForm") SearchQuote searchQuote) {
		if (searchQuote.getAuthor().isEmpty() || (searchQuote.getAuthor().length() == 0)) {
			model.addAttribute("quotes", this.quoteService.findAllSorted());
		} else {
			model.addAttribute("quotes", this.quoteService.findByAuthor(searchQuote.getAuthor().toLowerCase()));
		}
		this.initFormObsjects(model);

		return "index";
	}

	@RequestMapping (method = RequestMethod.POST, params = { "reset" })
	public String reset(Model model, @ModelAttribute ("searchQuoteForm") SearchQuote searchQuote) {
		model.addAttribute("quotes", this.quoteService.findAllSorted());
		this.initFormObsjects(model);

		return "index";
	}

	@RequestMapping (method = RequestMethod.POST, params = { "add" })
	public String addQuote(Model model, @ModelAttribute ("addQuoteForm") AddQuote addQuote) {
		this.quoteService.save(new Quote(addQuote.getAuthor(), addQuote.getText()));
		model.addAttribute("quotes", this.quoteService.findAllSorted());
		this.initFormObsjects(model);

		return "index";
	}

	private void initFormObsjects(Model model) {
		model.addAttribute("searchQuoteForm", new SearchQuote());
		model.addAttribute("addQuoteForm", new AddQuote());
	}
}
