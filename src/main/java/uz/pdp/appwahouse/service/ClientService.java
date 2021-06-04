package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Client;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ApiResponse addClient(Client client){
        Client client1 = new Client();
        if (clientRepository.existsByPhoneNumber(client.getPhoneNumber())) return new ApiResponse("This phoneNumber already added",false);
        client1.setName(client.getName());
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new ApiResponse("Added successfully",true);
    }
    public ApiResponse editClient(Integer id, Client client){
        Optional<Client> byId = clientRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id already exist",false);
        if (clientRepository.existsByPhoneNumber(client.getPhoneNumber())) return new ApiResponse("This phoneNumber already added",false);
        Client client1 = byId.get();
        client1.setName(client.getName());
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new ApiResponse("Edited successfully",true);
    }
}
