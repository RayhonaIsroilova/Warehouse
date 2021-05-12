package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Supplier;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.SupplierRepository;
import uz.pdp.appwahouse.service.SupplierService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable Integer id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (!byId.isPresent()) return new Supplier();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editingSupplier(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.editSupplier(id,supplier);
    }

    @DeleteMapping("deleting/{id}")
    public ApiResponse deleteSupplier(@PathVariable Integer id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("This id not found",false);
        }
        supplierRepository.delete(byId.get());
        return new ApiResponse("Deleted successfully",true);
    }
}
