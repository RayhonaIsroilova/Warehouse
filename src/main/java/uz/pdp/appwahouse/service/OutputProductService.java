package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.InputProduct;
import uz.pdp.appwahouse.entity.OutputProduct;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputProductDTO;
import uz.pdp.appwahouse.payload.OutputProductDTO;
import uz.pdp.appwahouse.repository.*;

import java.util.Optional;

@Service
public class OutputProductService {

    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository inputRepository;

    public ApiResponse addOutputProduct(OutputProductDTO outputProductDTO) {
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setAmount(outputProductDTO.getAmount());
        outputProduct.setPrice(outputProductDTO.getPrice());
        outputProduct.setProduct(productRepository.getOne(outputProductDTO.getProductId()));
        outputProduct.setOutput(inputRepository.getOne(outputProductDTO.getOutputId()));
        outputProductRepository.save(outputProduct);
        return new ApiResponse("Added successfully", false);
    }

    public ApiResponse editOutputProduct(Integer id, OutputProductDTO outputProductDTO) {
        Optional<OutputProduct> byId = outputProductRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        if (productRepository.existsById(outputProductDTO.getProductId()))
            return new ApiResponse("This Product id not found", false);
        if (inputRepository.existsById(outputProductDTO.getProductId()))
            return new ApiResponse("This Output id not found", false);
        OutputProduct outputProduct = byId.get();
        outputProduct.setAmount(outputProductDTO.getAmount());
        outputProduct.setPrice(outputProductDTO.getPrice());
        outputProduct.setProduct(productRepository.getOne(outputProductDTO.getProductId()));
        outputProduct.setOutput(inputRepository.getOne(outputProductDTO.getOutputId()));
        outputProductRepository.save(outputProduct);
        return new ApiResponse("Edited successfully", false);
    }
}
