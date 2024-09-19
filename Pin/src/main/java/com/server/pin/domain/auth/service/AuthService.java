package com.server.pin.domain.auth.service;

import com.server.pin.domain.auth.requestdto.StudentSignUpRequest;
import com.server.pin.domain.auth.requestdto.TeacherSignUpRequest;

public interface AuthService {
    void teacherSignup(TeacherSignUpRequest request);
    void studentSignup(StudentSignUpRequest request);
}
