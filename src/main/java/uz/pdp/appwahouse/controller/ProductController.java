package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Product;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.ProductDTO;
import uz.pdp.appwahouse.repository.ProductRepository;
import uz.pdp.appwahouse.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return new Product();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        return productService.editProduct(id, productDTO);
    }

    @DeleteMapping("/deleting/{id}")
    public ApiResponse deleteProduct(@PathVariable Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        Product product = byId.get();
        Integer id1 = product.getPhoto().getId();
        productRepository.deleteById(id1);
        productRepository.delete(product);
        return new ApiResponse("Deleting successfully", true);
    }

}
