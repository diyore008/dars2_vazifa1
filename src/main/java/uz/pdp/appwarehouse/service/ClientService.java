package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result add(Client client){
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("Such a phone number already exists", false);
        Client addClient = new Client();
        addClient.setName(client.getName());
        addClient.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(addClient);
        return new Result("Saved client", true);
    }

    public List<Client> getAll(){
        List<Client> allClient = clientRepository.findAll();
        return allClient;
    }

    public Result update(Integer id, Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Result("Client not found",false );
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("Such a phone number already exists", false);
        Client upClient = optionalClient.get();
        upClient.setName(client.getName());
        upClient.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(upClient);
        return new Result("Updated client", true);
    }

    public Result deleted(Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            clientRepository.deleteById(id);
            return new Result("Deleted client", true);
        }
        return new Result("Client not found", false);
    }
}
