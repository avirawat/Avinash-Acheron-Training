package com.bookApp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookApp.Repository.BookRepositoryImpl;
import com.bookApp.Repository.IBookRepository;
import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.exceptions.IdNotFoundException;
import com.bookApp.exceptions.InvalidDataException;
import com.bookApp.model.Book;

public class BookServiceImpl implements IBookService {

	IBookRepository bookRepo = new BookRepositoryImpl();

	public Integer addBook(Book book) throws Exception{
		int bookid=0;
		try {
		bookid=bookRepo.addBook(book);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new InvalidDataException("book not added");
		}
		return bookid;
	}

	public String updateBook(int bookid, double price) {
		if(bookid<0 || price<=0) {
			return "invalid";
		}
		bookRepo.updateBook(bookid, price);
			return "updated";
	}

	public Boolean deleteBook(int bookid) {
		if(bookid<=0) {
		return false;
		}
		bookRepo.deleteBook(bookid);
		return true;
	}

	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> bookByAuthor = bookRepo.getByAuthor(author);
		if (bookByAuthor.isEmpty())
			throw new BookNotFoundException("Book Not found");
		return bookByAuthor.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	public List<Book> getBookByCategory(String category) throws BookNotFoundException {
		List<Book> bookByCategory = bookRepo.getBookByCategory(category);
		if (bookByCategory.isEmpty()) {
			throw new BookNotFoundException("Book Not found");
		}
		return bookByCategory.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	public List<Book> getByLessPrice(double price) throws BookNotFoundException {
		List<Book> bookByPrice = bookRepo.getByLessPrice(price);
		if (bookByPrice.isEmpty()) {
			throw new BookNotFoundException("Book Not found");
		}
		return bookByPrice.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	public Book getById(int bookid) throws IdNotFoundException{
		Book BookById = bookRepo.getById(bookid);
		if (BookById == null) {
			throw new IdNotFoundException("Book Not found");
		}
		return BookById;
	}

	public IBookRepository getBookRepo() {
		return bookRepo;
	}

	public void setBookRepo(IBookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}


	

}
