package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "geoip2_network")
@Getter
@NoArgsConstructor
public class GeoIp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "network_start")
    private Long networkStart;
    @Column(name = "network_end")
    private Long networkEnd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geoname_id")
    private Location location;
    @Column(name = "registered_country_geoname_id")
    private Long registeredCountryGeoNameId;
    @Column(name = "represented_country_geoname_id")
    private Long representedCountryGeoNameId;
    @Column(name = "is_anonymous_proxy")
    private String isAnonymousProxy;
    @Column(name = "is_satellite_provider")
    private String isSatelliteProvider;

    @Builder
    public GeoIp(Long id, Long networkStart, Long networkEnd, Location location, Long registeredCountryGeoNameId, Long representedCountryGeoNameId, String isAnonymousProxy, String isSatelliteProvider) {
        this.id = id;
        this.networkStart = networkStart;
        this.networkEnd = networkEnd;
        this.location = location;
        this.registeredCountryGeoNameId = registeredCountryGeoNameId;
        this.representedCountryGeoNameId = representedCountryGeoNameId;
        this.isAnonymousProxy = isAnonymousProxy;
        this.isSatelliteProvider = isSatelliteProvider;
    }
}
