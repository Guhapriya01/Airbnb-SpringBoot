package com.priya.demo.controller;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.priya.demo.model.Card;
import com.priya.demo.repository.CardRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class EventController {
	
	@Autowired
	CardRepo repo;
	
	@GetMapping("/events")
	@ResponseBody
	public List<Card> getEvents() {
		return repo.findAll();
	}
	
	@PostMapping("/addEvent")
	public String addEvent( 
			@RequestParam("title") String title, 
			@RequestParam("price") int price,
			@RequestParam("reviewCount") int reviewCount,
			@RequestParam("ratings") String ratings,
			@RequestParam("location") String location,
			@RequestParam("openSpots") int openSpots,
			@RequestParam("coverImage") MultipartFile coverImage) throws Exception 
	{
			
			    byte[] imageData;
		
				imageData = coverImage.getBytes();
		        Blob blob = new javax.sql.rowset.serial.SerialBlob(imageData);
		        
				Card c = new Card();
				
				c.setLocation(location);
				c.setOpenSpots(openSpots);
				c.setPrice((double)price);
				c.setRatings(ratings);
				c.setReviewCount(reviewCount);
				c.setTitle(title);
				
				System.out.println(imageData);
				System.out.println(imageData.length);
				
				c.setCoverImage(blob);
				repo.save(c);
		
		return "admin.jsp";
	}
	
	@RequestMapping("/deleteEvent")
	public String deleteEvent(@RequestParam("id") int id) {
		repo.deleteById(id);
		return "admin.jsp";
	}
	
	@GetMapping("/event/{id}")
	public String getEvent(@PathVariable("id") int id) {
		Optional<Card> c = repo.findById(id);
		return "admin.jsp";
	}
	
	@RequestMapping("/updateEvent")
	public String updateEvent(
			@RequestParam("id") int id, 
			@RequestParam("title") String title, 
			@RequestParam("price") String price,
			@RequestParam("reviewCount") int reviewCount,
			@RequestParam("ratings") String ratings,
			@RequestParam("location") String location,
			@RequestParam("openSpots") int openSpots) throws Exception
	{
		Card c = repo.findById(id).get();
		c.setLocation(location);
		c.setOpenSpots(openSpots);
		c.setPrice(Double.parseDouble(price));
		c.setRatings(ratings);
		c.setReviewCount(reviewCount);
		c.setTitle(title);
		
		repo.save(c);
		return "redirect:/admin.jsp";
	}
	
	@RequestMapping("/update")
	public ModelAndView updateRedirect(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Card c = repo.findById(id).get();
		mv.addObject("data", c);
		mv.setViewName("update.jsp");
		return mv;
	}
	
	@RequestMapping("adminLogin")
	public String login(String uname, String pwd, HttpSession session) {
		
		if(uname.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("admin")) {
			session.setAttribute("admin","admin");
			return "redirect:/admin";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public List<Card> filterEvent(String location, int reviewCount, int price) {
		System.out.println(location.equalsIgnoreCase("NULL"));
		System.out.println(reviewCount);
		System.out.println(price);
		
		location =  location.equalsIgnoreCase("NULL") ? null:location;
		
		List<Card> c = repo.findByFilters(location, reviewCount, (double)price);
		return c;
	}
}
