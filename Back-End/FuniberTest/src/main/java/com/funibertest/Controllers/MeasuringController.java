package com.funibertest.Controllers;

import com.funibertest.Entity.MeasuringTypeEntity;
import com.funibertest.Service.MeasuringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measuring")
public class MeasuringController {
    private final MeasuringService measuringService;

    @Autowired
    public MeasuringController(MeasuringService measuringService) {
        this.measuringService = measuringService;
    }

    @GetMapping
    public ResponseEntity<List<MeasuringTypeEntity>> getAllMeasurements() {
        List<MeasuringTypeEntity> measurements = measuringService.getAllMeasurements();
        return ResponseEntity.ok(measurements);
    }

    @PostMapping
    public ResponseEntity<MeasuringTypeEntity> createMeasurement(@RequestBody MeasuringTypeEntity measurement) {
        MeasuringTypeEntity savedMeasurement = measuringService.saveMeasurement(measurement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMeasurement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Integer id) {
        if (measuringService.deleteMeasurementById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
