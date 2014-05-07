package com.org.bookservice.services;

import java.util.List;

import com.org.bookservice.model.Book;

public interface BookManager {
	
	public void addBook(Book b);
	public List<Book> listBooks();

}
