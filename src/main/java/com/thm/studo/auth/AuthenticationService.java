package com.thm.studo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname()
                .build()
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }
}
