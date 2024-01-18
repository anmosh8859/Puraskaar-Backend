package com.puraskaar.puraskaar.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {
    private LocalDate timestamp;
    private String message;
    private String details;
}
