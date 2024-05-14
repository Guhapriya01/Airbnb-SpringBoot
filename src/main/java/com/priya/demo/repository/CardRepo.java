package com.priya.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

import com.priya.demo.model.Card;

public interface CardRepo extends JpaRepository<Card, Integer>{
	
	@Query("FROM Card WHERE (?1 IS NULL OR location = ?1) " +
	           "AND (?2 IS NULL OR reviewCount >= ?2) " +
	           "AND (?3 IS NULL OR price >= ?3)")
	    List<Card> findByFilters(String location,
	                              Integer minReviewCount,
	                              Double price);
}