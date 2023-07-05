# Geoip

### 목표 
##### IP 주소를 입력받아 해당 IP 가 어느 국가에서 접속했는지 알 수 있는 애플리케이션 구현.
------------

### 기술 스펙
- ##### Java 17.0.4
- ##### Spring Boot 3.1.0
- ##### MariaDB
- ##### Spring Data JPA
- ##### Query DSL

------------

### 빌드 준비사항
- #### Optional 항목이었던 'IaC툴 사용하여 배포' 는 진행하지 못 하였기 때문에 로컬 환경에서 실행시켜야 합니다.
- #### DB는 MariaDB 또는 MySql을 사용해 주시기 바랍니다. (schema.sql 문법 오류 발생 가능성)
- #### application.yml 의 datasource는 사용하시는 계정과 비밀번호로 변경해 주시기 바랍니다.

------------

### 프로젝트 설명
- #### 로직 구현을 위해 maxmind에서 제공하는 CSV 파일을 사용하여 DB 구축
- #### CDIR 포맷으로 제공되는 CSV 파일을 maxmind 에서 제공해주는 변환프로그램을 사용하여 Integer Range (network_start컬럼, network_end컬럼) 추가
- #### 프로젝트 빌드 시, 해당 스키마생성과 CSV 파일 DB 로드를 위해 resources 폴더에 schema.sql 파일 작성
- #### 프로젝트 빌드 완료 후, "localhost:8080" 접속시 index 화면에서 IP주소 입력

------------

### 프로젝트 Optional 누락항목
- #### IaC 툴 배포
- #### GraphQL로 동일한 기능 구현
- #### maxmind 에서 제공하는 IP 변동사항 업데이트 자동화 (batch 및 크론탭 사용 가능)
