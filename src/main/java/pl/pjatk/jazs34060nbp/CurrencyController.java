package pl.pjatk.jazs34060nbp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CurrencyController {
    private final CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    @GetMapping("/{currency}/{startDate}/{endDate}")
    public ResponseEntity<Double> getCurrencyForDates(@PathVariable String currency,
                                                    @PathVariable LocalDate startDate,
                                                    @PathVariable LocalDate endDate) {
        return ResponseEntity.ok(currencyService.getAvgForDateRange(currency, startDate, endDate));
    }
}
