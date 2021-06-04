package uz.pdp.appwahouse.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.User;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.UserRepository;
import uz.pdp.appwahouse.service.UserService;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) return new User();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editingUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.editUser(id, user);
    }

    @DeleteMapping("/deleting/{id}")
    public ApiResponse deleteUser(@PathVariable Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found", false);
        userRepository.delete(byId.get());
        return new ApiResponse("Deleting successfully", true);
    }
}
