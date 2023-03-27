package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.OutputDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.ClientRepository;
import uz.pdp.appwarehouse.repository.OutputRepository;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OutputService {
    String s = UUID.randomUUID().toString();
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ClientRepository clientRepository;
    public Result add(OutputDto outputDto){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found", false);
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (!optionalClient.isPresent())
            return new Result("Client not found", false);

        Output output = new Output();
        output.setDate(outputDto.getDate());
        output.setWarehouse(optionalWarehouse.get());
        output.setClient(optionalClient.get());
        output.setFactureNumber("5656");
        output.setCode(s);
        outputRepository.save(output);
        return new Result("Saved output", true);
    }

    public List<Output> getAll(){
        List<Output> allOutputs = outputRepository.findAll();
        return allOutputs;
    }

    public Result update(Integer id, OutputDto outputDto){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Result("Output not found",false);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found", false);
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (!optionalClient.isPresent())
            return new Result("Client not found", false);

        Output output = optionalOutput.get();
        output.setDate(outputDto.getDate());
        output.setWarehouse(optionalWarehouse.get());
        output.setClient(optionalClient.get());
        output.setFactureNumber("9090");
        output.setCode(s);
        outputRepository.save(output);
        return new Result("Updated output", true);
    }

    public Result delete(Integer id){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isPresent()){
            outputRepository.deleteById(id);
            return new Result("Deleted output", true);
        }
        return new Result("Output not found", false);
    }
}
