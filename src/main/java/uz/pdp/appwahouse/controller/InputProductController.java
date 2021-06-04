package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.entity.InputProduct;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputDTO;
import uz.pdp.appwahouse.payload.InputProductDTO;
import uz.pdp.appwahouse.repository.InputProductRepository;
import uz.pdp.appwahouse.repository.InputRepository;
import uz.pdp.appwahouse.service.InputProductService;
import uz.pdp.appwahouse.service.InputService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    @Autowired
    InputProductRepository inputRepository;
    @Autowired
    InputProductService inputService;

    @GetMapping
    public List<InputProduct> getInputs() {
        return inputRepository.findAll();
    }

    @GetMapping("/{id}")
    public InputProduct getInput(@PathVariable Integer id) {
        Optional<InputProduct> byId = inputRepository.findById(id);
        if (!byId.isPresent()) return new InputProduct();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingInputProduct(@RequestBody InputProductDTO inputDTO) {
        return inputService.addInputProduct(inputDTO);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editingInputProduct(@PathVariable Integer id, @RequestBody InputProductDTO inputDTO) {
        return inputService.editInputProduct(id, inputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteInputProduct(@PathVariable Integer id) {
        Optional<InputProduct> byId = inputRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        inputRepository.delete(byId.get());
        return new ApiResponse("Deleting successfully", true);
    }

}
