package com.hcl.iTime.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.iTime.utility.TimesheetUtility;



/**
 * @author ShilendraSingh
 * @since   2019-09-23
 * @version 1.0 
 *
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> recordNotFoundException(RecordNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), TimesheetUtility.STATUS_FAIL);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<ErrorResponse> invalidDateException(InvalidDateException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), TimesheetUtility.STATUS_FAIL);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HolidayDateException.class)
	public ResponseEntity<ErrorResponse> holidayDateException(HolidayDateException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), TimesheetUtility.STATUS_FAIL);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
