package org.example.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {
    
    @Test
    public void 롬복_기능_테스트() throws Exception {
        // given
        String name = "test";
        int amount = 1000;
        
        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        
        // then
        // assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드
        // isEqualTo : assertThat의 값고가, isEqualTo의 값 비교해서 같을 때만 테스트 성공
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}