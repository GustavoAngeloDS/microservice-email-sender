package com.ms.email.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmailDto {

    @NotBlank @NotNull
    private String ownerRef;
    @NotBlank @NotNull @Email
    private String emailFrom;
    @NotBlank @NotNull @Email
    private String emailTo;
    @NotBlank @NotNull
    private String subject;
    @NotBlank @NotNull
    private String text;
}
