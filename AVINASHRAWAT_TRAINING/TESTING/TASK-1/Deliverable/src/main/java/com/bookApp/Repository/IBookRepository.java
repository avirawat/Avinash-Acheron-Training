package com.bookApp.Repository;

import java.util.List;

import com.bookApp.model.Book;

public interface IBookRepository {
	Integer addBook(Book book) throws Exception;
	void updateBook(int bookid,double price);
	void deleteBook(int bookid);
	
	List<Book> getByAuthor(String author);
	List<Book> getBookByCategory(String category);
	List<Book> getByLessPrice(double price);
	Book getById(int bookid);
}
