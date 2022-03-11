package com.wvs.clientservice.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ErrorDTO {

    private int code;
    private String errorMessage;
    private List<String> messages;
    private LocalDate timestamp;

}
