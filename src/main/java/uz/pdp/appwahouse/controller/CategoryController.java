package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Category;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.CategoryDTO;
import uz.pdp.appwahouse.repository.CategoryRepository;
import uz.pdp.appwahouse.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Category getOneCategory(@PathVariable Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) return new Category();
        return byId.get();
    }

    @PostMapping("/adding")
    public ApiResponse addingCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }

    @PutMapping("/editing/{id}")
    public ApiResponse editCategory(@PathVariable Integer id,@RequestBody CategoryDTO categoryDTO){
        return categoryService.editCategory(id,categoryDTO);
    }

    @DeleteMapping("/deleting/{id}")
    public ApiResponse deleteCategory(@PathVariable Integer id){
           if (!categoryRepository.findById(id).isPresent()) return new ApiResponse("not found",false);
           categoryRepository.deleteById(id);
           return new ApiResponse("Deleting successfully",true);
    }
}
