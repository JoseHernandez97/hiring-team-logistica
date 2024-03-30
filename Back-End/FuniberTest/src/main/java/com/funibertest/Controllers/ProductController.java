package com.funibertest.Controllers;

import com.funibertest.Entity.CategoryEntity;
import com.funibertest.Entity.ProductEntity;
import com.funibertest.Service.CategoryService;
import com.funibertest.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService=categoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ProductEntity>> getProductByName(@PathVariable String name) {
        List<ProductEntity> products = productService.getProductByName(name);
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductEntity>> getProductsByCategoryId(@PathVariable Integer categoryId) {
        CategoryEntity category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            List<ProductEntity> products = productService.getProductsByCategory(category);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/stock/{stock}")
    public ResponseEntity<List<ProductEntity>> getProductsByStock(@PathVariable boolean stock) {
        List<ProductEntity> products = productService.getProductsByStock(stock);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        ProductEntity newProduct = productService.saveProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Integer code, @RequestBody ProductEntity updatedProduct) {
        ProductEntity product = productService.updateProduct(code, updatedProduct);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer code) {
        boolean deleted = productService.deleteProductById(code);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
