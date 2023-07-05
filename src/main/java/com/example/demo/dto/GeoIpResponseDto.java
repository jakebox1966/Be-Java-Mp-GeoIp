package com.example.demo.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class GeoIpResponseDto {

    private String countryName;
    private String continentName;
    private int originalFirstOctet;
    private int originalSecondOctet;
    private int originalThirdOctet;
    private int originalFourthOctet;
    private long integerFirstOctet;
    private long integerSecondOctet;
    private long integerThirdOctet;
    private long integerFourthOctet;
    private long totalIntegerIp;

    @Builder
    public GeoIpResponseDto(String countryName, String continentName, int originalFirstOctet, int originalSecondOctet, int originalThirdOctet, int originalFourthOctet, long integerFirstOctet, long integerSecondOctet, long integerThirdOctet, long integerFourthOctet, long totalIntegerIp) {
        this.countryName = countryName;
        this.continentName = continentName;
        this.originalFirstOctet = originalFirstOctet;
        this.originalSecondOctet = originalSecondOctet;
        this.originalThirdOctet = originalThirdOctet;
        this.originalFourthOctet = originalFourthOctet;
        this.integerFirstOctet = integerFirstOctet;
        this.integerSecondOctet = integerSecondOctet;
        this.integerThirdOctet = integerThirdOctet;
        this.integerFourthOctet = integerFourthOctet;
        this.totalIntegerIp = totalIntegerIp;
    }
}
