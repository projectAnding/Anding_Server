package com.server.pin.domain.user.student.controller;

import com.server.pin.domain.user.student.repository.StudentRepository;
import com.server.pin.domain.user.student.responsedto.StudentInfo;
import com.server.pin.domain.user.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Tag(name = "Student", description = "학생 API")
public class StudentController {
    private final StudentService studentService;

    @Operation(summary = "내 정보 확인하기")
    @GetMapping("/getInfo")
    public StudentInfo getStudentInfo(String userId){
        return studentService.getStudentInfo(userId);
    }
}
