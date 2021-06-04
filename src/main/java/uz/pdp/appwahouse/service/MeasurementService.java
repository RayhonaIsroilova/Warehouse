package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Measurement;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.MeasurementRepository;

import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    public ApiResponse addMeasurement(Measurement measurement) {
        boolean b = measurementRepository.existsByName(measurement.getName());
        if (b) {
            return new ApiResponse("there are this name in database", false);
        }
        measurementRepository.save(measurement);
        return new ApiResponse("Added successfully", true);
    }

    public ApiResponse editMeasurement(Measurement measurement, Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        Measurement measurement1 = byId.get();
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        if (measurementRepository.existsByName(measurement.getName())) return new ApiResponse("Already exist", false);
        measurement1.setName(measurement.getName());
        measurementRepository.save(measurement1);
        return new ApiResponse("Edited successfully", true);
    }


}
