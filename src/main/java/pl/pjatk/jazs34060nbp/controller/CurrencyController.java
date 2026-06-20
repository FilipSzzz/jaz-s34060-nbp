package pl.pjatk.jazs34060nbp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jazs34060nbp.service.CurrencyService;

import java.time.LocalDate;

@RestController
@Tag(name = "Currency Controller", description = "Controller for currency rate operations")
public class CurrencyController {
    private final CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    @Operation(summary = "Get average currency rate for a given date range")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Średni kurs waluty dla podanego zakresu dat"),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono danych w NBP"),
            @ApiResponse(responseCode = "400", description = "Nieprawidłowe parametry zapytania"),
            @ApiResponse(responseCode = "500", description = "Błąd serwera podczas przetwarzania zapytania")
    })
    @GetMapping("/{currency}/{startDate}/{endDate}")
    public ResponseEntity<Double> getCurrencyForDates(@Parameter(description = "Trzyliterowy kod waluty wg standardu ISO 4217", example = "USD") @PathVariable String currency,
                                                    @Parameter(description = "Data początkowa zakresu w formacie RRRR-MM-DD", example = "2026-04-02")@PathVariable LocalDate startDate,
                                                    @Parameter(description = "Data końcowa zakresu w formacie RRRR-MM-DD", example = "2026-04-20")@PathVariable LocalDate endDate) {
        return ResponseEntity.ok(currencyService.getAvgForDateRange(currency, startDate, endDate));
    }
}
