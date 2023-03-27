package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.InputDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.InputRepository;
import uz.pdp.appwarehouse.repository.SupplierRepository;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;

    String s = UUID.randomUUID().toString();
    public Result add(InputDto inputDto){

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent()) {
            return new Result("Warehouse not found", false);
        }
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent()) {
            return new Result("Supplier not found", false);
        }


        Input input = new Input();
        input.setDate(inputDto.getDate());
        input.setCode(s);
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        input.setFactureNumber("1234");
        inputRepository.save(input);
        return new Result("Saved input", true);
    }

    public List<Input> getAll(){
        List<Input> allInputs = inputRepository.findAll();
        return allInputs;
    }

    public Result update(Integer id, InputDto inputDto){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Result("Input not found", false);
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent())
            return new Result("Supplier not found", false);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (optionalWarehouse.isPresent())
            return new Result("Warehouse not found", false);

        Input input = optionalInput.get();
        input.setDate(inputDto.getDate());
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        input.setCode(s);
        input.setFactureNumber("2323");
        inputRepository.save(input);
        return new Result("Updated input", true);
    }

    public Result delete(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()){
            inputRepository.deleteById(id);
            return new Result("Deleted input", true);
        }
        return new Result("Input not found", false);
    }
}
