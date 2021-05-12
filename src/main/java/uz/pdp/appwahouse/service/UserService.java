package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.User;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ApiResponse addUser(User user){
        User user1 = new User();
        if (userRepository.existsById(user.getId())) return new ApiResponse("This id already exist",false);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setCode(user.getCode());
        user1.setPassword(user.getPassword());
        user1.setWarehouses(user.getWarehouses());
        userRepository.save(user1);
        return new ApiResponse("Added successfully",true);
    }
    public ApiResponse editUser(Integer id,User user){
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found",false);
        User user1 = byId.get();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setCode(user.getCode());
        user1.setPassword(user.getPassword());
        user1.setWarehouses(user.getWarehouses());
        userRepository.save(user1);
        return new ApiResponse("Edited successfully",true);
    }
}
