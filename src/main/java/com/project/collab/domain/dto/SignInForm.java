package com.project.collab.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInForm {

    private String email;
    private String password;
}
