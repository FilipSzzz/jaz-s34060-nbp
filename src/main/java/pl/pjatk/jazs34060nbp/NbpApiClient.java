package pl.pjatk.jazs34060nbp;

import pl.pjatk.jazs34060nbp.Root;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;

@Component
public class NbpApiClient {

    private final RestTemplate restTemplate;

    public NbpApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root callNbpApi(String currency, LocalDate startDate, LocalDate endDate) {
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/"
                        + currency
                        + "/"
                        + startDate
                        + "/"
                        + endDate,
                Root.class);
    }
}