package com.project.collab.domain;

import com.project.collab.domain.dto.SignUpForm;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime removedDate;
    private Boolean verify;

    public static User from(SignUpForm form) {
        return User.builder()
            .email(form.getEmail())
            .name(form.getName())
            .password(form.getPassword())
            .createdDate(LocalDateTime.now())
            .verify(true)
            .build();
    }
}
