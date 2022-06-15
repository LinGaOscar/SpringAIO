package com.oscar.nicholas.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InvalidErrorResource {
    private String message;
    private Object errors;
}
