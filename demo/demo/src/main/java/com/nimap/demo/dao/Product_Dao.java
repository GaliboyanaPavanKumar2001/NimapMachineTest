package com.nimap.demo.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.nimap.demo.dto.Category;
import com.nimap.demo.dto.Product;
import com.nimap.demo.repository.Product_Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Product_Dao {
	 @Autowired
	    private Product_Repository repository;

	    public Product saveProduct(Product product){
	        return  repository.save(product);
	    }

	    public Optional<Product> findProductById(int id){
	        return  repository.findById(id);
	    }

	    public List<Product> getAllProduct(Integer pageNumber, Integer pageSize) {
			Pageable p=PageRequest.of(pageNumber, pageSize);
			Page<Product> pageProduct= this.repository.findAll(p);
			List<Product> allProduct= pageProduct.getContent();
			return allProduct;
	    }

	    public Product updateProductById(int id, Product product){
	        product.setId(id);
	        return repository.save(product);
	    }

	    public void deleteProductById(int id){
	        repository.deleteById(id);
	    }
	
}
