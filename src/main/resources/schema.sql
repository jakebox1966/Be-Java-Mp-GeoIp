-- Location 테이블 생성 및 데이터 추가 시작 --

DROP TABLE IF EXISTS `geoip2_location`;

CREATE TABLE `geoip2_location` (
                                   `geoname_id` int(11) NOT NULL,
                                   `locale_code` text NOT NULL,
                                   `continent_code` text NOT NULL,
                                   `continent_name` text NOT NULL,
                                   `country_iso_code` text DEFAULT NULL,
                                   `country_name` text DEFAULT NULL,
                                   `is_in_european_union` tinyint(1) DEFAULT NULL,
                                   PRIMARY KEY (`geoname_id`)
);

load data LOCAL infile 'classpath:converter/GeoLite2-Country-Locations-en.csv'
into table geoip2_location
fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 rows (
  geoname_id, locale_code, continent_code, continent_name,
  @country_iso_code, @country_name,
  is_in_european_union
)
set country_iso_code = nullif(@country_iso_code, ''),
    country_name = nullif(@country_name, '');

-- Location 테이블 생성 및 데이터 추가 끝 --

-- network 대역 테이블 생성 및 데이터 추가 시작 --
DROP TABLE IF EXISTS `geoip2_network`;

CREATE TABLE `geoip2_network` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                  `network_start` bigint(20) DEFAULT NULL,
                                  `network_end` bigint(20) DEFAULT NULL,
                                  `geoname_id` int(11) DEFAULT NULL,
                                  `registered_country_geoname_id` int(11) DEFAULT NULL,
                                  `represented_country_geoname_id` int(11) DEFAULT NULL,
                                  `is_anonymous_proxy` tinyint(1) DEFAULT NULL,
                                  `is_satellite_provider` tinyint(1) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `id_UNIQUE` (`id`)
);

SET @COUNT = 0;

load data LOCAL infile 'classpath:converter/GeoLite2-Country-Blocks-IPv4-IntegerRange.csv'
into table geoip2_network
fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 rows
(@network_start, @network_end, @geoname_id, @registered_country_geoname_id, @represented_country_geoname_id,
 @is_anonymous_proxy, @is_satellite_provider)
set
    network_start = (@network_start),
    network_end = (@network_end),
    geoname_id = nullif(@geoname_id, ''),
    registered_country_geoname_id = nullif(@registered_country_geoname_id, ''),
    represented_country_geoname_id = nullif(@represented_country_geoname_id, ''),
    is_anonymous_proxy = nullif(@is_anonymous_proxy, ''),
    is_satellite_provider = nullif(@is_satellite_provider, '');

-- network 대역 테이블 생성 및 데이터 추가 끝 --