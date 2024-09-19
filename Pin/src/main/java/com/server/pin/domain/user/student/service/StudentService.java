package com.server.pin.domain.user.student.service;

import com.server.pin.domain.user.student.responsedto.StudentInfo;

public interface StudentService {
    StudentInfo getStudentInfo(String userId);
    boolean existsByUserId(String userId);
}
