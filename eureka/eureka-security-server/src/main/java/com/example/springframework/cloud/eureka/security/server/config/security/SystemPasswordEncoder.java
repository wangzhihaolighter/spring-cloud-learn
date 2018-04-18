package com.example.springframework.cloud.eureka.security.server.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class SystemPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
