package com.nelioalves.cursomc.resources;

import javax.servlet.http.HttpServletResponse;

import com.nelioalves.cursomc.security.JWTUtil;
import com.nelioalves.cursomc.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/auth")
public class AuthResource {

    private JWTUtil jwtUtil;

    @PostMapping("/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        var userSpringSecurity = UserService.authenticated();
        String token = jwtUtil.generateToken(userSpringSecurity.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }
}