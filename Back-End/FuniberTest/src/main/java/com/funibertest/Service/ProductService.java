package com.funibertest.Service;

import com.funibertest.Entity.CategoryEntity;
import com.funibertest.Entity.ProductChangeHistoryEntity;
import com.funibertest.Entity.ProductEntity;
import com.funibertest.Repository.ProductChangeHistoryRepository;
import com.funibertest.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        ProductEntity savedProduct = productRepository.save(product);
        if (savedProduct != null) {
            saveChangeHistory(savedProduct, "CREATION", "Product created");
        }
        return savedProduct;
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
            existingProduct.setMeasuring(updatedProduct.getMeasuring());
            ProductEntity updatedProductEntity = productRepository.save(existingProduct);
            if (updatedProductEntity != null) {
                saveChangeHistory(updatedProductEntity, "UPDATE", "Product updated");
            }
            return updatedProductEntity;
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
    private void saveChangeHistory(ProductEntity product, String changeType, String changeDetails) {
        ProductChangeHistoryEntity changeHistory = new ProductChangeHistoryEntity();
        changeHistory.setProduct(product);
        changeHistory.setChangeDate(new Date());
        changeHistory.setChangeType(changeType);
        changeHistory.setChangeDetails(changeDetails);
        productChangeHistoryRepository.save(changeHistory);
    }
}

