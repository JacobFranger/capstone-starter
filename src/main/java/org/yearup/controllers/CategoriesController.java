package org.yearup.controllers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

// add the annotations to make this a REST controller
@RestController
@RequestMapping
// add the annotation to make this controller the endpoint for the following url

    // http://localhost:8080/categories
// add annotation to allow cross site origin requests
public class CategoriesController
{
            Class.("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/northwind",
            "root",
            "    password    ");

@Autowired
    private CategoryDao categoryDao;
@Autowired
    private ProductDao productDao;


    // create an Autowired controller to inject the categoryDao and ProductDao


    // add the appropriate annotation for a get action
    @PathVariable
    public List<Category> getAll()
    {
        // find and return all categories
      try {
       productDao;
      }
    catch (Exception ex){
          categoryDao.getById(id);
    }
        return null;
    }

    // add the appropriate annotation for a get action
    @RequestMapping(path = "/ categories/{id} ", method = RequestMethod.GET)
    public Category getById(@PathVariable int id)
    {
        // get the category by id
        return this.categoryDao.getById(id);
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products

    @GetMapping("{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId)
    {
        // get a list of product by categoryId
        return this.productDao.getById(id) ;
    }

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ADMIN')")
    public Category addCategory(@RequestBody Category category)
    {
        // insert the category

        return null;
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ADMIN')")
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        // update the category by id

    }


    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id)
    {
        // delete the category by id
    }
}
