package com.org.bookservices.spring;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.org.bookservice.model.Book;
import com.org.bookservice.utils.BookRestURIConstants;

public class TestBookService {
	public static final String SERVER_URI = "http://localhost:8080/LibraryBook";
    
    public static void main(String args[]){
         
    	System.out.println("Book Created*****");
    	testCreateBook();
    	 System.out.println("Book Retreived*****");
        testGetBook();
        System.out.println("Book Updated*****");
        testGetUpdateBook();
        System.out.println("All Books Retrieval*****");
        testGetAllBooks();
       System.out.println("Deleted theBook*****");
        testDeleteBook();
        System.out.println("All Books Retrieval*****");
        testGetAllBooks() ;
        
    }
 
    private static void testGetAllBooks() {
        RestTemplate restTemplate = new RestTemplate();
        //we can't get List<Book> because JSON convertor doesn't know the type of
        //object in the list and hence convert it to default JSON object type LinkedHashMap
        List<LinkedHashMap> books = restTemplate.getForObject(SERVER_URI+BookRestURIConstants.GET_ALL_BOOK, List.class);
        if(books.size()==0)
        	System.out.println("No Books Found");
        for(LinkedHashMap map : books){
            System.out.println("Author="+map.get("author")+",bookName="+map.get("bookName")+",releaseDate="+map.get("releaseDate"));;
        }
    }
 
    private static void testCreateBook() {
        RestTemplate restTemplate = new RestTemplate();
        Book book = new Book();
        book.setAuthor("Author");
        book.setBookName("bookname");
        book.setISBN(12345678);
        book.setPrice(345.68);
        book.setRating("good");
        book.setReleaseDate(new Date());
        restTemplate.postForObject(SERVER_URI+BookRestURIConstants.CREATE_BOOK,book, Book.class);
       // String  response = restTemplate.postForObject(SERVER_URI+"/rest/book"+BookRestURIConstants.CREATE_BOOK,book, Book.class);
        //printEmpData(response);
    }
 
    private static void testGetBook() {
        RestTemplate restTemplate = new RestTemplate();
        Book book = restTemplate.getForObject(SERVER_URI+"/rest/book/12345678", Book.class);
        printEmpData(book);
    }
 
    private static void testGetUpdateBook() {
    	 RestTemplate restTemplate = new RestTemplate();
         Book book = restTemplate.getForObject(SERVER_URI+"/rest/book/12345678", Book.class);
         book.setBookName("newbookname");        
        Book newbook = restTemplate.postForObject(SERVER_URI+BookRestURIConstants.CREATE_BOOK,book, Book.class);
        printEmpData(newbook);
    }    
    
    private static void testDeleteBook() {
        RestTemplate restTemplate = new RestTemplate();
     Book book =  restTemplate.getForObject(SERVER_URI+"/rest/book/delete/12345678", Book.class);
       printEmpData(book);
    }
     
    public static void printEmpData(Book book){
        System.out.println("Author="+book.getAuthor()+",Name="+book.getBookName()+",ReleaseDate="+book.getReleaseDate()+" ,ISBN="+book.getISBN());
    }	
	
	
}
