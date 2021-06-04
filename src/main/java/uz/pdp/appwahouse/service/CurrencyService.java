package uz.pdp.appwahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwahouse.entity.Currency;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.CurrencyRepository;

import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
    public ApiResponse addCurrency(Currency currency){
        boolean b = currencyRepository.existsByName(currency.getName());
        if (!b){
            return new ApiResponse("This name already exist",false);
        }
        currencyRepository.save(currency);
        return new ApiResponse("Added successfully",true);
    }
    public ApiResponse editCurrency(Integer id,Currency currency){
        Optional<Currency> byId = currencyRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("This id not found",false);
        Currency currency1 = byId.get();
        currency1.setName(currency.getName());
        currencyRepository.save(currency1);
        return new ApiResponse("Edited successfully",true);
    }
}
