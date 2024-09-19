package com.server.pin.domain.user.teacher.repository;


import com.server.pin.domain.user.teacher.domain.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {
    boolean existsByUserId(String userId);
}
