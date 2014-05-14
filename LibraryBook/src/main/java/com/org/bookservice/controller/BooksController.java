package com.org.bookservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.org.bookservice.model.Book;
import com.org.bookservice.model.UserEntity;
import com.org.bookservice.services.BookManager;
import com.org.bookservice.utils.BookRestURIConstants;

/**
 * BooksController class
 */
@Controller
public class BooksController {
	
	private static final Logger logger = Logger.getLogger(BooksController.class);
	@Autowired
	private BookManager bookManager;
	 public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	Map<Long, Book> bookData = new HashMap<Long, Book>();
	 
	 @RequestMapping(value = BookRestURIConstants.UPDATE_BOOK, method = RequestMethod.PUT)
	    public @ResponseBody Book updateBook(@PathVariable("id") Long id,@RequestBody Book book) {
	        logger.info("Start update Book");
	        for(Map.Entry<Long, Book> entry : bookData.entrySet()){
	        	if(id==entry.getKey())
	        		bookData.put(id,book);
	        	break;	        	
	        }	        
	        return book;
	    }
	 @RequestMapping(value = BookRestURIConstants.GET_BOOK, method = RequestMethod.GET)
	    public @ResponseBody Book getBook(@PathVariable("isbn") long isbn) {
	        logger.info("Start getBook For ISBN:"+isbn);	        
	         return bookData.get(isbn);
	    }
	 @RequestMapping(value = BookRestURIConstants.DELETE_BOOK, method = RequestMethod.GET)
	    public @ResponseBody Book deleteBook(@PathVariable("isbn") long isbn) {
	        logger.info("Start deleteBook For ISBN:"+isbn);	        
	         return bookData.remove(isbn);
	        
	    } 
	 
	 @RequestMapping(value="/bookForm",method=RequestMethod.GET)  
	    public ModelAndView loadFormPage() {  
	        return new ModelAndView("home", "book", new Book());  
	    } 
	
	 
	 @RequestMapping(value = BookRestURIConstants.CREATE_BOOK,method = RequestMethod.POST)
		public  ModelAndView  createBook(@Valid Book book, BindingResult result,Model m) {
			logger.info("Start createBook.");
			ModelAndView modelAndView = new ModelAndView();
			if(result.hasErrors())
			{
				
				  modelAndView.setViewName("home");
				  modelAndView.addObject("book",book);
				  modelAndView.addObject("error","Addition Failed");
				  return modelAndView;		
			}

			else
			{
				bookManager.addBook(book);
			    modelAndView.setViewName("home");
				modelAndView.addObject("book", book);
				modelAndView.addObject("success","Addition Success");
					
			}
			  return modelAndView;	
			
		}
	 
	 @RequestMapping(value = BookRestURIConstants.GET_ALL_BOOK, method = RequestMethod.GET)
	    public  ModelAndView getAllBook() {
	        logger.info("Start get All the Books");
	        List <Book> bookList = bookManager.listBooks();
	          ModelAndView modelAndView = new ModelAndView();
			  modelAndView.setViewName("details");
			  modelAndView.addObject("bookList", bookList);
			  return modelAndView;			
	        
	    } 
	 
	 
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String defaultPage(ModelMap map) {
	        return "redirect:/bookForm";
	    }
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(ModelMap model) {
	        return "login";
	    }
	 
	    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	    public String loginerror(ModelMap model) {
	        model.addAttribute("error", "true");
	        return "denied";
	    }
	 
	    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String logout(ModelMap model) {
	        return "logout";
	    }
	 
	    
	    @RequestMapping(value = "/register", method = RequestMethod.GET)
	    public ModelAndView loadRegisterPage() {  
	        return new ModelAndView("register", "user", new UserEntity());  
	    } 
	    
	    
	    /*resam added*/
	    
	    @RequestMapping(value = "/CreditCard", method = RequestMethod.GET)
	    public String creditCardpage(Model model) throws PaymentException {
	        return "CreditCardHome";
	    }
	    
	 
	    
	
}
