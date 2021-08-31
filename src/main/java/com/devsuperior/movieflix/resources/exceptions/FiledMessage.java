package com.devsuperior.movieflix.resources.exceptions;

import java.io.Serializable;

public class FiledMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fildMessage;
	private String message;
	
	public FiledMessage() {
		
	}

	public FiledMessage(String fildMessage, String message) {
		super();
		this.fildMessage = fildMessage;
		this.message = message;
	}

	public String getFildMessage() {
		return fildMessage;
	}

	public void setFildMessage(String fildMessage) {
		this.fildMessage = fildMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
