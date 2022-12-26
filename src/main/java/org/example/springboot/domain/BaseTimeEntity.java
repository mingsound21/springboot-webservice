package org.example.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 엔티티가 BaseEntity 상속 시, BaseEntity의 필드들도 컬럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity에 Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate // 엔티티가 생성되어 저장될 때, 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한  엔티티의 값을 변경할 때, 시간 자동 저장
    private LocalDateTime modifiedDate;
}
