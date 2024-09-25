package com.server.pin.domain.auth.service;

import com.server.pin.domain.auth.dto.CheckTeacherApply;
import com.server.pin.domain.auth.requestdto.UserSignUpRequest;
import com.server.pin.domain.user.responsedto.UserInfo;
import com.server.pin.global.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AuthService {
    void teacherSignup(UserSignUpRequest request);
    void studentSignup(UserSignUpRequest request);
    List<CheckTeacherApply> getTeacherApplies();
    void teacherSignUpOk(Long id);
    void teacherSignUpDeny(Long id);
}
