package com.org.bookservice.dao;

import java.util.List;

import com.org.bookservice.model.Book;

public interface BookDAO {
	
	public void addBook(Book b);
	public List<Book> listBooks();

}
