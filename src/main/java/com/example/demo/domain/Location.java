package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "geoip2_location")
@Getter @Setter
@NoArgsConstructor
public class Location {

    @Id
    @Column(name = "geoname_id")
    private String geonameId;
    @Column(name = "locale_code")
    private String localeCode;
    @Column(name = "continent_code")
    private String continentCode;
    @Column(name = "continent_name")
    private String continentName;
    @Column(name = "country_iso_code")
    private String countryIsoCode;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "is_in_european_union")
    private boolean isInEuropeanUnion;

}
