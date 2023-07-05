package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Response {

    private LocalDateTime timestamp = LocalDateTime.now();

    private String message; //예외 메시지 저장

    private String code; // 세분화하기 위한 사용자 지정 코드,

    private int status; // HTTP 상태 값 저장 400, 404, 500 등..

}
