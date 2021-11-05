package com.github.gracibrea.citiesapi.countries.repository;

        import com.github.gracibrea.citiesapi.countries.Country;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}