package uz.pdp.appwarehouse.service;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CurrencyRepository;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result add(Currency currency){
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName)
            return new Result("Such a currency already exists", false);

        Currency addCurrency = new Currency();
        addCurrency.setName(currency.getName());
        currencyRepository.save(addCurrency);
        return new Result("Saved currency", true);
    }

    public List<Currency> getAll(){
        List<Currency> allCurrency = currencyRepository.findAll();
        return allCurrency;
    }

    public Result update(Integer id, Currency currency){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Result("Currency not found", false);
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName)
            return new Result("Such a currency already exists", false);

        Currency upCurrency = optionalCurrency.get();
        upCurrency.setName(currency.getName());
        currencyRepository.save(upCurrency);
        return new Result("Updated currency", true);
    }

    public Result delete(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            currencyRepository.deleteById(id);
            return new Result("Deleted not found", true);
        }
        return new Result("Currency not found", false);
    }

}
