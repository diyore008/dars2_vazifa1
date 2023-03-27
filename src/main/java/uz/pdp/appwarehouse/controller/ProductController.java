package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public Result addProduct(@RequestBody ProductDto productDto){
        Result result = productService.addProduct(productDto);
        return result;
    }

    @GetMapping("/getAll")
    public List<Product> getAll(){
        List<Product> allProduct = productService.getAll();
        return allProduct;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id,@RequestBody ProductDto productDto){
        Result result = productService.update(id, productDto);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result deleted(@PathVariable Integer id){
        Result result = productService.delete(id);
        return result;
    }
}
