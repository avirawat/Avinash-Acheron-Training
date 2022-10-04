package com.bookApp.client;

import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.exceptions.IdNotFoundException;
import com.bookApp.exceptions.InvalidDataException;
import com.bookApp.model.Book;
import com.bookApp.service.BookServiceImpl;
import com.bookApp.service.IBookService;

public class Client {

	public static void main(String[] args) {
		IBookService bookService=new BookServiceImpl();
		Book book=new Book("cod","avi","java",290);
		try {
			System.out.println(bookService.addBook(book));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Book By Author");
		try {
			bookService.getByAuthor("Ayan").forEach(System.out::println);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Book By Category");
		try {
			bookService.getBookByCategory("java").forEach(System.out::println);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Book By price");
		try {
			bookService.getByLessPrice(200).forEach(System.out::println);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Book By Id");
		try {
			Book bookbyId=bookService.getById(2);
			System.out.println(bookbyId);
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
