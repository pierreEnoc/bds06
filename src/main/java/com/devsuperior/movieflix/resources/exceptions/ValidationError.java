package com.devsuperior.movieflix.resources.exceptions;

import java.util.ArrayList;
import java.util.List;



public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FiledMessage> errors = new ArrayList<>();

	public List<FiledMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FiledMessage(fieldName, message));
	}

}
