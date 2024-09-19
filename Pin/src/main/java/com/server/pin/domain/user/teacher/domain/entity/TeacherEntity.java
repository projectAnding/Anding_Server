package com.server.pin.domain.user.teacher.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    Long id;

    @Column(unique = true, nullable = false)
    String userId;

    String username;
    String password;

    String detailDepartment; // 부서

    String email;
    String phoneNumber;
}
