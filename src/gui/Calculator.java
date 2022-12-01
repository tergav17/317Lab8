package gui;

import javax.swing.*;

import com.StringObserver;

import model.CalculatorModel;
import model.KeypadButton;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator implements StringObserver {
	
	public JFrame frame = new JFrame("Calculator 317");
    JPanel panel = new JPanel(new FlowLayout());
    JPanel screen = new JPanel(new BorderLayout());
    JTextField text = new JTextField();
    
    JButton num0 = new JButton("0");
    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");
    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton mult = new JButton("x");
    JButton div = new JButton("/");
    
    JButton sqr = new JButton("sqr");
    JButton sqrt = new JButton("sqrt");
    
    JButton mem = new JButton("M");
    JButton memPlus = new JButton("M+");
    JButton memMin = new JButton("M-");
    
    JButton equals = new JButton("=");
    JButton delete = new JButton("del");
    JButton clear = new JButton("C");
    JButton decimal = new JButton(".");
    
    private CalculatorModel model;
    
    public Calculator(CalculatorModel model) {
    	
    	this.model = model;
    	
    	frame.setVisible(true); 
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        text.setSize(500, 30);
        panel.add(text, BorderLayout.NORTH);
        
        panel.add(num0);
        panel.add(num1);
        panel.add(num2);
        panel.add(num3);
        panel.add(num4);
        panel.add(num5);
        panel.add(num6);
        panel.add(num7);
        panel.add(num8);
        panel.add(num9);
        
        panel.add(add);
        panel.add(sub);
        panel.add(mult);
        panel.add(div);
        
        panel.add(sqr);
        panel.add(sqrt);
        
        panel.add(mem);
        panel.add(memPlus);
        panel.add(memMin);
        
        panel.add(delete);
        panel.add(clear);
        panel.add(decimal);
        panel.add(equals);
        
        this.num0.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
                    	model.pressButton(KeypadButton.BUTTON_0);
                    }
            	}
            );
        this.num1.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_1);
                    }
            	}
            );
        this.num2.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_2);
                    }
            	}
            );
        this.num3.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_3);
                    }
            	}
            );
        this.num4.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_4);
                    }
            	}
            );
        this.num5.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_5);
                    }
            	}
            );
        this.num6.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_5);
                    }
            	}
            );
        this.num7.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_6);
                    }
            	}
            );
        this.num8.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_7);
                    }
            	}
            );
        this.num9.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(KeypadButton.BUTTON_8);
                    }
            	}
            );
        
        
        /*
         * And so on...  TODO
         */

        
    }

	@Override
	public void update(String d) {
		// Set the text of text to the string during a update event
		text.setText(d);
		
	}
    

}