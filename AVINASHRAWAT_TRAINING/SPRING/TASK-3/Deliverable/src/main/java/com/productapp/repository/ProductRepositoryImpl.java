package com.productapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource datasource) {
		this.setDataSource(datasource);
	}

	@Override
	public void addProduct(Product product) {
		String insertQuery = "insert into product(productName,price,category)values(?,?,?)";
		Object[] productArray = { product.getProductName(), product.getPrice(), product.getCategory() };
		jdbcTemplate.update(insertQuery, productArray);
	}

	@Override
	public void updateProduct(int productId, double price) {

		String updateQuery = "update product set price=? where productId=?";
		Object[] productArray = { price, productId };
		jdbcTemplate.update(updateQuery, productArray);

	}

	@Override
	public void deleteProduct(int productId) {
		String deleteQuery = "delete from product where productId=?";
		jdbcTemplate.update(deleteQuery, productId);
	}

	@Override
	public Product findById(int productid) throws ProductNotFoundException {
		String query="select * from product where productId=?";
		Product product=jdbcTemplate.queryForObject(query,new ProductMapper(),productid);
		return product;
	}

	@Override
	public List<Product> findAll() {
		String squery="select * from product";
		List<Product>productList=jdbcTemplate.query(squery,new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product =new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductId(rs.getInt(2));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				return product;
			}
			
		});
		return productList;
	}

	@Override
	public List<Product> findByCategory(String category) throws ProductNotFoundException {
		String squery="select * from product where category=?";
		List<Product>productList=jdbcTemplate.query(squery,new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product =new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductId(rs.getInt(2));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				return product;
			}
			},category);

		return productList;
	}

	@Override
	public List<Product> getByLessPrice(double price) throws ProductNotFoundException {
		String query="select * from product where price<=?";
		List<Product> product=jdbcTemplate.query(query,new ProductMapper(),price);
		return product;
	}

}
