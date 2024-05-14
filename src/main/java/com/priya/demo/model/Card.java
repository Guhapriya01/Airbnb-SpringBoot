package com.priya.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.priya.demo.serializer.BlobSerializer;

@Entity
@Table(name="Event")
public class Card {
	
	@Id
	private int id;
	private String title;
	private int openSpots;
	private String location;
	private int reviewCount;
	private String ratings;
	private double price;
	
	@Lob
	@JsonSerialize(using = BlobSerializer.class)
	private Blob coverImage;
	
	public Blob getCoverImage() {
	    return coverImage;
	}

	public void setCoverImage(Blob coverImage) {
	    this.coverImage = coverImage;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOpenSpots() {
		return openSpots;
	}
	public void setOpenSpots(int openSpots) {
		this.openSpots = openSpots;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Card [id=" + id + ", title=" + title + ", openSpots=" + openSpots + ", location=" + location
				+ ", reviewCount=" + reviewCount + ", ratings=" + ratings + ", price=" + price + "]";
	}
}