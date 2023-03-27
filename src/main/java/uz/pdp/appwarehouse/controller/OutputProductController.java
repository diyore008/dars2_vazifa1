package uz.pdp.appwarehouse.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.OutputProduct;
import uz.pdp.appwarehouse.payload.OutputProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

    @PostMapping("/add")
    public Result add(@RequestBody  OutputProductDto outputProductDto){
        Result result = outputProductService.add(outputProductDto);
        return result;
    }

    @GetMapping("/getAll")
    public List<OutputProduct> getAll(){
        List<OutputProduct> allOutputProduct = outputProductService.getAll();
        return allOutputProduct;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto){
        Result result = outputProductService.update(id, outputProductDto);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = outputProductService.delete(id);
        return result;
    }

}
