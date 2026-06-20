package pl.pjatk.jazs34060nbp.service;

import org.springframework.stereotype.Service;
import pl.pjatk.jazs34060nbp.entity.CurrencyRateEntity;
import pl.pjatk.jazs34060nbp.NbpApiClient;
import pl.pjatk.jazs34060nbp.Rate;
import pl.pjatk.jazs34060nbp.Root;
import pl.pjatk.jazs34060nbp.repository.CurrencyRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurrencyService {
    private final NbpApiClient nbpApiClient;
    private final CurrencyRepository currencyRepository;
    public CurrencyService(NbpApiClient nbpApiClient, CurrencyRepository currencyRepository ) {
        this.nbpApiClient = nbpApiClient;
        this.currencyRepository = currencyRepository;
    }
    public Root getCurrency(String currency, LocalDate startDate, LocalDate endDate) {
        return nbpApiClient.callNbpApi(currency, startDate, endDate);
    }
    public double getAvgForDateRange(String currency, LocalDate startDate, LocalDate endDate) {
        Root root = nbpApiClient.callNbpApi(currency, startDate, endDate);
        List<Rate> rates = root.getRates();
        double tempVariable = 0;

        for (Rate rate : rates) {
            tempVariable += rate.getMid();
        }
        CurrencyRateEntity currencyRateEntity = new CurrencyRateEntity();
        currencyRateEntity.setKursWaluty(tempVariable / rates.size());
        currencyRateEntity.setStarDate(startDate);
        currencyRateEntity.setEndDate(endDate);
        currencyRateEntity.setWaluta(currency);
        currencyRateEntity.setDateAndTime(LocalDateTime.now());

        currencyRepository.save(currencyRateEntity);

        return tempVariable / rates.size();
    }
}
