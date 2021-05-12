package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Category;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.payload.CategoryDTO;
import uz.pdp.appwahouse.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    public ApiResponse addCategory(CategoryDTO categoryDTO){
        Category category  = new Category();
        category.setName(categoryDTO.getName());
        if (categoryDTO.getParentCategoryId()!=null){
            Optional<Category> optional = categoryRepository.findById(categoryDTO.getParentCategoryId());
            if (!optional.isPresent())
                return new ApiResponse("There is not this parent category",false);
            category.setParentCategory(optional.get());
        }
        categoryRepository.save(category);
        return new ApiResponse("Added successfully",true);
    }

    public ApiResponse editCategory(Integer id,CategoryDTO categoryDTO){
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found",false);
        Category category = byId.get();
        if (categoryDTO.getParentCategoryId()!=null){
            category.setName(categoryDTO.getName());
            category.setParentCategory(byId.get());
             categoryRepository.save(category);
        }
        return new ApiResponse("Edited successfully",true);
    }
}
