package com.project.collab.domain.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailAuthFrom {
    private String email;
    private String code;
}
