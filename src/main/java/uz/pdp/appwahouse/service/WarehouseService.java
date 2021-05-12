package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Warehouse;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.WarehouseRepository;

import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse addWarehouse(Warehouse warehouse) {
        Warehouse warehouse1 = new Warehouse();
        if (warehouseRepository.existsByName(warehouse.getName()))
            return new ApiResponse("This name already added", false);
        warehouse1.setName(warehouse.getName());
        warehouseRepository.save(warehouse1);
        return new ApiResponse("Added successfully", true);
    }

    public ApiResponse editWarehouse(Integer id, Warehouse warehouse) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("This id not found", false);
        }
        Warehouse warehouse1 = byId.get();
        if (warehouseRepository.existsByName(warehouse.getName()))
            return new ApiResponse("This name already exist", false);
        warehouse1.setName(warehouse.getName());
        warehouseRepository.save(warehouse1);
        return new ApiResponse("Edited successfully", true);
    }
}
