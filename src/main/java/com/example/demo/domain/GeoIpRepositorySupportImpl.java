package com.example.demo.domain;

import com.example.demo.dto.GeoIpDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.example.demo.domain.QGeoIp.geoIp;
import static com.example.demo.domain.QLocation.location;

@Slf4j
@RequiredArgsConstructor

public class GeoIpRepositorySupportImpl implements GeoIpRepositorySupport {

    private final JPAQueryFactory query;

    @Override
    public Optional<GeoIpDto> findByIpAddress(Long integerIp) {
        log.info("===================================================================");
        log.info("Now Starting Looking Up the IpAddress in the Database => {}", integerIp);
        log.info("===================================================================");

        GeoIp result = query.select(
                        geoIp
                ).from(geoIp)
                .where(
                        geoIp.networkStart.loe(integerIp).and(geoIp.networkEnd.goe(integerIp))
                )
                .leftJoin(geoIp.location, location)
                .fetchJoin()
                .fetchOne();

        log.info("===================================================================");
        log.info("Looking Up is Done with Country Name => {}", result.getLocation().getCountryName());
        log.info("===================================================================");

        GeoIpDto geoIpDto = GeoIpDto.builder()
                .countryName(result.getLocation().getCountryName())
                .continentName(result.getLocation().getContinentName())
                .build();

        return Optional.ofNullable(geoIpDto);
    }
}
