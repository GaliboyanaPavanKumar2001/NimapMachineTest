package com.nimap.demo.controll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nimap.demo.dto.Category;
import com.nimap.demo.service.Category_Service;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Category_Controller {
	@Autowired
    private Category_Service service;

    @PostMapping("/categories/save")
    public Category saveCategory(@RequestBody  Category category){
        return service.saveCategory(category);
    }

    @GetMapping("/categories/findById/{id}")
    public Optional<Category> findCategoryById(@PathVariable int id){
        return service.findCategoryById(id);
    }

    @GetMapping("/categories")
   	public List<Category> getAllCategory(@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
   			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize){
   		return service.getAllCategoryt(pageNumber,pageSize);
   	}

    @PutMapping("/categories/findById/{id}")
    public Category updateById(@PathVariable int id,@RequestBody Category category){
        return service.updateById(id, category);
    }

    @DeleteMapping("/categories/delete/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

}
