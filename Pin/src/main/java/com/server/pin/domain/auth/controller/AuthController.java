package com.server.pin.domain.auth.controller;

import com.server.pin.domain.auth.requestdto.StudentSignUpRequest;
import com.server.pin.domain.auth.requestdto.TeacherSignUpRequest;
import com.server.pin.domain.auth.service.AuthService;
import com.server.pin.global.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "Auth", description = "인증 API")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // TODO: 신청 허가 페이지로 보내기
    @Operation(summary = "교사 회원가입")
    @PostMapping("/signup/teacher")
    public ResponseEntity<Response> teacherSingUp(@RequestBody TeacherSignUpRequest request) {
        authService.teacherSignup(request);

        return Response.ok("Created");
    }

    @Operation(summary = "학생 회원가입")
    @PostMapping("/signup/student")
    public ResponseEntity<Response> studentSingUp(@RequestBody StudentSignUpRequest request) {
        authService.studentSignup(request);

        return Response.ok("Created");
    }

    // TODO: 로그인 기능

    // TODO: 리이슈 기능
}
