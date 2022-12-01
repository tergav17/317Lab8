package unit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.CalculatorModel;
import model.KeypadButton;

public class ModelTests {
	
	private CalculatorModel model;
	DisplayMonitor monitor;
	
	/**
	 * Add unit tests here
	 */

	@Before
	public void testInit() {
		model = new CalculatorModel();
		
		monitor = new DisplayMonitor();
		model.getDisplay().addObserver(monitor);
	}
	
	/**
	 * Tests the clear function
	 */
	@Test
	public void clearTest() {
		model.clearAll();
		
		assertTrue(monitor.getContent().equals("0"));
	}
	
	/**
	 * Test typing a single number
	 */
	@Test
	public void typeSingleNumberTest() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_1);
		
		assertTrue(monitor.getContent().equals("1"));
	}
	
	/**
	 * Tests typing multiple numbers
	 */
	@Test
	public void typeMultipleNumberTest() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_1);
		
		assertTrue(monitor.getContent().equals("21"));
	}
	
	/**
	 * Tests to make sure multiple leading zeros cannot be typed
	 */
	@Test
	public void typeMultipleZerosTest() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_0);
		model.pressButton(KeypadButton.BUTTON_0);
		
		assertTrue(monitor.getContent().equals("0"));
	}
	
	/**
	 * Tests the delete key
	 */
	@Test
	public void typeDeleteTest() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_1);
		model.pressButton(KeypadButton.BUTTON_DEL);
		
		assertTrue(monitor.getContent().equals("2"));
	}
	
	/**
	 * Tests the decimal key
	 */
	@Test
	public void typeDecimalTest() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_DOT);
		
		assertTrue(monitor.getContent().equals("0."));
	}
	
	/**
	 * Tests typing after the decimal key
	 */
	@Test
	public void typeDecimalPlusKeyTest() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_DOT);
		model.pressButton(KeypadButton.BUTTON_8);
		
		assertTrue(monitor.getContent().equals("0.8"));
	}
	
	/**
	 * Tests to make sure multiple decimal points cannot be placed
	 */
	@Test
	public void typeMultipleDecimalTest() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_DOT);
		model.pressButton(KeypadButton.BUTTON_6);
		model.pressButton(KeypadButton.BUTTON_DOT);
		
		assertTrue(monitor.getContent().equals("0.6"));
	}
	
	/**
	 * Simple add operation
	 */
	@Test
	public void typeSimpleAdd() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_ADD);
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		
		assertTrue(monitor.getContent().equals("4.0"));
	}
	
	/**
	 * Simple subtract operation
	 */
	@Test
	public void typeSimpleSub() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_4);
		model.pressButton(KeypadButton.BUTTON_SUB);
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		
		assertTrue(monitor.getContent().equals("2.0"));
	}
	
	/**
	 * Simple multiplication operation
	 */
	@Test
	public void typeSimpleMul() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_MUL);
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		
		assertTrue(monitor.getContent().equals("6.0"));
	}
	
	/**
	 * Simple division operation
	 */
	@Test
	public void typeSimpleDiv() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_8);
		model.pressButton(KeypadButton.BUTTON_DIV);
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		
		assertTrue(monitor.getContent().equals("4.0"));
	}
	
	/**
	 * Simple chain add operation
	 */
	@Test
	public void typeChainAdd() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_5);
		model.pressButton(KeypadButton.BUTTON_ADD);
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_ADD);
		
		assertTrue(monitor.getContent().equals("7.0"));
	}
	
	/**
	 * Simple chain add with equal at the end
	 */
	@Test
	public void typeChainAddWithEqual() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_1);
		model.pressButton(KeypadButton.BUTTON_ADD);
		model.pressButton(KeypadButton.BUTTON_2);
		model.pressButton(KeypadButton.BUTTON_ADD);
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		
		assertTrue(monitor.getContent().equals("6.0"));
	}
	
	/**
	 * Tests the clear button
	 */
	@Test
	public void typeClear() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_1);
		model.pressButton(KeypadButton.BUTTON_CLS);
		
		assertTrue(monitor.getContent().equals("0"));
	}
	
	/**
	 * Tests negation operation
	 */
	@Test
	public void typeNegate() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_1);
		model.pressButton(KeypadButton.BUTTON_NEGATE);
		
		assertTrue(monitor.getContent().equals("-1.0"));
	}
	
	/**
	 * Test square root operation
	 */
	@Test
	public void typeSqrt() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_1);
		model.pressButton(KeypadButton.BUTTON_6);
		model.pressButton(KeypadButton.BUTTON_SRT);
		
		assertTrue(monitor.getContent().equals("4.0"));
	}
	
	/**
	 * Tests square operation
	 */
	@Test
	public void typeSquare() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_SQR);
		
		assertTrue(monitor.getContent().equals("9.0"));
	}
	
	/**
	 * Tests square chain
	 */
	@Test
	public void typeSquareChain() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_SQR);
		model.pressButton(KeypadButton.BUTTON_SQR);
		
		assertTrue(monitor.getContent().equals("81.0"));
	}
	
	/**
	 * Test square chain, and then a clear
	 */
	@Test
	public void typeSquareChainWithClear() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_SQR);
		model.pressButton(KeypadButton.BUTTON_SQR);
		model.pressButton(KeypadButton.BUTTON_CLS);
		
		assertTrue(monitor.getContent().equals("0"));
	}
	
	/**
	 * Memory add, then recall
	 */
	@Test
	public void testMemoryAddAndRecall() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		model.pressButton(KeypadButton.BUTTON_M_PLUS);
		model.pressButton(KeypadButton.BUTTON_CLS);
		model.pressButton(KeypadButton.BUTTON_M_RECALL);
		
		assertTrue(monitor.getContent().equals("3.0"));
	}
	
	/**
	 * Memory subtract, then recall
	 */
	@Test
	public void testMemorySubAndRecall() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		model.pressButton(KeypadButton.BUTTON_M_MINUS);
		model.pressButton(KeypadButton.BUTTON_CLS);
		model.pressButton(KeypadButton.BUTTON_M_RECALL);
		
		assertTrue(monitor.getContent().equals("-3.0"));
	}
	
	/**
	 * Memory subtract, clear, then recall
	 */
	@Test
	public void testMemorySubAndClear() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_EQUAL);
		model.pressButton(KeypadButton.BUTTON_M_MINUS);
		model.pressButton(KeypadButton.BUTTON_CLS);
		model.pressButton(KeypadButton.BUTTON_M_CLEAR);
		model.pressButton(KeypadButton.BUTTON_M_RECALL);
		
		assertTrue(monitor.getContent().equals("0.0"));
	}
	
	/**
	 * Tests invalid memory plus
	 */
	@Test
	public void testInvalidMemoryPlus() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_M_PLUS);

		assertTrue(monitor.getContent().equals("Error"));
	}
	
	/**
	 * Tests invalid memory minus
	 */
	@Test
	public void testInvalidMemoryMinus() {
		model.clearAll();
		model.pressButton(KeypadButton.BUTTON_3);
		model.pressButton(KeypadButton.BUTTON_M_MINUS);

		assertTrue(monitor.getContent().equals("Error"));
	}
}
