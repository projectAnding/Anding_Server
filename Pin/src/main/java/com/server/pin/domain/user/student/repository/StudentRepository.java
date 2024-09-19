package com.server.pin.domain.user.student.repository;

import com.server.pin.domain.user.student.domain.entity.StudentEntity;
import com.server.pin.domain.user.student.responsedto.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    boolean existsByUserId(String userId);
}
