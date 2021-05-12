package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Category;
import uz.pdp.appwahouse.entity.Client;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.CategoryDTO;
import uz.pdp.appwahouse.repository.CategoryRepository;
import uz.pdp.appwahouse.repository.ClientRepository;
import uz.pdp.appwahouse.service.CategoryService;
import uz.pdp.appwahouse.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Client getOneClient(@PathVariable Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        if (!byId.isPresent()) return new Client();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editClient(@PathVariable Integer id,@RequestBody Client client){
        return clientService.editClient(id,client);
    }

    @DeleteMapping("/deleting/{id}")
    public ApiResponse deleteClient(@PathVariable Integer id){
           if (!clientRepository.findById(id).isPresent()) return new ApiResponse("not found",false);
           clientRepository.deleteById(id);
           return new ApiResponse("Deleting successfully",true);
    }
}
