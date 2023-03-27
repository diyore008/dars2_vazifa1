package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;
    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement){
        Result result = measurementService.addMeasurementService(measurement);
        return result;
    }

    @GetMapping("/getAll")
    public List<Measurement> getAll(){
        List<Measurement> measurementList = measurementService.getAll();
        return measurementList;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Measurement measurement){
        Result result = measurementService.update(id, measurement);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = measurementService.delete(id);
        return result;
    }

}
