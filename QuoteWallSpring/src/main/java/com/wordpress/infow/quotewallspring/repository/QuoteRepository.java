package com.wordpress.infow.quotewallspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wordpress.infow.quotewallspring.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

	@Query ("SELECT q FROM Quote q WHERE lower(q.author) LIKE %:author%")
	List<Quote> findByAuthor(@Param ("author") String author);

	@Query ("SELECT q FROM Quote q WHERE q.id = :id")
	Quote findById(@Param ("id") String id);

	@Modifying
	@Query ("UPDATE Quote q SET q.author = :author, q.text = :text where q.id = :id")
	int updateQuote(@Param ("id") Integer id, @Param ("text") String text, @Param ("author") String author);
}
