
package com.nelioalves.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.nelioalves.cursomc.services.exceptions.AuthorizationException;
import com.nelioalves.cursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.cursomc.services.exceptions.FileException;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		var standardError = StandardError.builder().timestamp(System.currentTimeMillis())
				.status(HttpStatus.NOT_FOUND.value()).error("Não encontrado").message(e.getMessage())
				.path(request.getRequestURI()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		var standardError = StandardError.builder().timestamp(System.currentTimeMillis())
				.status(HttpStatus.BAD_REQUEST.value()).error("Integridade de dados").message(e.getMessage())
				.path(request.getRequestURI()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNot(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		var validationError = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Erro de validação", e.getMessage(), request.getRequestURI());

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			validationError.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validationError);
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {

		var standardError = StandardError.builder().timestamp(System.currentTimeMillis())
				.status(HttpStatus.FORBIDDEN.value()).error("Acesso negado").message(e.getMessage())
				.path(request.getRequestURI()).build();

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(standardError);
	}

	@ExceptionHandler(FileException.class)
	public ResponseEntity<StandardError> file(FileException e, HttpServletRequest request) {
		var standardError = StandardError.builder().timestamp(System.currentTimeMillis())
				.status(HttpStatus.BAD_REQUEST.value()).error("Erro de arquivo").message(e.getMessage())
				.path(request.getRequestURI()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}

	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<StandardError> amazonService(AmazonServiceException e, HttpServletRequest request) {

		HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
		var standardError = StandardError.builder().timestamp(System.currentTimeMillis()).status(code.value())
				.error("Erro Amazon Service").message(e.getMessage()).path(request.getRequestURI()).build();

		return ResponseEntity.status(code).body(standardError);
	}

	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<StandardError> amazonClient(AmazonClientException e, HttpServletRequest request) {

		var standardError = StandardError.builder().timestamp(System.currentTimeMillis())
				.status(HttpStatus.BAD_REQUEST.value()).error("Erro Amazon Client").message(e.getMessage())
				.path(request.getRequestURI()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}

	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<StandardError> amazonS3(AmazonS3Exception e, HttpServletRequest request) {

		var standardError = StandardError.builder().timestamp(System.currentTimeMillis())
				.status(HttpStatus.BAD_REQUEST.value()).error("Erro S3").message(e.getMessage())
				.path(request.getRequestURI()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}
}