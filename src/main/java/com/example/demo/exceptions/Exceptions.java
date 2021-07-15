package com.example.demo.exceptions;

import org.aspectj.weaver.ast.Not;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Exceptions extends Throwable{



    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UserTokenNotValidException.class)
    public Map<String, Object> userTokenNotValidException() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 403);
        map.put("message", "Sorry, your token has expired or does not exists.");
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ExceptionHandler(AlreadyExistsException.class)
    public Map<String, Object> alreadyExistException(AlreadyExistsException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 208);
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(LimitPassedException.class)
    public Map<String, Object> limitPassedExceptionHandler(LimitPassedException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 406);
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public NotFoundException notFoundExceptionHandler(NotFoundException e){
        return e;
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(WrongPasswordException.class)
    public Map<String, Object> wrongPasswordException(WrongPasswordException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.UNAUTHORIZED.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public Map<String, Object> internalServerErrorException(InternalServerErrorException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WasNotFoundException.class)
    public Map<String, Object> wasNotFoundException(WasNotFoundException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.NOT_FOUND.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Object> constraintViolationException(ConstraintViolationException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, Object> dataIntegrityViolationException(DataIntegrityViolationException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public Map<String, Object> invalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JpaSystemException.class)
    public Map<String, Object> jpaSystemException(JpaSystemException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, Object> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.BAD_REQUEST.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.BAD_REQUEST.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Map<String, Object> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.BAD_REQUEST.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Map<String, Object> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.BAD_REQUEST.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.METHOD_NOT_ALLOWED.value());
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String, Object> HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.METHOD_NOT_ALLOWED.value());
        map.put("message", e.getMessage());
        return map;
    }

}
