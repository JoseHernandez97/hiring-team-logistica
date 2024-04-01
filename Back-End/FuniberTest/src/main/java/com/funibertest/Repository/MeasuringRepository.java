package com.funibertest.Repository;

import com.funibertest.Entity.MeasuringTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasuringRepository extends JpaRepository<MeasuringTypeEntity, Integer> {
}
