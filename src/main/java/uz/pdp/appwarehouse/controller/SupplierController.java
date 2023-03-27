package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("/add")
    public Result add(@RequestBody Supplier supplier){
        Result result = supplierService.add(supplier);
        return result;
    }

    @GetMapping("/getAll")
    public List<Supplier> getAll(){
        List<Supplier> allSupplier = supplierService.getAll();
        return allSupplier;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Supplier supplier){
        Result result = supplierService.update(id, supplier);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = supplierService.delete(id);
        return result;
    }



}
