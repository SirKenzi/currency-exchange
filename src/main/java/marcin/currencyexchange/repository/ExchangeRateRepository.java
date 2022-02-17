package marcin.currencyexchange.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import marcin.currencyexchange.model.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long>{
    
    @Cacheable("exchangeRates")
    Optional<ExchangeRate> findByDateAndCountryCode(LocalDate date, String countryCode);

}
