package pl.pjatk.jazs34060nbp;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.jazs34060nbp.CurrencyRateEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyRateEntity, Long> {

}