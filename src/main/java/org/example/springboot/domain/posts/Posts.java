package org.example.springboot.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 롬복
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 롬복
@Entity // JPA - 테이블과 매핑될 클래스(기본 이름 규칙: 자바-카멜(StudentTable) -> DB-언더스코어(student_table))
public class Posts { // 실제 DB의 테이블과 매칭

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성 규칙, 스프링부트 2.0에서는 GenerationType.IDENTITY추가해야 auto_increment
    private Long id;

    // @Column 선언하지 않아도 해당 클래스의 필드는 모두 테이블의 컬럼이 됨.
    // @Column 선언 이유: 기본 값외에 추가로 변경이 필요한 옵션이 있는 경우
    @Column(length = 500, nullable = false) // String의 경우 varchar(255)가 기본인데, 사이즈 500으로 늘리기 위해서
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 타입 TEXT로 변경
    private String content;

    private String author;

    @Builder // 생성자 위에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}