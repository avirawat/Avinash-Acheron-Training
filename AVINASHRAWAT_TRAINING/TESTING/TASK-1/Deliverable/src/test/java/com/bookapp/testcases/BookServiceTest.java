package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookApp.Repository.IBookRepository;
import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.exceptions.InvalidDataException;
import com.bookApp.model.Book;
import com.bookApp.service.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

	@Mock
	IBookRepository repository;

	@InjectMocks
	BookServiceImpl bookService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	List<Book> bookList;
	Book book1, book2, book3, book4, book5;

	@BeforeEach
	void setUp() throws Exception {
		bookService = new BookServiceImpl();
		bookService.setBookRepo(repository);
		book1 = new Book("java", "kathy", "Tech", 900);
		book2 = new Book("Spring", "kathy", "Tech", 900);
		book3 = new Book("javac", "kathy", "Tech", 900);
		book4 = new Book("Leadership", "kathy", "Tech", 1800);
		book5 = new Book("miracle", "Hal", "Tech", 500);
		bookList = Arrays.asList(book1, book2, book3, book4, book5);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("text add book")
	void textAddBook() throws Exception {
		when(repository.addBook(book1)).thenReturn(1);
		assertEquals(1, bookService.addBook(book1), "not added");
	}

	@Test
	@DisplayName("text add book Exception")
	void textAddErrorBook() throws Exception {
		when(repository.addBook(book1)).thenThrow(Exception.class);
		assertThrows(InvalidDataException.class, () -> bookService.addBook(book1));
	}

	@Test
	@DisplayName("text update Book +ve")
	void textUpdateBook() {
		doNothing().when(repository).updateBook(1, 800);
		assertEquals("updated", bookService.updateBook(1, 800));

	}

	@Test
	@DisplayName("text update Book -ve")
	void textUpdateNegBook() {
		// doNothing().when(repository).updateBook(-2,800);
		assertEquals("invalid", bookService.updateBook(-1, 800), "not same");

	}

	@Test
	@DisplayName("text delete Book +ve ")
	void textDeleteBook() {
		doNothing().when(repository).deleteBook(1);
		assertTrue(bookService.deleteBook(1));

	}

	@Test
	@DisplayName("text delete Book -ve ")
	void textErrorBook() {
		// doNothing().when(repository).deleteBook(-1);
		assertFalse(bookService.deleteBook(-1));

	}

	@Test
	@DisplayName("testing get By Author ")
	void testGetByAuthor() {
		String author = "kathy";
		when(repository.getByAuthor(author)).thenReturn(Arrays.asList(book1, book2, book3));
		assertEquals(3, bookService.getByAuthor(author).size(), "same");

		List<Book> dummyBooks = Arrays.asList(book2, book1, book3);
		assertEquals(dummyBooks, bookService.getByAuthor(author));

	}

	@Test
	@DisplayName("testing get By Author NULL ")
	void testGetByAuthorEmpty() throws BookNotFoundException {
		String author = "kathy";
		when(repository.getByAuthor(author)).thenReturn(new ArrayList<Book>());
		assertThrows(BookNotFoundException.class, () -> bookService.getByAuthor(author));
	}

	@Test
	@DisplayName("testing get By Category")
	void testGetByCategory() {
		String category = "Tech";
		when(repository.getBookByCategory(category)).thenReturn(Arrays.asList(book1, book2, book3));
		assertEquals(3, bookService.getBookByCategory(category).size(), "same");

		List<Book> dummyBooks = Arrays.asList(book2, book1, book3);
		assertEquals(dummyBooks, bookService.getBookByCategory(category));

	}

	@Test
	@DisplayName("testing get By Category Null ")
	void testGetByCategoryEmpty() throws BookNotFoundException {
		String category = "Tech";
		when(repository.getBookByCategory(category)).thenReturn(new ArrayList<Book>());
		assertThrows(BookNotFoundException.class, () -> bookService.getBookByCategory(category));
	}

	@Test
	@DisplayName("testing get By Less By Price")
	void testGetByLessPrice() {
		double price = 900.0;
		when(repository.getByLessPrice(price)).thenReturn(Arrays.asList(book1, book2, book3));
		assertEquals(3, bookService.getByLessPrice(price).size(), "same");

		List<Book> dummyBooks = Arrays.asList(book2, book1, book3);
		assertEquals(dummyBooks, bookService.getByLessPrice(price));

	}

	@Test
	@DisplayName("testing get By price NULL ")
	void testGetByPriceEmpty() throws BookNotFoundException {
		double price = 900.0;
		when(repository.getByLessPrice(price)).thenReturn(new ArrayList<Book>());
		assertThrows(BookNotFoundException.class, () -> bookService.getByLessPrice(price));
	}

	@Test
	@DisplayName("testing Book By Id ")
	void testGetById() {
		int bookid = 1;
		when(repository.getById(bookid)).thenReturn(book1);
		assertEquals(book1, bookService.getById(bookid), "same");
	}

	@Test
	@DisplayName("testing Book By Id Exception ")
	void testErrorGetById() throws BookNotFoundException {
		int bookid = 1;
		when(repository.getById(bookid)).thenThrow(BookNotFoundException.class);
		assertThrows(BookNotFoundException.class, () -> bookService.getById(bookid));
	}
}
