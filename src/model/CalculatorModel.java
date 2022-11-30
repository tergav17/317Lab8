package model;

public class CalculatorModel {

	private TextRegister display;
	
	public CalculatorModel() {
		display = new TextRegister();
	}

	/**
	 * Presses a button on the virtual calculator
	 * @param button Button to press
	 */
	public void pressButton(KeypadButton button) {
		switch (button) {
			case BUTTON_0:
					
			case BUTTON_1:
				break;
			case BUTTON_2:
				break;
			case BUTTON_3:
				break;
			case BUTTON_4:
				break;
			case BUTTON_5:
				break;
			case BUTTON_6:
				break;
			case BUTTON_7:
				break;
			case BUTTON_8:
				break;
			case BUTTON_9:
				break;
			case BUTTON_ADD:
				break;
			case BUTTON_DIV:
				break;
			case BUTTON_DOT:
				break;
			case BUTTON_MINUS:
				break;
			case BUTTON_MUL:
				break;
			case BUTTON_M_CLEAR:
				break;
			case BUTTON_M_MINUS:
				break;
			case BUTTON_M_PLUS:
				break;
			case BUTTON_M_RECALL:
				break;
			case BUTTON_SQR:
				break;
			case BUTTON_SRT:
				break;
			case BUTTON_SUB:
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
