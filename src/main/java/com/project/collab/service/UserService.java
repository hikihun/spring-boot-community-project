package com.project.collab.service;

import static com.project.collab.exception.ErrorCode.ALREADY_REGISTER_USER;
import static com.project.collab.exception.ErrorCode.LOGIN_CHECK_FAIL;
import static com.project.collab.exception.ErrorCode.NOT_FOUND_USER;

import com.project.collab.config.jwt.JwtAuthenticationProvider;
import com.project.collab.domain.User;
import com.project.collab.domain.dto.SignInForm;
import com.project.collab.exception.CustomException;
import com.project.collab.domain.dto.SignUpForm;
import com.project.collab.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final JwtAuthenticationProvider provider;

    /**
     * 회원가입
     */
    @Transactional
    public User signUp(SignUpForm form) {
        // 이메일 중복 확인
        validateDuplicateUser(form);

        // 이메일 인증
        // 프론트 단에서 비동기로 이메일인증 api 호출

        // 이메일 확인
        // 프론트 단에서 비동기로 이메일 인증 확인 api 호출

        // 회원가입 완료
        return userRepository.save(User.from(form));
    }

    /**
     *  중복 회원 예외 처리
     */
    private void validateDuplicateUser(SignUpForm form) {
        // exception
        Optional<User> result = userRepository.findByEmail(form.getEmail());
        if (!result.isEmpty()) {
            throw new CustomException(ALREADY_REGISTER_USER);
        }
    }

    /**
     * 유저 정보 가져오기
     */
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(
            () -> new CustomException(NOT_FOUND_USER)
        );
    }

    /**
     * 로그인
     */
    public String signIn(SignInForm form) {
        User user = userRepository.findByEmail(form.getEmail()).stream()
            .filter(u -> u.getPassword().equals(form.getPassword())).findFirst()
            .orElseThrow(() -> new CustomException(LOGIN_CHECK_FAIL));
        return provider.createToken(user.getEmail(), user.getId());
    }
}
