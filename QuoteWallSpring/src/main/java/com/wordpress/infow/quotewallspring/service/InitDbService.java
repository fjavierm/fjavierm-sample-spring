package com.wordpress.infow.quotewallspring.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordpress.infow.quotewallspring.model.Quote;
import com.wordpress.infow.quotewallspring.repository.QuoteRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private QuoteRepository quoteRepository;

	@PostConstruct
	public void init() {
		Quote quote = new Quote("Napoleon Bonaparte", "Glory is fleeting, but obscurity is forever.");
		this.quoteRepository.save(quote);

		Quote quote2 = new Quote("General George S. Patton", "If a man does his best, what else is there?");
		this.quoteRepository.save(quote2);

		Quote quote3 = new Quote("Albert Einstein",
				"Not everything that can be counted counts, and not everything that counts can be counted.");
		this.quoteRepository.save(quote3);

		Quote quote4 = new Quote("Albert Einstein",
				"Only two things are infinite, the universe and human stupidity, and I\"m not sure about the former.");
		this.quoteRepository.save(quote4);

		Quote quote5 = new Quote(
				"Galileo Galilei",
				"I do not feel obliged to believe that the same God who has endowed us with sense, reason, and intellect has intended us to forgo their use.");
		this.quoteRepository.save(quote5);

		Quote quote6 = new Quote("Thomas Jefferson", "I find that the harder I work, the more luck I seem to have.");
		this.quoteRepository.save(quote6);

		Quote quote7 = new Quote("Rene Descartes",
				"Each problem that I solved became a rule which served afterwards to solve other problems.");
		this.quoteRepository.save(quote7);

		Quote quote8 = new Quote("Napoleon Bonaparte", "Never interrupt your enemy when he is making a mistake.");
		this.quoteRepository.save(quote8);

		Quote quote9 = new Quote(
				"unknown",
				"The difference between \"involvement\" and \"commitment\" is like an eggs-and-ham breakfast: the chicken was \"involved\" - the pig was \"committed\".");
		this.quoteRepository.save(quote9);

		Quote quote10 = new Quote("Voltaire", "God is a comedian playing to an audience too afraid to laugh.");
		this.quoteRepository.save(quote10);
	}
}
