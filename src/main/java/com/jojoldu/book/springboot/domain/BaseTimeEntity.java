package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 Base TimeEntit 을 상속할 경우 필드들 created Date.
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing 기능을 포함

public class BaseTimeEntity {

    @CreatedDate //Entity 생성되어 저장될 때 시간이 자동 저장됩니다
    private LocalDateTime createdDate;

    @LastModifiedDate  // 조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다
    private  LocalDateTime modifyDate;

}
