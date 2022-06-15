package com.oscar.nicholas.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FieldResource {
    private String resource;
    private String field;
    private String code;
    private String message;
}
