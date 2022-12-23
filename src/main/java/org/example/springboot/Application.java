package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기, 생성 모두 자동으로 설정
// @SpringBootApplication에서 부터 설정 읽음. 항상 최상단 위치!
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행
    }
}
