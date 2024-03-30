package com.funibertest.Repository;


import com.funibertest.Entity.ProductChangeHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductChangeHistoryRepository extends JpaRepository<ProductChangeHistoryEntity, Integer> {
}
