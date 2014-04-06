package com.wordpress.infow.quotewallspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wordpress.infow.quotewallspring.model.Quote;
import com.wordpress.infow.quotewallspring.repository.QuoteRepository;

@Service
public class QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;

	public List<Quote> findAll() {
		return this.quoteRepository.findAll();
	}

	public List<Quote> findByAuthor(String author) {
		return this.quoteRepository.findByAuthor(author);
	}

	public Quote findById(String id) {
		return this.quoteRepository.findById(id);
	}

	public List<Quote> findAllSorted() {
		return this.quoteRepository.findAll(new Sort(Sort.Direction.DESC, "created"));
	}

	public Quote save(Quote quote) {
		return this.quoteRepository.save(quote);
	}

	public Quote delete(Quote quote) {
		this.quoteRepository.delete(quote);

		return this.findById(quote.getId().toString());
	}

	public int updateQuote(Quote quote) {
		return this.quoteRepository.updateQuote(quote.getId(), quote.getText(), quote.getAuthor());
	}
}
