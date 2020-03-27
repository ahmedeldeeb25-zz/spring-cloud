package com.project.main.rest.errors;

import java.io.ObjectInputStream.GetField;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler({NotFoundException.class})
//	public void NotFoundException() {}
//	

//	@org.springframework.web.bind.annotation.ExceptionHandler({ NotFoundException.class })
//	public ResponseEntity<Error> handleNotFoundException(NotFoundException e) {
//		return error(HttpStatus.NOT_FOUND, e);
//	}
//
//	@org.springframework.web.bind.annotation.ExceptionHandler({ BadRequestException.class })
//	public ResponseEntity<Error> handleBadRequestException(BadRequestException e) {
//		return error(HttpStatus.BAD_REQUEST, e);
//	}

//	private ResponseEntity<Error> error(HttpStatus status, Exception e) {
//		final ResponseEntity<Error> body = ResponseEntity.status(status).body(new Error(e.getMessage(), status.toString()));
//		return body;
//	}

	// error handle for @Valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

//		ex.getBindingResult().getAllErrors().forEach(error -> {
//		String fieldName = ((FieldError) error).getField();
//		String errorMessage = error.getDefaultMessage();
//		errors.put(fieldName, errorMessage);
//	});
		// Get all fields errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}

}
