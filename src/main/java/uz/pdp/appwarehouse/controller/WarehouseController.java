package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/add")
    public Result add(@RequestBody Warehouse warehouse){
        Result result = warehouseService.add(warehouse);
        return result;
    }

    @GetMapping("/getAll")
    public List<Warehouse> getAll(){
        List<Warehouse> allWarehouse = warehouseService.getAll();
        return allWarehouse;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Warehouse warehouse){
        Result result = warehouseService.update(id, warehouse);
        return result;
    }

    @DeleteMapping("/deleted/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = warehouseService.delete(id);
        return result;
    }
}
