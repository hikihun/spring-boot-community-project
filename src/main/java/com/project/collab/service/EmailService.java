package com.project.collab.service;

import static com.project.collab.exception.ErrorCode.ALREADY_REGISTER_USER;
import static com.project.collab.exception.ErrorCode.EXPIRE_CODE;
import static com.project.collab.exception.ErrorCode.NOT_MATCH_CODE;

import com.project.collab.exception.CustomException;
import com.project.collab.repository.UserRepository;
import java.util.Random;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final RedisUtil redisUtil;

    /**
     * 인증메일 전송
     */
    public void emailAuth(String email) {
        Random random = new Random();
        String authKey = String.valueOf(random.nextInt(888888) + 111111);
        sendEmail(email, authKey);
    }

    private void sendEmail(String email, String authKey) {
            String subject = "회원가입 인증번호 입니다.";
            String text = "회원 가입을 위한 인증 번호는" + authKey + "입니다.";

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text, true);
            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        redisUtil.setDataExpire(email, authKey, 60);
    }

    /**
     * 인증 확인
     */
    public void verifyEmail(String email, String code) {
        userRepository.findByEmail(email).ifPresent(u -> {
            throw new CustomException(ALREADY_REGISTER_USER);
        });

        String codeByEmail = redisUtil.getData(email);
        if (codeByEmail == null) {
            throw new CustomException(EXPIRE_CODE);
        } else if (!codeByEmail.equals(code)) {
            throw new CustomException(NOT_MATCH_CODE);
        }
    }

}
