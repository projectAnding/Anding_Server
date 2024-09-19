package com.server.pin.domain.auth.service.impl;

import com.server.pin.domain.auth.exception.impl.UserAlreadyExistsException;
import com.server.pin.domain.auth.requestdto.StudentSignUpRequest;
import com.server.pin.domain.auth.requestdto.TeacherSignUpRequest;
import com.server.pin.domain.auth.service.AuthService;
import com.server.pin.domain.user.student.domain.entity.StudentEntity;
import com.server.pin.domain.user.student.repository.StudentRepository;
import com.server.pin.domain.user.teacher.domain.entity.TeacherEntity;
import com.server.pin.domain.user.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder encoder;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void teacherSignup(TeacherSignUpRequest request){

        if (teacherRepository.existsByUserId(request.userId())) {
            throw UserAlreadyExistsException.INSTANCE;
        }

        TeacherEntity teacher = TeacherEntity.builder()
                .userId(request.userId())
                .username(request.userName())
                .password(encoder.encode(request.password()))
                .detailDepartment(request.detailDepartment())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .build();

        teacherRepository.save(teacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void studentSignup(StudentSignUpRequest request) {

        if (studentRepository.existsByUserId(request.userId())) {
            throw UserAlreadyExistsException.INSTANCE;
        }

        StudentEntity student = StudentEntity.builder()
                .userId(request.userId())
                .username(request.userName())
                .password(encoder.encode(request.password()))
                .detailDepartment(request.detailDepartment())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .build();

        studentRepository.save(student);
    }
}
