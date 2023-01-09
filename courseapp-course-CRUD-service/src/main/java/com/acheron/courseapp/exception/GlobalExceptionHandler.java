package com.acheron.courseapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acheron.courseapp.model.ApiErrors;

/**
 * @author Jagannath sutar
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	/**This method returns an over ridden HttpMediaTypeNotSupportedException
     * @param ex passes the HttpMediaTypeNotSupportedException to the method
     * @param headers HttpHeaders are passed to the method 
     * @param status HttpStatus of the given request is passed
     * @param request the web request path is passed
     * @return an ResponseEntity of Object type with status, headers and errors
     */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String message=ex.getMessage();
        String error="Check Input Format";
        ApiErrors errors=new ApiErrors(error,message,HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(),LocalDateTime.now());
        headers.add("info",message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(errors);
	}

	 /**This method returns an over ridden MissingPathVariableException
     * @param ex passes the MissingPathVariableException to the method
     * @param headers HttpHeaders are passed to the method 
     * @param status HttpStatus of the given request is passed
     * @param request the web request path is passed
     * @return an ResponseEntity of Object type with status, headers and errors
     */
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String message=ex.getMessage();
        String error="Path variable is missing";
        headers.add("info", "give a path variable");
        ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
        return ResponseEntity.status(status).headers(headers).body(errors);
	}

	 /**This method returns an over ridden TypeMismatchException
     * @param ex passes the TypeMismatchException to the method
     * @param headers HttpHeaders are passed to the method 
     * @param status HttpStatus of the given request is passed
     * @param request the web request path is passed
     * @return an ResponseEntity of Object type with status, headers and errors
     */
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String message=ex.getMessage();
        String error="Input Type Is Mismatched";
        headers.add("info", "check the input type");
        ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
        return ResponseEntity.status(status).headers(headers).body(errors);
	}

	 /**This method returns an over ridden HttpMessageNotReadableException
     * @param ex passes the HttpMessageNotReadableException to the method
     * @param headers HttpHeaders are passed to the method 
     * @param status HttpStatus of the given request is passed
     * @param request the web request path is passed
     * @return an ResponseEntity of Object type with status, headers and errors
     */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		 String message=ex.getMessage();
	        String error="Body is Incorrect";
	        headers.add("info","Request body is not in good format");
	        ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
	        return ResponseEntity.status(status).headers(headers).body(errors);	}

	/**This method returns an over ridden Exception
     * @param ex passes the Exception to the method
     * @param headers HttpHeaders are passed to the method 
     * @param status HttpStatus of the given request is passed
     * @param request the web request path is passed
     * @return an ResponseEntity of Object type with status, headers and errors
     */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatusCode statusCode, WebRequest request) {
		String message=ex.getMessage();
        String error="Internal Server Error";
        headers.add("info", "Internal service is having an problem");
        ApiErrors errors=new ApiErrors(error,message,statusCode,statusCode.value(),LocalDateTime.now());
        return ResponseEntity.status(statusCode).headers(headers).body(errors);
	}

	 /**This method returns an over ridden HttpRequestMethodNotSupportException
     * @param ex passes the HttpRequestMethodNotSupportedException to the method
     * @param headers HttpHeaders are passed to the method 
     * @param status HttpStatus of the given request is passed
     * @param request the web request path is passed
     * @return an ResponseEntity of Object type with status, headers and errors
     */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		 String message=ex.getMessage();
	        String error="Requested Method Not Supported";
	        headers.add("info","Accessing method request is not defined");
	        ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
	        return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	/**This method over ridden the IdNotFoundException
     * @param ex passes the Exception of the type IdNotFoundException
     * @return an ResponseEntity of type Object with HttStatus, HttpHeaders along with body
     */
//    @ExceptionHandler(IdNotFoundException.class)
//    public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex){
//        String message=ex.getMessage();
//        String error="Id Not Found";
//        ApiErrors errors=new ApiErrors(error,message,HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value(),LocalDateTime.now());
//        HttpHeaders headers=new HttpHeaders();
//        headers.add("info",message);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
//        
//    }
    
    /**This method over ridden the IdNotFoundException
     * @param ex passes the Exception of the type IdNotFoundException
     * @return an ResponseEntity of type Object with HttStatus, HttpHeaders along with body
     */
//    @ExceptionHandler(IdNotFoundException.class)
//    public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException ex){
//        String message=ex.getMessage();
//        String error="Course Not Found";
//        ApiErrors errors=new ApiErrors(error,message,HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value(),LocalDateTime.now());
//        HttpHeaders headers=new HttpHeaders();
//        headers.add("info",message);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
//        
//    }
	
	
   

}
