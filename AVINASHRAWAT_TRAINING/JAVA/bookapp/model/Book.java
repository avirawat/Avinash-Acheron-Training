package com.bookapp.model;

public class Book {
	
	private String title;
	private String author,category;
	double price;
	Integer bookId;
	public Book(String title, String author, String category, double price, Integer bookId) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price
				+ ", bookId=" + bookId + "]";
	}
	
	
}
