package com.project.collab.service;

import com.project.collab.domain.User;
import com.project.collab.domain.dto.SignUpForm;
import com.project.collab.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("회원가입")
    public void signUp() throws Exception {
        //given
        SignUpForm form = SignUpForm.builder()
            .email("test@test.com")
            .name("홍길동")
            .password("1234567")
            .verify(true)
            .build();

        //when
        User user1 = userService.signUp(form);
        User user = userRepository.findById(user1.getId()).get();

        //then
        Assertions.assertEquals(user.getEmail(), user1.getEmail());
        Assertions.assertEquals(user.getName(), user1.getName());
        Assertions.assertEquals(user.getPassword(), user1.getPassword());
    }

}