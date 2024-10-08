package com.server.pin.domain.auth.controller;

import com.server.pin.domain.auth.requestdto.UserSignUpRequest;
import com.server.pin.domain.auth.service.AuthService;
import com.server.pin.domain.user.responsedto.UserInfo;
import com.server.pin.global.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // TODO: 신청 허가 페이지로 보내기
    @Tag(name = "교사 Auth", description = "교사인증 API")
    @Operation(summary = "교사 회원가입")
    @PostMapping("/signup/teacher")
    public ResponseEntity<Response> teacherSingUp(@RequestBody UserSignUpRequest request) {
        authService.teacherSignup(request);

        return Response.ok("Created");
    }

    @Tag(name = "학생 Auth", description = "학생인증 API")
    @Operation(summary = "학생 회원가입")
    @PostMapping("/signup/student")
    public ResponseEntity<Response> studentSingUp(@RequestBody UserSignUpRequest request) {
        authService.studentSignup(request);

        return Response.ok("Created");
    }

    // TODO: 로그인 기능

    // TODO: 리이슈 기능
}
