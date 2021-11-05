package com.github.gracibrea.citiesapi.distances.service;

//Pegar as requisições do controller, executar as operações do banco de dados e devolver para o controller (classe
// intermediária com as regras de negócio

import com.github.gracibrea.citiesapi.cities.City;
import com.github.gracibrea.citiesapi.cities.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    //    /**
//     * 1st option
//     *
//     * @param city1
//     * @param city2
//     * @param unit
//     * @return
//     */
//    public Double distanceUsingMath(final Long city1, final Long city2, final EarthRadius unit) {
//        log.info("distanceUsingMath({}, {}, {})", city1, city2, unit);
//        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));
//
//        final Double[] location1 = StringLocationUtils.transform(cities.get(0).getGeolocation());
//        final Double[] location2 = StringLocationUtils.transform(cities.get(1).getGeolocation());
//
//        return doCalculation(location1[0], location1[1], location2[0], location2[1], unit);
//    }
//
//    /**
//     * 2nd option
//     *
//     * @param city1
//     * @param city2
//     * @return
//     */
    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        return cityRepository.distanceByPoints(city1, city2);
    }

    //    /**
//     * 3rd option
//     *
//     * @param city1
//     * @param city2
//     * @param unit
//     * @return
//     */
//    public Double distanceUsingPoints(final Long city1, final Long city2, final EarthRadius unit) {
//        log.info("distanceUsingPoints({}, {}, {})", city1, city2, unit);
//        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));
//
//        Point p1 = cities.get(0).getLocation();
//        Point p2 = cities.get(1).getLocation();
//
//        return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unit);
//    }
    public Double distanceByCubeInMeters(Long city1, Long city2) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
