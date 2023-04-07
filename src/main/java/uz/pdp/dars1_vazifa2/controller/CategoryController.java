package uz.pdp.dars1_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dars1_vazifa2.entity.Category;
import uz.pdp.dars1_vazifa2.payload.CategoryDto;
import uz.pdp.dars1_vazifa2.payload.Result;
import uz.pdp.dars1_vazifa2.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return  result;
    }

    @GetMapping("/getAll")
    public List<Category> getAll(){
        List<Category> categoryList = categoryService.getAll();
        return categoryList;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        Result result = categoryService.update(id, categoryDto);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = categoryService.delete(id);
        return result;
    }
}

