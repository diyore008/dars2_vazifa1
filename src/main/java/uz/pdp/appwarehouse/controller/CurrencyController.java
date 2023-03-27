package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;
    @PutMapping("/add")
    public Result add(@RequestBody Currency currency){
        Result result = currencyService.add(currency);
        return result;
    }

    @GetMapping("/getAll")
    public List<Currency> getAll(){
        List<Currency> allCurrency = currencyService.getAll();
        return allCurrency;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Currency currency){
        Result result = currencyService.update(id, currency);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result deleted(@PathVariable Integer id){
        Result result = currencyService.delete(id);
        return result;
    }
}
