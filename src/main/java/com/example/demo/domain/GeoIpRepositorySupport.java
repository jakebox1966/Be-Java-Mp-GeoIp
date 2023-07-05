package com.example.demo.domain;

import com.example.demo.dto.GeoIpDto;

import java.util.Optional;

public interface GeoIpRepositorySupport {

    Optional<GeoIpDto> findByIpAddress(Long integerIp);
}
