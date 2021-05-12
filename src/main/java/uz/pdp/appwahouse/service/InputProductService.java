package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.InputProduct;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputProductDTO;
import uz.pdp.appwahouse.repository.InputProductRepository;
import uz.pdp.appwahouse.repository.InputRepository;
import uz.pdp.appwahouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class InputProductService {

    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;

    public ApiResponse addInputProduct(InputProductDTO inputProductDTO) {
        InputProduct inputProduct = new InputProduct();
        inputProduct.setAmount(inputProductDTO.getAmount());
        inputProduct.setExpireDate(inputProductDTO.getExpireDate());
        inputProduct.setPrice(inputProductDTO.getPrice());
        inputProduct.setProduct(productRepository.getOne(inputProductDTO.getProductId()));
        inputProduct.setInput(inputRepository.getOne(inputProductDTO.getInputId()));
        inputProductRepository.save(inputProduct);
        return new ApiResponse("Added successfully", false);
    }

    public ApiResponse editInputProduct(Integer id, InputProductDTO inputProductDTO) {
        Optional<InputProduct> byId = inputProductRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        if (productRepository.existsById(inputProductDTO.getProductId()))
            return new ApiResponse("This Product id not found", false);
        if (inputRepository.existsById(inputProductDTO.getProductId()))
            return new ApiResponse("This Input id not found", false);
        InputProduct inputProduct = byId.get();
        inputProduct.setAmount(inputProductDTO.getAmount());
        inputProduct.setExpireDate(inputProductDTO.getExpireDate());
        inputProduct.setPrice(inputProductDTO.getPrice());
        inputProduct.setProduct(productRepository.getOne(inputProductDTO.getProductId()));
        inputProduct.setInput(inputRepository.getOne(inputProductDTO.getInputId()));
        inputProductRepository.save(inputProduct);
        return new ApiResponse("Edited successfully", false);
    }
}
