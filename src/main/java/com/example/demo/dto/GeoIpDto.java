package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class GeoIpDto {
    private String countryName;
    private String continentName;

    @Builder
    public GeoIpDto(String countryName, String continentName) {
        this.countryName = countryName;
        this.continentName = continentName;
    }
}
