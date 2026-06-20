package pl.pjatk.jazs34060nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.jazs34060nbp.entity.CurrencyRateEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyRateEntity, Long> {

}