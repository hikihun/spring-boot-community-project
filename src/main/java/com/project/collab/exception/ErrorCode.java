package com.project.collab.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    // 회원가입
    ALREADY_REGISTER_USER(HttpStatus.BAD_REQUEST, "이미 존재하는 이메일 입니다."),
    NOT_FOUND_USER(HttpStatus.BAD_REQUEST, "일치하는 회원이 없습니다."),
    NOT_MATCH_CODE(HttpStatus.BAD_REQUEST, "인증 코드가 일치하지 않습니다."),
    EXPIRE_CODE(HttpStatus.BAD_REQUEST, "인증 시간이 만료되었습니다."),
    // 로그인
    LOGIN_CHECK_FAIL(HttpStatus.BAD_REQUEST, "아이디와 패스워드를 확인해 주세요");
    private final HttpStatus httpStatus;
    private final String detail;
}