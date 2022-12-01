package model;

public class CalculatorModel {

	private TextRegister display;
	
	private double result;
	
	private enum Function {
		ADD,
		SUB,
		MUL,
		DIV,
		SQR,
		SRT,
		NEG,
		EQU
	}
	
	private Function lastOp;
	
	public CalculatorModel() {
		display = new TextRegister();
		clearAll();
	}

	/**
	 * Clears the stack and input of the calculator
	 */
	public void clearAll() {
		display.setValue("0");
		lastOp = Function.ADD;
		result = 0;
	}
	
	private void doFunction(Function fun) {
		double operand = 0;
		
		// Parse display
		try {
			operand = parseDisplay();
		} catch (Exception e) {
			display.setValue("0");
			display.setTempMessage("Error");
		}
		
		switch (lastOp) {
			case ADD:
				result = result + operand;
				break;
			case DIV:
				result = result / operand;
				break;
			case EQU:
				result = operand;
				break;
			case MUL:
				result = result * operand;
				break;
			case NEG:
				if (display.isTempMessage()) result = -result;
				else result = -operand;
				break;
			case SQR:
				break;
			case SRT:
				break;
			case SUB:
				break;
			default:
				break;
		}
		
		display.setValue("0");
		display.setTempMessage(String.valueOf(result));
	}
	
	private double parseDisplay() {
		return Double.valueOf(display.getValue());
	}
	
	/**
	 * Presses a button on the virtual calculator
	 * @param button Button to press
	 */
	public void pressButton(KeypadButton button) {
		
		// Check to see if it is a button or period
		if (button == KeypadButton.BUTTON_0 || button == KeypadButton.BUTTON_1 || button == KeypadButton.BUTTON_2 || button == KeypadButton.BUTTON_3 || button == KeypadButton.BUTTON_4 || button == KeypadButton.BUTTON_5 || button == KeypadButton.BUTTON_6 || button == KeypadButton.BUTTON_7 || button == KeypadButton.BUTTON_8 || button == KeypadButton.BUTTON_9 || button == KeypadButton.BUTTON_DOT) {
			if (display.isTempMessage()) {
				display.setValue("");
			}
			
			// Do checking for leading zeros
			while (display.getValue().startsWith("0")) {
				display.setValue(display.getValue().substring(1));
			}
			while (display.getValue().startsWith("-0")) {
				display.setValue("-" + display.getValue().substring(2));
			}
		}
		
		switch (button) {
			// The first 10 of these are just numbers, nearly identical in behavior
		
			case BUTTON_0:
				display.addToValue("0");
				break;
					
			case BUTTON_1:
				display.addToValue("1");
				break;
				
			case BUTTON_2:
				display.addToValue("2");
				break;
				
			case BUTTON_3:
				display.addToValue("3");
				break;
				
			case BUTTON_4:
				display.addToValue("4");
				break;
				
			case BUTTON_5:
				display.addToValue("5");
				break;
				
			case BUTTON_6:
				display.addToValue("6");
				break;
				
			case BUTTON_7:
				display.addToValue("7");
				break;
				
			case BUTTON_8:
				display.addToValue("8");
				break;
				
			case BUTTON_9:
				display.addToValue("9");
				break;
				
			case BUTTON_ADD:
				doFunction(Function.ADD);
				break;
				
			case BUTTON_DIV:
				doFunction(Function.DIV);
				break;
				
			case BUTTON_DOT:
				// If there is already a decimal, just ignore it
				if (display.getValue().contains(".")) break;
				
				// If there is no numbers in the register, add a zero before the decimal
				// Include logic for minus sign
				if (display.getValue().length() == 0 || (display.getValue().length() == 1 && display.getValue().charAt(0) == '-')) display.addToValue("0");
				
				// Add the decimal
				display.addToValue(".");
				break;
				
			case BUTTON_NEGATE:
				doFunction(Function.NEG);
				break;

			case BUTTON_MUL:
				doFunction(Function.MUL);
				break;
				
			case BUTTON_M_CLEAR:
				// Press the clear button twice to clear all
				if (display.getValue().length() != 0) display.setValue("");
				else clearAll();
				break;
				
			case BUTTON_M_MINUS:
				break;
				
			case BUTTON_M_PLUS:
				break;
				
			case BUTTON_M_RECALL:
				break;
				
			case BUTTON_SQR:
				doFunction(Function.SQR);
				break;
				
			case BUTTON_SRT:
				doFunction(Function.SRT);
				break;
				
			case BUTTON_SUB:
				doFunction(Function.SUB);
				break;
				
			case BUTTON_EQUAL:
				doFunction(Function.EQU);
				break;
				
			default:
				break; 
				
		}
	}
	
	/**
	 * Returns the display of the calculator
	 * @return Calculator display
	 */
	public TextRegister getDisplay() {
		return display;
	}
}
