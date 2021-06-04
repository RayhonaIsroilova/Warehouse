package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Measurement;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.MeasurementRepository;
import uz.pdp.appwahouse.service.MeasurementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @Autowired
    MeasurementRepository measurementRepository;

    @GetMapping("/getList")
    public List<Measurement> getMeasurements(){
        return measurementRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Measurement getMeasurement(@PathVariable Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (!byId.isPresent()) return new Measurement();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addMeasurement(@RequestBody Measurement measurement) {
        return measurementService.addMeasurement(measurement);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editMeasurement(@RequestBody Measurement measurement,@PathVariable Integer id){
        return measurementService.editMeasurement(measurement,id);
    }

    @DeleteMapping("/deleting/{id}")
    public ApiResponse deleteMeasurement(@PathVariable Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id don't found",false);
        Measurement measurement = byId.get();
        measurementRepository.delete(measurement);
        return new ApiResponse("Delete successfully",true);
    }
}
