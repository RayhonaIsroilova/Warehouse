package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Warehouse;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.WarehouseRepository;
import uz.pdp.appwahouse.service.WarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getWarehouses(){
        return warehouseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouse(@PathVariable Integer id){
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if (!byId.isPresent()) return new Warehouse();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.addWarehouse(warehouse);
    }
    @PutMapping("/editing/{id}")
    public ApiResponse editingWarehouse(@PathVariable Integer id,@RequestBody Warehouse warehouse){
        return warehouseService.editWarehouse(id,warehouse);
    }
    @DeleteMapping("/deleting/{id}")
    public ApiResponse deletingWarehouse(@PathVariable Integer id){
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if (!byId.isPresent()) return  new ApiResponse("This id not found",false);
        warehouseRepository.delete(byId.get());
        return new ApiResponse("Deleting successfully",true);
    }
}
