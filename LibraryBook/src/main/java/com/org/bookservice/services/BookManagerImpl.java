package com.org.bookservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.bookservice.dao.BookDAO;
import com.org.bookservice.model.Book;
@Service
public class BookManagerImpl implements BookManager {

	@Autowired
    private BookDAO bookDAO;
	
	public BookManagerImpl() {
		
	}
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	@Transactional
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDAO.addBook(book);
		
	}



	@Override
	@Transactional
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		 return bookDAO.listBooks();
		
	}

}
