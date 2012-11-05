package com.color.speechbubble;

public class Message {
	/**
	 * The content of the message
	 */
	String message;
	/**
	 * boolean to determine, who is sender of this message
	 */
	boolean isMine;
	/**
	 * Constructor to make a message object
	 */
	public Message(String message, boolean isMine) {
		super();
		this.message = message;
		this.isMine = isMine;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isMine() {
		return isMine;
	}
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
	
}
