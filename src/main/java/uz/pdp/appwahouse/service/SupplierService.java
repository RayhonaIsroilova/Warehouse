package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Supplier;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.SupplierRepository;

import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public ApiResponse addSupplier(Supplier supplier) {
        Supplier supplier1 = new Supplier();
        if (supplierRepository.existsByNameAndPhoneNumber(supplier.getName(), supplier.getPhoneNumber())) {
            return new ApiResponse("This name and phone number already added!", false);
        }
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplier1);
        return new ApiResponse("Added successfully", true);
    }

    public ApiResponse editSupplier(Integer id, Supplier supplier) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("This id not found", false);
        }
        Supplier supplier1 = byId.get();
        supplier1.setName(supplier.getName());
        if (supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber()))
            return new ApiResponse("This phone number already exist", false);
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplier1);
        return new ApiResponse("Edited successfully", true);
    }
}
