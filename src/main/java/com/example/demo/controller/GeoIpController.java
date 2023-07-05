package com.example.demo.controller;

import com.example.demo.dto.GeoIpRequestDto;
import com.example.demo.dto.SuccessResponse;
import com.example.demo.service.GeoIpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GeoIpController {

    private final GeoIpService geoIpService;

    /**
     * GeoIpRequestDto로 View에서 넘어온 데이터를 넘겨받고 GeoIpService에
     * IP Address 상세 정보를 얻기위한 요청을 합니다.
     *
     * @param geoIpRequestDto
     * @return IP Address Detail Information
     */
    @PostMapping("/geoip")
    public ResponseEntity<SuccessResponse> getIpAddressInfo(@RequestBody GeoIpRequestDto geoIpRequestDto) {
        log.info("===================================================================");
        log.info("IP address we have got is => {} ", geoIpRequestDto.getIpAddress());
        log.info("===================================================================");

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(geoIpService.getIpAddressInfo(geoIpRequestDto)));
    }
}
