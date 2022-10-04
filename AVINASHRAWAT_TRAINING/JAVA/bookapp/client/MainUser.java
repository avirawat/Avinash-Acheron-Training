package com.bookapp.client;

import java.util.List;
import java.util.Scanner;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImple;

public class MainUser {

	public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter 1-for All books \n 2-for Get Book By Id \n "
			+ "3-Get Book By author name\n 4-get book By Category\n 5-Get By book Less Price");
	int num;
	do {
		num=sc.nextInt();
		BookService bookService=new BookServiceImple();
		List<Book>allBook=bookService.getAllBooks();
		switch(num) {
		case 1:
			try {
				for(Book book:allBook) {
					System.out.println(book);
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case 2:
			System.out.println("Enter Id");
			int id=sc.nextInt();
			try {
				System.out.println(bookService.getBookById(id));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case 3:
			System.out.println("Enter Author name");
			sc.nextLine();
			String author=sc.nextLine();
			try {
				List<Book> getByAuthor=bookService.getBookByAuthor(author);
				for(Book book:getByAuthor) {
					System.out.println(book);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case 4:
			System.out.println("Enter category");
			sc.nextLine();
			String category=sc.nextLine();
			try {
				List<Book> getByCategory=bookService.getBookByCategory(category);
				for(Book book:getByCategory) {
					System.out.println(book);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case 5:
			System.out.println("Enter Your minimum price");
			Long price=sc.nextLong();
			try {
				List<Book> getByPrice=bookService.getBookByLessPrice(price);
				for(Book book:getByPrice) {
					System.out.println(book);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		default:
			System.out.println("wrong choice");
		}
	} while(num!=0);
	}
	
}
