package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Product;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.ProductDTO;
import uz.pdp.appwahouse.repository.AttachmentRepository;
import uz.pdp.appwahouse.repository.CategoryRepository;
import uz.pdp.appwahouse.repository.MeasurementRepository;
import uz.pdp.appwahouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    public ApiResponse addProduct(ProductDTO productDTO) {
        Product product1 = new Product();
        if (productRepository.existsByName(productDTO.getName())) {
            return new ApiResponse("This name already exist", false);
        }
        product1.setName(productDTO.getName());
        product1.setCode(productDTO.getCode());
        product1.setCategory(categoryRepository.getOne(productDTO.getCategoryId()));
        product1.setMeasurement(measurementRepository.getOne(productDTO.getMeasurementId()));
        product1.setPhoto(attachmentRepository.getOne(productDTO.getPhotoId()));
        productRepository.save(product1);
        return new ApiResponse("Added successfully", true);
    }
    public ApiResponse editProduct(Integer id,ProductDTO productDTO){
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found",false);
        Product product = byId.get();
        product.setCode(productDTO.getCode());
        if (productRepository.existsByName(productDTO.getName())) return new ApiResponse("This name already exist",false);
        product.setName(productDTO.getName());
        if (categoryRepository.existsById(productDTO.getCategoryId())) return new ApiResponse("This id is already exist",false);
        product.setCategory(categoryRepository.getOne(productDTO.getCategoryId()));
        if (attachmentRepository.existsById(productDTO.getPhotoId()))  return new ApiResponse("This id is already exist",false);
        product.setPhoto(attachmentRepository.getOne(productDTO.getPhotoId()));
        if (measurementRepository.existsById(productDTO.getMeasurementId()))  return new ApiResponse("This id is already exist",false);
        product.setMeasurement(measurementRepository.getOne(productDTO.getMeasurementId()));
        productRepository.save(product);
        return new ApiResponse("Edited successfully",true);
    }

}
