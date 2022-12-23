package org.example.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = HelloController.class)// 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중 할 수 있는 어노테이션(단, @Service, @Componet, @Repository 사용X)
public class HelloControllerTest {
    // @Autowired: 스프링이 관리하는 빈 주입 받기
    @Autowired private MockMvc mvc; // HTTP GET, POST등에 대한 API 테스트가능
    
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 사용해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // HTTP Header Status 검증
                .andExpect(content().string(hello)); // 응답 본문 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        // given
        String name = "hello";
        int amount = 1000;

        // when, then
        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))// param 등록, String만 가능 (숫자, 날짜 등의 데이터 문자열로 변경 필요)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))// jsonPath : JSON 응답값 필드별로 검증, $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
