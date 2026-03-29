package com.klu.model;



public class Library {
	private int id;
	private String tittle;
	private String author;
	private double price;
	
	public Library() {
		// TODO Auto-generated constructor stub
	}
	public Library(int id, String tittle, String author, double price) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.author = author;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
