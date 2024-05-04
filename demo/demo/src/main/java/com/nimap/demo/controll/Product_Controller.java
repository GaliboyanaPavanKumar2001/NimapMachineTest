package com.nimap.demo.controll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nimap.demo.dto.Category;
import com.nimap.demo.dto.Product;
import com.nimap.demo.service.Product_Service;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Product_Controller {
	@Autowired
    private Product_Service service;

    @PostMapping("/product/save/{id}")
    public Product saveProduct(@RequestBody Product product){
        return  service.saveProduct(product);
    }

    @GetMapping("/product/findById/{id}")
    public Optional<Product> findProductById(@PathVariable int id){
        return service.findProductById(id);
    }

    @GetMapping("/product")
   	public List<Product> getAllProduct(@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
   			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize){
   		return service.getAllProduct(pageNumber,pageSize);
   	}

    @PutMapping("/product/findById/{id}")
    public Product updateProductById(@PathVariable int id,@RequestBody Product product){
        return service.updateProductById(id,product);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProductById(@PathVariable int id){
        service.deleteById(id);
    }
}

