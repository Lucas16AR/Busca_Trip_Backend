package com.trip.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trip.Jwt.JwtService;
import com.trip.models.Role;
import com.trip.models.UserModel;
import com.trip.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // public AuthResponse login(LoginRequest request) {
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
        // return {
        //     "token": token,
        //     "user": user
        // }

    }

    public AuthResponse register(RegisterRequest request) {
        UserModel user = UserModel.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .name(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .gender(request.getGender())
            .age(request.getAge())
            .phoneNumber(request.getPhoneNumber())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }
    
}
