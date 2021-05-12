package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.InputProduct;
import uz.pdp.appwahouse.entity.OutputProduct;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputProductDTO;
import uz.pdp.appwahouse.payload.OutputProductDTO;
import uz.pdp.appwahouse.repository.InputProductRepository;
import uz.pdp.appwahouse.repository.OutputProductRepository;
import uz.pdp.appwahouse.service.InputProductService;
import uz.pdp.appwahouse.service.OutputProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inputProduct")
public class OutputProductController {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    OutputProductService outputProductService;

    @GetMapping
    public List<OutputProduct> getOutputs() {
        return outputProductRepository.findAll();
    }

    @GetMapping("/{id}")
    public OutputProduct getOutput(@PathVariable Integer id) {
        Optional<OutputProduct> byId = outputProductRepository.findById(id);
        if (!byId.isPresent()) return new OutputProduct();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingOutputProduct(@RequestBody OutputProductDTO outputDTO) {
        return outputProductService.addOutputProduct(outputDTO);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editingOutputProduct(@PathVariable Integer id, @RequestBody OutputProductDTO outputDTO) {
        return outputProductService.editOutputProduct(id, outputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteOutputProduct(@PathVariable Integer id) {
        Optional<OutputProduct> byId = outputProductRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        outputProductRepository.delete(byId.get());
        return new ApiResponse("Deleting successfully", true);
    }

}
