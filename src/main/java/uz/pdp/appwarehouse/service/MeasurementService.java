package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("This measurement already exists",false);
        measurementRepository.save(measurement);
        return new Result("Successfully added", true );
    }

    public List<Measurement> getAll(){
        List<Measurement> measurementList = measurementRepository.findAll();
        return measurementList;
    }

    public Result update(Integer id, Measurement measurement){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("Measurement not found", false);

        Measurement upMeasurement =  optionalMeasurement.get();
        upMeasurement.setName(measurement.getName());
        measurementRepository.save(upMeasurement);
        return new Result("Update measurement", true);
    }

    public Result delete(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            measurementRepository.deleteById(id);
            return new Result("Deleted measurement", true);
        }
        return new Result("Measurement not found", false);
    }
}
