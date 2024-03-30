package com.funibertest.Repository;

import com.funibertest.Entity.CategoryEntity;
import com.funibertest.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategory(CategoryEntity category);
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByStock(boolean stock);
}
