package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputDTO;
import uz.pdp.appwahouse.repository.InputRepository;
import uz.pdp.appwahouse.service.InputService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    InputService inputService;

    @GetMapping
    public List<Input> getInputs() {
        return inputRepository.findAll();
    }

    @GetMapping("/{id}")
    public Input getInput(@PathVariable Integer id) {
        Optional<Input> byId = inputRepository.findById(id);
        if (!byId.isPresent()) return new Input();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingInput(@RequestBody InputDTO inputDTO) {
        return inputService.addInput(inputDTO);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editingInput(@PathVariable Integer id, @RequestBody InputDTO inputDTO) {
        return inputService.editInput(id, inputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteInput(@PathVariable Integer id) {
        Optional<Input> byId = inputRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        inputRepository.delete(byId.get());
        return new ApiResponse("Deleting successfully", true);
    }

}
