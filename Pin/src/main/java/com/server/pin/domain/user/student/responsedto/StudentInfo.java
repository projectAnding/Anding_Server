package com.server.pin.domain.user.student.responsedto;

import lombok.Builder;

@Builder
public record StudentInfo(

        String userId,
        String username,

        Integer detailDepartment, // 학번

        String email,
        String phoneNumber
) {
}
