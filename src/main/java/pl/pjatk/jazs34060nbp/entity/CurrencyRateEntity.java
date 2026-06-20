package pl.pjatk.jazs34060nbp.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Schema(name = "CurrencyRateEntity", description = "Entity for currency rate")
public class CurrencyRateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the currency rate")
    private Long id;
    @Schema(description = "Currency code")
    private String waluta;
    @Schema(description = "Currency rate")
    private double kursWaluty;
    @Schema(description = "Start date of the currency rate")
    private LocalDate starDate;
    @Schema(description = "End date of the currency rate")
    private LocalDate endDate;
    @Schema(description = "Date and time when the currency rate was fetched")
    private LocalDateTime dateAndTime;
    public CurrencyRateEntity() {}

    public CurrencyRateEntity(String waluta, LocalDate starDate, LocalDate endDate, double kursWaluty) {
        this.waluta = waluta;
        this.starDate = starDate;
        this.endDate = endDate;
        this.kursWaluty = kursWaluty;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }
    public double getKursWaluty() {
        return kursWaluty;
    }

    public void setKursWaluty(double kursWaluty) {
        this.kursWaluty = kursWaluty;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
