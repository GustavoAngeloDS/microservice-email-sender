package com.ms.email.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
public class EmailModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
}
