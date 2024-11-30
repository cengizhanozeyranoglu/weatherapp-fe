package com.cengizhanozeyranoglu.handler;

import com.cengizhanozeyranoglu.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExcepitonHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(ex, request));
    }


    public <E> ApiError<E> createApiError(E message, WebRequest request) {

        ApiError<E> apiError = new ApiError<>();

        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception<E> exception = new Exception<>();

        exception.setCreateTime(new Date());
        exception.setMessage(message);
        exception.setPath(request.getDescription(false).substring(4));
        exception.setHostName(getHostName());
        apiError.setException(exception);
        return apiError;
    }

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("HATA OLUSTU" + e.getMessage());
        }
        return "";
    }

}
