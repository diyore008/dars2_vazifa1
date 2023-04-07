package uz.pdp.dars1_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dars1_vazifa2.entity.Output;
import uz.pdp.dars1_vazifa2.payload.OutputDto;
import uz.pdp.dars1_vazifa2.payload.Result;
import uz.pdp.dars1_vazifa2.service.OutputService;

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
