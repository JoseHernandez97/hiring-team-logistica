package com.funibertest.Service;

import com.funibertest.Entity.MeasuringTypeEntity;
import com.funibertest.Repository.MeasuringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasuringService {
    private final MeasuringRepository measuringRepository;

    @Autowired
    public MeasuringService(MeasuringRepository measuringRepository) {
        this.measuringRepository = measuringRepository;
    }
    public List<MeasuringTypeEntity> getAllMeasurements() {
        return measuringRepository.findAll();
    }

    public MeasuringTypeEntity saveMeasurement(MeasuringTypeEntity measurement) {
        return measuringRepository.save(measurement);
    }

    public boolean deleteMeasurementById(Integer id) {
        try{
            measuringRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
