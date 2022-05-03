package com.imon.servermanagement.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


@JsonInclude (NON_NULL)
public class ResponseModel {
	protected LocalDateTime timestamp;
	protected int statusCode;
	protected HttpStatus httpStatus;
	protected String message;
	protected Map<?,?> data;

}
