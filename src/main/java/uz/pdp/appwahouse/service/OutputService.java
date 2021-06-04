package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.entity.Output;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputDTO;
import uz.pdp.appwahouse.payload.OutputDTO;
import uz.pdp.appwahouse.repository.*;

import java.util.Optional;

@Service
public class OutputService {

    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
   ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    public ApiResponse addOutput(OutputDTO outputDTO){
        Output output = new Output();
        if (outputRepository.existsByCode(outputDTO.getCode())) return  new ApiResponse("This code already added",false);
        output.setCode(outputDTO.getCode());
        output.setDate(outputDTO.getDate());
        output.setFactureNumber(outputDTO.getFactureNumber());
        output.setWarehouse(warehouseRepository.getOne(outputDTO.getWarehouseId()));
        output.setClient(clientRepository.getOne(outputDTO.getClientId()));
        output.setCurrency(currencyRepository.getOne(outputDTO.getCurrencyId()));
        outputRepository.save(output);
        return new ApiResponse("Added successfully",true);
    }
    public ApiResponse editOutput(Integer id,OutputDTO outputDTO){
        Optional<Output> byId = outputRepository.findById(id);
        if (!byId.isPresent()) return  new ApiResponse("This id not found",false);
        if (warehouseRepository.existsById(outputDTO.getWarehouseId())) return  new ApiResponse("This warehouse id  already exist",false);
        if (clientRepository.existsById(outputDTO.getClientId())) return new ApiResponse("This client id already exist",false);
        if (currencyRepository.existsById(outputDTO.getCurrencyId())) return new ApiResponse("This currency id already exist",false);
        Output output = byId.get();
        output.setCode(outputDTO.getCode());
        output.setDate(outputDTO.getDate());
        output.setFactureNumber(outputDTO.getFactureNumber());
        output.setWarehouse(warehouseRepository.getOne(outputDTO.getWarehouseId()));
        output.setClient(clientRepository.getOne(outputDTO.getClientId()));
        output.setCurrency(currencyRepository.getOne(outputDTO.getCurrencyId()));
        outputRepository.save(output);
        return new ApiResponse("Edited successfully",true);
    }
}
