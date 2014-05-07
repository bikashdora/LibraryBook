package com.org.bookservice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.org.bookservice.model.Book;

public class BookDAOImpl implements BookDAO {

	public BookDAOImpl() {
		super();
		
	}

	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public  void addBook(Book book) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(book);
		this.sessionFactory.getCurrentSession().flush();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		 return this.sessionFactory.getCurrentSession().createQuery("from Book").list();
		
	}

}
