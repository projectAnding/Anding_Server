package com.server.pin.domain.auth.exception;

import com.server.pin.global.exception.ExceptionDetail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthExceptionDetails implements ExceptionDetail {
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "user already exists"),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "user not found")
    ;

    private final HttpStatus status;
    private final String detail;

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return name();
    }

    @Override
    public String getDetail() {
        return detail;
    }
}
