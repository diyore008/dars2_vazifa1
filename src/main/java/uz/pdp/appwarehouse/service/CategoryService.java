package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());

        if (categoryDto.getCategoryId() != null){
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getCategoryId());
            if (!optionalParentCategory.isPresent())
                return new Result("Category not found", false);
            category.setParentCategory(optionalParentCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Successfully added", true);
    }

    public List<Category> getAll(){
        List<Category> allCategory = categoryRepository.findAll();
        return allCategory;
    }

    public Result update(Integer id, CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("Category not found", false);

        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());

        if (categoryDto.getCategoryId() != null){
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getCategoryId());
            if (!optionalParentCategory.isPresent())
                return new Result("Parent category not found", false);
            category.setParentCategory(optionalParentCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Update category", true);
    }

    public Result delete(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            categoryRepository.deleteById(id);
            return new Result("Deleted category", true);
        }
        return new Result("Category not found", false);
    }
}
