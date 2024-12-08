package com.jpa.test.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.test.entities.Book;
import com.jpa.test.services.BookServices;

@Controller
public class BookController {
	
	@Autowired
	private BookServices bookServices; 
	
	@GetMapping("/books")
	@ResponseBody
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books= bookServices.getAllBooks();
		if(books.size()==0) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(books));
	}
	
	@GetMapping("/books/{id}")
	@ResponseBody
	public Book getBookById(@PathVariable("id") int id) {
		return bookServices.getBookById(id);
	}
	
	@PostMapping("/books")
	@ResponseBody
	public List<Book> postBook(@RequestBody Book book) {
		return bookServices.addBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	@ResponseBody
	public boolean deleteBookById(@PathVariable("id") int id) {
		return bookServices.deleteBook(id);
	}
	
	@PutMapping("/books/{id}")
	@ResponseBody
	public List<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id) {
		return bookServices.updateBook(book, id);
	}
}
