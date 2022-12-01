package main;

import gui.Calculator;
import model.CalculatorModel;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the calulator!");
		
		// Create calculate model
		CalculatorModel model = new CalculatorModel();
		
		// Create GUI
		Calculator calc = new Calculator(model);
		calc.frame.setVisible(true);
		
		// Bind calc to model
		model.getDisplay().addObserver(calc);
		
		// Clear all
		model.clearAll();
        
	}
}
