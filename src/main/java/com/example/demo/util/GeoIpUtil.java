package com.example.demo.util;

import com.example.demo.domain.GeoIpRepository;
import com.example.demo.dto.GeoIpDto;
import com.example.demo.dto.GeoIpResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class GeoIpUtil {

    private final GeoIpRepository geoIpRepository;

    /**
     * Ip 주소를 정수 형태로 변환 수식 입니다.
     * (first octet * 256³) + (second octet * 256²) + (third octet * 256) + (fourth octet)
     * =	(first octet * 16777216) + (second octet * 65536) + (third octet * 256) + (fourth octet)
     * =	(221 * 16777216) + (150 * 65536) + (92 * 256) + (56)
     * =	3717618744
     *
     * @param ipAddress
     * @return
     */
    public GeoIpResponseDto convertIpToInt(String ipAddress) {
        log.info("===================================================================");
        log.info("Now Start Converting IpAddress to Integer");
        log.info("===================================================================");

        String[] ipArray = StringUtils.split(ipAddress, ".");
        Long firstOctet = calculate(ipArray[0], 256, 3);
        Long secondOctet = calculate(ipArray[1], 256, 2);
        Long thirdOctet = calculate(ipArray[2], 256, 1);
        Long fourthOctet = Long.parseLong(ipArray[3]);
        log.info(String.valueOf(fourthOctet));

        log.info("===================================================================");
        log.info("Converting IpAddress is Done => {}", firstOctet + secondOctet + thirdOctet + fourthOctet);
        log.info("===================================================================");

         GeoIpResponseDto geoIpResponseDto = GeoIpResponseDto.builder()
                .originalFirstOctet(Integer.parseInt(ipArray[0]))
                .originalSecondOctet(Integer.parseInt(ipArray[1]))
                .originalThirdOctet(Integer.parseInt(ipArray[2]))
                .originalFourthOctet(Integer.parseInt(ipArray[3]))
                .integerFirstOctet(firstOctet)
                .integerSecondOctet(secondOctet)
                .integerThirdOctet(thirdOctet)
                .integerFourthOctet(fourthOctet)
                .totalIntegerIp(firstOctet + secondOctet + thirdOctet + fourthOctet).build();

        return geoIpResponseDto;

    }

    public Long calculate(String octet, int digit, int digitForDigit) {
        log.info("===================================================================");
        log.info(octet + " * " + digit + " ^ " + digitForDigit + " = " + Long.parseLong(octet) * (long)Math.pow(digit, digitForDigit));
        log.info("===================================================================");

       return Long.parseLong(octet) * (long)Math.pow(digit, digitForDigit);
    }

    public Optional<GeoIpDto> findCountryByIpAddress(Long integerIpAddress) {
        return geoIpRepository.findByIpAddress(integerIpAddress);
    }
}
