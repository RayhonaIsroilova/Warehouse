package uz.pdp.appwahouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwahouse.entity.Currency;
import uz.pdp.appwahouse.payload.ApiResponse;
import uz.pdp.appwahouse.repository.CurrencyRepository;
import uz.pdp.appwahouse.service.CurrencyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    CurrencyService currencyService;
    @GetMapping
    public List<Currency> getCurrencys(){
        return currencyRepository.findAll();
    }
    @GetMapping("/{id}")
    public Currency getCurrency(@PathVariable Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        if (!byId.isPresent()) return new Currency();
        return  byId.get();
    }
    @PostMapping("/adding")
    public ApiResponse addCurrency(@RequestBody Currency currency){
        return currencyService.addCurrency(currency);
    }
    @PutMapping("/editing/{id}")
    public ApiResponse editCurrency(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.editCurrency(id,currency);
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteCurrency(@PathVariable Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        if (!byId.isPresent()) return  new ApiResponse("This id not found",false);
        currencyRepository.delete(byId.get());
        return new ApiResponse("Deleting successfully",true);
    }
}
