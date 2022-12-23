package org.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 반환하는 컨트롤러, @ResponseBody를 각 메소드에 선언했던것을 해당 어노테이션 1줄 선언으로 변경
public class HelloController {

    @GetMapping("/hello") // /hello로 요청 오면, 문자열 hello 반환
    public String hello(){
        return "hello";
    }
}
