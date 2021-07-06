package com.learning.sms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StudentNoDataFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private String errorMessage;
	private long id;

	public StudentNoDataFoundException(long id) {
		super(String.format("No record found for Student with id : %o", id));
	}

}
