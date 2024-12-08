package com.jpa.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jpa.test.entities.Book;

@Component
public class BookServices {
	private static List<Book> books= new ArrayList<>();
	
	static {
		books.add(new Book(123,"Intro to Node js","abc"));
		books.add(new Book(456,"Intro to React js","xyz"));
		books.add(new Book(789,"System Design","lmn"));
	}
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	public Book getBookById(int id) {
		for(int i=0;i<books.size();i++) {
			Book book= books.get(i);
			if(book.getId()==id) return book;
		}
		return null;
	}
	
	public List<Book> addBook(Book book) {
		books.add(book);
		return books;
	}
	
	public boolean deleteBook(int bookId) {
		for(int i=0;i<books.size();i++) {
			Book book= books.get(i);
			if(book.getId()==bookId) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<Book> updateBook(Book book, int bookId){
		for(int i=0;i<books.size();i++) {
			Book bok= books.get(i);
			if(bok.getId()==bookId) {
				bok.setId(book.getId());
				bok.setAuthor(book.getAuthor());
				bok.setTitle(book.getTitle());
			}
		}
		
		return books;
	}
}
