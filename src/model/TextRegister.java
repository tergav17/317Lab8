package model;

import java.util.ArrayList;

import com.StringObserver;

public class TextRegister {

	private String value;
	private boolean isTempMessage; 
	private ArrayList<StringObserver> observers = new ArrayList<>();
	
	public TextRegister() {
		isTempMessage = false;
		value = "";
	}

	/**
	 * Adds an observer object to the register
	 * @param obs
	 */
	public void addObserver(StringObserver obs) {
		observers.add(obs);
	}
	
	/**
	 * Gets the value of the register
	 * @return Register value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the register
	 * @param value Register value
	 */
	public void setValue(String value) {
		if (isTempMessage) resetTempMessage();
		
		this.value = value;
		update(value);
	}
	
	public void addToValue(String addition) {
		if (isTempMessage) resetTempMessage();
		this.value += addition;
		update(value);
	}
	
	/*
	 * Sets the error flag for the register
	 * @param tempMessage The message to display
	 */
	public void setTempMessage(String tempMessage) {
		isTempMessage = true;
		update(tempMessage);
	}
	
	/*
	 * Resets the temporary flag for the register
	 */
	public void resetTempMessage() {
		isTempMessage = false;
		update(value);
	}
	
	/**
	 * Returns the status of the temporary flag
	 * @return Temporary flag
	 */
	public boolean isTempMessage() {
		return isTempMessage;
	}
	
	/**
	 * Update all observers depending on register state
	 * @param message Message to display to observers
	 */
	private void update(String message) {
		for (StringObserver ob : observers) ob.update(message);
	}
	
}
