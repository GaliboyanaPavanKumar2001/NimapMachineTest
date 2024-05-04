package com.nimap.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nimap.demo.dto.Product;
public interface Product_Repository extends JpaRepository<Product, Integer>{

}
