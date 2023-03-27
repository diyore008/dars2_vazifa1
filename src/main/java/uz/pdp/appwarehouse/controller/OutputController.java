package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.payload.OutputDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping("/add")
    public Result add(@RequestBody OutputDto outputDto){
        Result result = outputService.add(outputDto);
        return result;
    }

    @GetMapping("/getAll")
    public List<Output> getAll(){
        List<Output> allOutputs = outputService.getAll();
        return allOutputs;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id,@RequestBody OutputDto outputDto){
        Result result = outputService.update(id, outputDto);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = outputService.delete(id);
        return result;
    }
}
