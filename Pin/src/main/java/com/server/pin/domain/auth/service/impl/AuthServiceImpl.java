package com.server.pin.domain.auth.service.impl;

import com.server.pin.domain.auth.dto.CheckTeacherApply;
import com.server.pin.domain.auth.exception.impl.DetailDepartmentDataTypeWrongException;
import com.server.pin.domain.auth.exception.impl.IdNotFoundException;
import com.server.pin.domain.auth.exception.impl.UserAlreadyExistsException;
import com.server.pin.domain.auth.requestdto.UserSignUpRequest;
import com.server.pin.domain.auth.service.AuthService;
import com.server.pin.domain.user.domain.entity.UserEntity;
import com.server.pin.domain.user.domain.enums.UserRole;
import com.server.pin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void teacherSignup(UserSignUpRequest request){

        if (userRepository.existsByUserId(request.userId()) || userRepository.existsByEmail(request.email()) || userRepository.existsByPhoneNumber(request.phoneNumber())) {
            throw UserAlreadyExistsException.INSTANCE;
        }

        UserEntity teacher = UserEntity.builder()
                .userId(request.userId())
                .username(request.userName())
                .password(encoder.encode(request.password()))
                .detailDepartment(request.detailDepartment())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .role(UserRole.ROLE_WAITING)
                .build();

        userRepository.save(teacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void studentSignup(UserSignUpRequest request) {

        if (userRepository.existsByUserId(request.userId()) || userRepository.existsByEmail(request.email()) || userRepository.existsByPhoneNumber(request.phoneNumber())) {
            throw UserAlreadyExistsException.INSTANCE;
        } else if(!(request.detailDepartment().matches("\\d{4}"))) {
            throw DetailDepartmentDataTypeWrongException.INSTANCE;
        }

        UserEntity student = UserEntity.builder()
                .userId(request.userId())
                .username(request.userName())
                .password(encoder.encode(request.password()))
                .detailDepartment(request.detailDepartment())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .role(UserRole.ROLE_STUDENT)
                .build();



        userRepository.save(student);
    }

    @Override
    public List<CheckTeacherApply> getTeacherApplies() {
        return userRepository.findAllTeacherApplyByRole(UserRole.ROLE_WAITING);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void teacherSignUpOk(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> IdNotFoundException.INSTANCE);
        user.setRole(UserRole.ROLE_TEACHER);

//        userRepository.save(user); // optional?
        // TODO: PATCH 로직 만들어주기
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void teacherSignUpDeny(Long id) {
        if (!userRepository.existsById(id)) {
            throw IdNotFoundException.INSTANCE;
        }
        userRepository.deleteById(id);
    }
}