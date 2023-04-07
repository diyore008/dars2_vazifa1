package uz.pdp.dars1_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dars1_vazifa2.entity.InputProduct;
import uz.pdp.dars1_vazifa2.payload.InputProductDto;
import uz.pdp.dars1_vazifa2.payload.Result;
import uz.pdp.dars1_vazifa2.service.InputProductService;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {

    @Autowired
    InputProductService inputProductService;

    @PostMapping("/add")
    public Result add(@RequestBody InputProductDto inputProductDto){
        Result result = inputProductService.add(inputProductDto);
        return result;
    }

    @GetMapping("/getAll")
    public List<InputProduct> getAll(){
        List<InputProduct> allInputProduct = inputProductService.getAll();
        return allInputProduct;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto){
        Result result = inputProductService.update(id, inputProductDto);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = inputProductService.delete(id);
        return result;
    }
}
