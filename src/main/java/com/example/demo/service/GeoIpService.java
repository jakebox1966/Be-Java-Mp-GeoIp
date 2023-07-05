package com.example.demo.service;

import com.example.demo.dto.GeoIpDto;
import com.example.demo.dto.GeoIpRequestDto;
import com.example.demo.dto.GeoIpResponseDto;
import com.example.demo.util.GeoIpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeoIpService {

    private final GeoIpUtil geoIpUtil;

    /**
     * step 1. 넘겨받은 IpAddress를 Integer로 변환하기 위해 geoIpUtil의 convertIpToInt method를 호출합니다.
     * step 2. Integer로 변환된 IpAddress 대역의 Location 정보(예: 국가, 국가 코드, etc...)를 데이터베이스에서 조회합니다.
     *
     * @param geoIpRequestDto
     * @return geoIpResponseDto
     */
    public GeoIpResponseDto getIpAddressInfo(GeoIpRequestDto geoIpRequestDto) {
        log.info("===================================================================");
        log.info("Now Start finding country name with IP Address => {} ", geoIpRequestDto.getIpAddress());
        log.info("===================================================================");

        GeoIpResponseDto geoIpResponseDto = geoIpUtil.convertIpToInt(geoIpRequestDto.getIpAddress());

        Optional<GeoIpDto> geoIpDto = geoIpUtil.findCountryByIpAddress(geoIpResponseDto.getTotalIntegerIp());

        geoIpResponseDto.setCountryName(geoIpDto.get().getCountryName());
        geoIpResponseDto.setContinentName(geoIpDto.get().getContinentName());

        return geoIpResponseDto;
    }
}
