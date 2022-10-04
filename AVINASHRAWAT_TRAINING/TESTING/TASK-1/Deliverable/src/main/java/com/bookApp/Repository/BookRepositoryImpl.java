package com.bookApp.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.model.Book;

public class BookRepositoryImpl implements IBookRepository{
	
	static Connection connection;
	public Integer addBook(Book book) throws Exception{
		connection=BookDAO.openConnection();
		String insertQuery="insert into book(title,author,category,price) values(?,?,?,?)";
		PreparedStatement statement=null;
		int bookid=0;
		try {
			statement=connection.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1,book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setDouble(4, book.getPrice());
			statement.executeUpdate();
			//get auto generate key
			ResultSet rs=statement.getGeneratedKeys();
			while(rs.next()) {
				bookid=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		BookDAO.closeConnection();
		return bookid;
	}

	public void updateBook(int bookid, double price) {
			connection=BookDAO.openConnection();
			String updateQuery="update book set price=? where bookid=?";
			PreparedStatement statement=null;
			try {
				statement=connection.prepareStatement(updateQuery);
				statement.setDouble(1, price);
				statement.setInt(2, bookid);
				statement.execute();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			BookDAO.closeConnection();
	}

	public void deleteBook(int bookid) {
		connection=BookDAO.openConnection();
		String deleteQuery="delete from book where bookid=?";
		PreparedStatement statement=null;
		try {
			statement=connection.prepareStatement(deleteQuery);
			statement.setInt(1, bookid);
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		BookDAO.closeConnection();
	}

	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		connection=BookDAO.openConnection();
		List<Book>BookByAuthor=new ArrayList<Book>();
		String selectQuery="select * from book where author=?";
		PreparedStatement statement=null;
		try {
			statement=connection.prepareStatement(selectQuery);
			statement.setString(1,author);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				BookByAuthor.add(book);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		BookDAO.closeConnection();
		return BookByAuthor;
	}

	public List<Book> getBookByCategory(String category) throws BookNotFoundException{
		connection=BookDAO.openConnection();
		List<Book>BookByCategory=new ArrayList<Book>();
		String selectQuery="select * from book where category=?";
		PreparedStatement statement=null;
		try {
			statement=connection.prepareStatement(selectQuery);
			statement.setString(1,category);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				BookByCategory.add(book);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			//throw e;
		}
		BookDAO.closeConnection();
		return BookByCategory;
	}

	public List<Book> getByLessPrice(double price) throws BookNotFoundException{
		connection=BookDAO.openConnection();
		List<Book>BookByPrice=new ArrayList<Book>();
		String selectQuery="select * from book where price<=?";
		PreparedStatement statement=null;
		try {
			statement=connection.prepareStatement(selectQuery);
			statement.setDouble(1,price);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				BookByPrice.add(book);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		BookDAO.closeConnection();
		return BookByPrice;
	}

	public Book getById(int bookid) {
		connection=BookDAO.openConnection();
		Book book=null;
		String selectQuery="select * from book where bookid=?";
		PreparedStatement statement=null;
		try {
			statement=connection.prepareStatement(selectQuery);
			statement.setDouble(1,bookid);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				book=new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		BookDAO.closeConnection();
		return book;
	}

}
