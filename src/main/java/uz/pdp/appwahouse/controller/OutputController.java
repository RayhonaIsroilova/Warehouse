package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.entity.Output;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.InputDTO;
import uz.pdp.appwahouse.payload.OutputDTO;
import uz.pdp.appwahouse.repository.InputRepository;
import uz.pdp.appwahouse.repository.OutputRepository;
import uz.pdp.appwahouse.service.InputService;
import uz.pdp.appwahouse.service.OutputService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/input")
public class OutputController {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    OutputService outputService;

    @GetMapping
    public List<Output> getOutputs() {
        return outputRepository.findAll();
    }

    @GetMapping("/{id}")
    public Output getOutput(@PathVariable Integer id) {
        Optional<Output> byId = outputRepository.findById(id);
        if (!byId.isPresent()) return new Output();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingOutput(@RequestBody OutputDTO outputDTO) {
        return outputService.addOutput(outputDTO);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editingOutput(@PathVariable Integer id, @RequestBody OutputDTO outputDTO) {
        return outputService.editOutput(id, outputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteOutput(@PathVariable Integer id) {
        Optional<Output> byId = outputRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        outputRepository.delete(byId.get());
        return new ApiResponse("Deleting successfully", true);
    }

}
