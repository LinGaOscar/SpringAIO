package com.oscar.nicholas.dto;

public interface Convert<S, T> {
    T convert(S s, T t);

}