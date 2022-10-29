package com.ms.email.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmailDto {

    @NotBlank @NotNull @Email
    private String emailTo;
    @NotBlank @NotNull
    private String subject;
    @NotBlank @NotNull
    private String text;
}
