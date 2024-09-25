package com.server.pin.global.security.jwt;

import org.springframework.stereotype.Component;

interface JwtHelper {
    String createJwt(String type);
    boolean validateJwt(String jwt);
    // TODO: parse
}
