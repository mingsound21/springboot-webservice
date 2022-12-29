package org.example.springboot.config.auth.dto;

import lombok.Getter;
import org.example.springboot.domain.user.User;

import java.io.Serializable;

/**
 * 인증된 사용자 정보만 필요
 * 
 * User 엔티티 말고 별도의 SessionUser라는 세션에 저장하기 위한 DTO를 만든 이유
 * 1. User 클래스를 세션에 저장하려고하면 User 클래스에 직렬화 구현하지 않았다는 오류 메세지 뜸
 *  => 그렇다고, 다른 엔티티와 관계 형성하는 User 클래스에 직렬화를 구현하는 것은 관계 맺은 엔티티에 까지 직렬화 대상에 포함되어 성능이슈 발생할 수 있음
 *  => 그래서 세션에 저장하기 위해서 직렬화 기능을 가진 세션 DTO를 별도로 생성
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}