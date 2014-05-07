package com.org.bookservice.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name="book")
public class Book {	
	 @Override
	public String toString() {
		return "Book [releaseDate=" + releaseDate + ", author=" + author
				+ ", price=" + price + ", rating=" + rating + ", ISBN=" + ISBN
				+ ", bookName=" + bookName + "]";
	}
	private static final long serialVersionUID = -7788619177798333712L;
	public Book() {		
		
	}
	@Column(name="RELEASEDATE") @NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date releaseDate ;
	
	@Column(name="AUTHOR")
	@Size(min=2, max=30) @NotNull
	private String author ;
	
	@Column(name="PRICE")
	@NotNull @Min(0) @NumberFormat
	private Double price ;
	
	@Column(name="RATING")
	@NotBlank
	private String rating ;
	
	@Id
    @Column(name="ISBN")
	@NotNull @NumberFormat	@Min(0)
    private long ISBN =0;
	
	@Column(name="BOOKNAME")
	@Size(min=2, max=30) @NotNull
	private String bookName;
	
	/**Gets the book name
	 * @return bookName
	 */
	public String getBookName() {
		return bookName;
	}	
	/**
	 * @param bookName new book name
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}	
	/**Gets the release date
	 * @return releaseDate
	 */
	@JsonSerialize(using=DateSerializer.class)
	public Date getReleaseDate() {
		return releaseDate;
	}	
	/**
	 * @param releaseDate new release date
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author new author 
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**Gets the price
	 * @return price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**Gets the rating
	 * @return rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating new rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**Gets the ISBN
	 * @return ISBN
	 */
	public long getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN new ISBN
	 */
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	
	
}
