package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImple implements BookService {

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		List<Book>bookList=showBooks();
		//List<Book>BookById=null;
		boolean isPresent=false;
		for(Book book:bookList) {
			if(book.getBookId()==bookid) {
				isPresent=true;
				return book;
			}
		}
		if(!isPresent)
			throw new BookNotFoundException("Invalid Id");
		return null;
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		List<Book>bookList=showBooks();
		List<Book>BookByAuthor=new ArrayList<>();
		boolean isPresent=false;
		for(Book book:bookList) {
			if(book.getAuthor().equals(author)) {
				isPresent=true;
				BookByAuthor.add(book);
			}
		}
		if(!isPresent)
			throw new BookNotFoundException("Invalid Author");
		return BookByAuthor;
	}

	@Override
	public List<Book> getBookByCategory(String category) throws BookNotFoundException {
		List<Book>bookList=showBooks();
		List<Book>BookByCategory=new ArrayList<>();
		boolean isPresent=false;
		for(Book book:bookList) {
			if(book.getCategory().equals(category)) {
				isPresent=true;
				BookByCategory.add(book);
			}
		}
		if(!isPresent)
			throw new BookNotFoundException("Invalid Category");
		return BookByCategory;
	}

	@Override
	public List<Book> getAllBooks() {
		return showBooks();
	}

	@Override
	public List<Book> getBookByLessPrice(double price) throws BookNotFoundException {
		List<Book>bookList=showBooks();
		List<Book>BookByLessPrice=new ArrayList<>();
		boolean isPresent=false;
		for(Book book:bookList) {
			if(book.getPrice()<price) {
				isPresent=true;
				BookByLessPrice.add(book);
			}
		}
		if(!isPresent)
			throw new BookNotFoundException("No Books found");
		return BookByLessPrice;
	}
	
	public List<Book> showBooks(){
		return Arrays.asList(
				new Book("java by sachin","Sachin","java",1200,100),
				new Book("java by Ayan","Ayan","c++",1201,101),
				new Book("java by Avinash","Avinash","java",1202,102),
				new Book("java by Sudheer","Sudheer","html",1000,103),
				new Book("java by jeeva","Jeeva","c++",1500,104),
				new Book("java by Suman","Suman","java",1300,105));
	}
}
