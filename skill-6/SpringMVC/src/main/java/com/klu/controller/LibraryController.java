package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Library;

@RestController
@RequestMapping("/book")
public class LibraryController {
	private List<Library> book=new ArrayList<>();
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to library";
	}
	@GetMapping("/count")
	public int countBook() {
		return book.size();
	}
	@GetMapping("/price")
	public double price() {
		return 299.99;
	}
	@GetMapping("/books")
	public List<String> bookTittle(){
		List<String>b=new ArrayList<>();
		for(Library L:book) {
			b.add(L.getTittle());
		}
		return b;
	}
	@GetMapping("/books/{id}")
	public Library getBookById(@PathVariable int id) {
		for(Library l:book) {
			if(l.getId()==id) {
				return l;
			}
		}
		return null;
	}
	@GetMapping("/search")
	public String searchBook(@RequestParam String tittle) {
		return "searching a book sucessfull:"+tittle;
	}
	@GetMapping("author/{name}")
	public String getAuthor(@PathVariable String name) {
		return "book return by:"+name;
	}
	@PostMapping("/addbook")
	public Library addBooks(@RequestBody Library L) {
		  book.add(L);
		  return L;
	}
	@GetMapping("/viewbooks")
	public List<Library> viewBooks(){
		return book;
	}
}
