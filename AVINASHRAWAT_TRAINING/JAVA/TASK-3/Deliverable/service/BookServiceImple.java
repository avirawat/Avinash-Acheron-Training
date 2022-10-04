package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImple implements BookService {

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		
		return showBooks().stream()
			.filter((book)->book.getBookId()==bookid)
			.findAny()
			.orElseThrow(()-> new BookNotFoundException("invalid id"));
	
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		List<Book>bookByAuthor=showBooks().stream()
				   .filter((x)->x.getAuthor().equals(author))
				   .collect(Collectors.toList());
		
		if(bookByAuthor.size()==0)
			throw new BookNotFoundException("Invalid Author");
		return bookByAuthor;
	}

	@Override
	public List<Book> getBookByCategory(String category) throws BookNotFoundException {
		List<Book>bookByCategory=showBooks().stream()
				   .filter((x)->x.getCategory().equals(category))
				   .collect(Collectors.toList());
		
		if(bookByCategory.size()==0)
			throw new BookNotFoundException("Invalid Category");
		return bookByCategory;
		
	}

	@Override
	public List<Book> getAllBooks() {
		return showBooks();
	}

	@Override
	public List<Book> getBookByLessPrice(double price) throws BookNotFoundException {
		List<Book>bookByLessPrice=showBooks().stream()
				   .filter((x)->x.getPrice()<=price)
				   .collect(Collectors.toList());
		
		if(bookByLessPrice.size()==0)
			throw new BookNotFoundException("No Book Found");
		return bookByLessPrice;
		
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
