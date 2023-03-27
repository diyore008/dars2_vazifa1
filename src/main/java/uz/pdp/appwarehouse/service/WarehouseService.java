package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result add(Warehouse warehouse){
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("Such a name already exists", false);

        Warehouse addWarehouse = new Warehouse();
        addWarehouse.setName(warehouse.getName());
        warehouseRepository.save(addWarehouse);
        return new Result("Saved warehouse", true);
    }

    public List<Warehouse> getAll(){
        List<Warehouse> allWarehouse = warehouseRepository.findAll();
        return allWarehouse;
    }

    public Result update(Integer id, Warehouse warehouse){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found", false);
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("Such a name already exists", false);

        Warehouse upWarehouse = optionalWarehouse.get();
        upWarehouse.setName(warehouse.getName());
        warehouseRepository.save(upWarehouse);
        return new Result("Updated warehouse", true);
    }

    public Result delete(Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()){
            warehouseRepository.deleteById(id);
            return new Result("Deleted warehouse", true);
        }
        return new Result("Warehouse not found", false);
    }
}
