package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result add(Supplier supplier){
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("Such a phone number already exists", false);
        Supplier addSupplier = new Supplier();
        addSupplier.setName(supplier.getName());
        addSupplier.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(addSupplier);
        return new Result("Saved supplier", true);
    }

    public List<Supplier> getAll(){
        List<Supplier> allSupplier = supplierRepository.findAll();
        return allSupplier;
    }

    public Result update(Integer id, Supplier supplier){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if(!optionalSupplier.isPresent())
            return new Result("Supplier not found", false);
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("Such a phone number already exists", false);

        Supplier upSupplier = optionalSupplier.get();
        upSupplier.setName(supplier.getName());
        upSupplier.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(upSupplier);
        return new Result("Updated supplier", true);
    }

    public Result delete(Integer id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()){
            supplierRepository.deleteById(id);
            return new Result("Deleted supplier", true);
        }
        return new Result("Supplier not found", false);
    }
}
