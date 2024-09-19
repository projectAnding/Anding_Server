package com.server.pin.domain.user.student.service.impl;

import com.server.pin.domain.user.student.domain.entity.StudentEntity;
import com.server.pin.domain.user.student.repository.StudentRepository;
import com.server.pin.domain.user.student.responsedto.StudentInfo;
import com.server.pin.domain.user.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StudentInfo getStudentInfo(String userId) {

        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(userId);

        return StudentInfo.builder()
                .userId(studentEntityOptional.get().getUserId())
                .username(studentEntityOptional.get().getUsername())
                .detailDepartment(studentEntityOptional.get().getDetailDepartment())
                .email(studentEntityOptional.get().getEmail())
                .phoneNumber(studentEntityOptional.get().getPhoneNumber())
                .build();
    }

    @Override
    public boolean existsByUserId(String userId) {
        return studentRepository.existsByUserId(userId);
    }
}
