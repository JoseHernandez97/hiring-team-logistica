package com.funibertest.Service;

import com.funibertest.Entity.CategoryEntity;
import com.funibertest.Entity.ProductEntity;
import com.funibertest.Repository.ProductChangeHistoryRepository;
import com.funibertest.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductChangeHistoryRepository productChangeHistoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ProductChangeHistoryRepository productChangeHistoryRepository) {
        this.productRepository = productRepository;
        this.productChangeHistoryRepository = productChangeHistoryRepository;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public List<ProductEntity> getProductsByCategory(CategoryEntity category) {
        return productRepository.findByCategory(category);
    }

    public List<ProductEntity> getProductsByStock(boolean stock) {
        return productRepository.findByStock(stock);
    }

    public ProductEntity updateProduct(Integer id, ProductEntity updatedProduct) {
        ProductEntity existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setCode(updatedProduct.getCode());
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setStock(updatedProduct.getStock());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    public boolean deleteProductById(Integer id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
