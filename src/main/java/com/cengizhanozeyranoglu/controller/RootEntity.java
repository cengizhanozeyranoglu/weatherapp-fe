package com.cengizhanozeyranoglu.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity<T> {

    private boolean result;

    private T data;

    private String errorMessage;

    public static <T> RootEntity<T> ok(T data) {
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setResult(true);
        rootEntity.setData(data);
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }
    public static <T> RootEntity<T>error(String errorMessage) {
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setResult(false);
        rootEntity.setErrorMessage(errorMessage);
        rootEntity.setData(null);
        return rootEntity;
    }
}
