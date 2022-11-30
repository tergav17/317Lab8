package model;

import java.util.ArrayList;

import com.StringObserver;

public class TextRegister {

	private String value;
	private boolean isError; 
	private ArrayList<StringObserver> observers = new ArrayList<>();
	
	public TextRegister() {
		isError = false;
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
		if (isError) return;
		this.value = value;
		update(value);
	}
	
	public void addToValue(String addition) {
		this.value += addition;
		update(value);
	}
	
	/*
	 * Sets the error flag for the register
	 */
	public void setError() {
		isError = true;
		update("Error");
	}
	
	/*
	 * Resets the error flag for the register
	 */
	public void resetError() {
		isError = false;
		update(value);
	}
	
	/**
	 * Returns the status of the error flag
	 * @return Error flag
	 */
	public boolean getError() {
		return isError;
	}
	
	/**
	 * Update all observers depending on register state
	 * @param message Message to display to observers
	 */
	private void update(String message) {
		for (StringObserver ob : observers) ob.update(message);
	}
	
}
