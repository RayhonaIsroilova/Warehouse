package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputDTO;
import uz.pdp.appwahouse.repository.CurrencyRepository;
import uz.pdp.appwahouse.repository.InputRepository;
import uz.pdp.appwahouse.repository.SupplierRepository;
import uz.pdp.appwahouse.repository.WarehouseRepository;

import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    public ApiResponse addInput(InputDTO inputDTO){
        Input input = new Input();
        if (inputRepository.existsByCode(inputDTO.getCode())) return  new ApiResponse("This code already added",false);
        input.setCode(inputDTO.getCode());
        input.setDate(inputDTO.getDate());
        input.setFactureNumber(inputDTO.getFactureNumber());
        input.setWarehouse(warehouseRepository.getOne(inputDTO.getWarehouseId()));
        input.setSupplier(supplierRepository.getOne(inputDTO.getSupplierId()));
        input.setCurrency(currencyRepository.getOne(inputDTO.getCurrencyId()));
        inputRepository.save(input);
        return new ApiResponse("Added successfully",true);
    }
    public ApiResponse editInput(Integer id,InputDTO inputDTO){
        Optional<Input> byId = inputRepository.findById(id);
        if (!byId.isPresent()) return  new ApiResponse("This id not found",false);
        if (warehouseRepository.existsById(inputDTO.getWarehouseId())) return  new ApiResponse("This warehouse id  already exist",false);
        if (supplierRepository.existsById(inputDTO.getSupplierId())) return new ApiResponse("This suppler id already exist",false);
        if (currencyRepository.existsById(inputDTO.getCurrencyId())) return new ApiResponse("This currency id already exist",false);
        Input input = byId.get();
        input.setCode(inputDTO.getCode());
        input.setDate(inputDTO.getDate());
        input.setFactureNumber(inputDTO.getFactureNumber());
        input.setWarehouse(warehouseRepository.getOne(inputDTO.getWarehouseId()));
        input.setSupplier(supplierRepository.getOne(inputDTO.getSupplierId()));
        input.setCurrency(currencyRepository.getOne(inputDTO.getCurrencyId()));
        inputRepository.save(input);
        return new ApiResponse("Edited successfully",true);
    }
}
