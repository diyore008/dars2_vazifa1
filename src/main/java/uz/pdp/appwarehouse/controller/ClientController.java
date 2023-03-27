package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    ClientService clientService;

    @PostMapping("/add")
    public Result add(@RequestBody Client client){
        Result result = clientService.add(client);
        return result;
    }

    @GetMapping("/getAll")
    public List<Client> getAll(){
        List<Client> allClient = clientService.getAll();
        return allClient;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Client client){
        Result result = clientService.update(id, client);
        return result;
    }

    @DeleteMapping("/deleted/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = clientService.deleted(id);
        return result;
    }
}
