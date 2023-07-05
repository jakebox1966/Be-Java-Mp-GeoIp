package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoIpRepository extends JpaRepository<GeoIp, Long>, GeoIpRepositorySupport {

}
