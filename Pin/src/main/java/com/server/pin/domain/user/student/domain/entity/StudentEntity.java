package com.server.pin.domain.user.student.domain.entity;

import com.server.pin.domain.user.domain.enums.UserRole;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true, nullable = false)
    String userId;

    String username;
    String password;

    Integer detailDepartment; // 학번

    String email;
    String phoneNumber;

}
