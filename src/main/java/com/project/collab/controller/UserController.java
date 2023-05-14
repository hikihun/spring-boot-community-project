package com.project.collab.controller;

import com.project.collab.domain.dto.EmailAuthFrom;
import com.project.collab.domain.dto.SignInForm;
import com.project.collab.domain.dto.SignUpForm;
import com.project.collab.service.EmailService;
import com.project.collab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    /**
     * 회원가입
     */
    @PostMapping("/api/user/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpForm form) {
        return ResponseEntity.ok(userService.signUp(form));
    }

    /**
     * 인증 메일 전송
     */
    @PostMapping("/api/user/signup/mail")
    public ResponseEntity<?> emailAuth(@RequestBody EmailAuthFrom form) {
        emailService.emailAuth(form.getEmail());
        return ResponseEntity.ok("인증번호 전송이 완료되었습니다. 이메일을 확인해 주세요.");
    }

    /**
     * 이메일 인증 확인
     */
    @PostMapping("/api/user/signup/maila/auth")
    public ResponseEntity<?> verifyEmailAuth(@RequestBody EmailAuthFrom form) {
        emailService.verifyEmail(form.getEmail(), form.getCode());
        return ResponseEntity.ok("인증이 완료되었습니다.");
    }

    /**
     * 로그인
     */
    @PostMapping("/api/user/signin")
    public ResponseEntity<String> signIn(@RequestBody SignInForm form) {
        return ResponseEntity.ok(userService.signIn(form));
    }

}