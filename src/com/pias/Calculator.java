package com.pias;

import static org.eclipse.swt.events.SelectionListener.*;

import java.awt.event.ActionListener;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

public class Calculator {

	private String nums;
	private String num1S;
	private String num2S;
	private int num1;
	private int num2;
	private String inp;
	private int finalNum;
	private boolean hasEquals;
	private boolean hasNum;
	private String operation;
	Text text;

	Display display;
	Shell shell;

	Button[] digitButtons;
	Button plus, minus, clear, divide, multiply, add, equal, plusMinus, mod, dot;

	int shellWidth = 300;
	int shellHeight = 475;
	int buttonWidth = shellWidth / 4;
	int buttonHeight = buttonWidth;

	int buttonZeroWidth = buttonWidth * 2;
	int buttonZeroHeight = buttonHeight;

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.runCalculator();

	}

	private void runCalculator() {

		display = new Display();
		shell = new Shell(display);
		shell.setText("Calculator");
		shell.setSize(300 + 15, 475);
		Device device = Display.getCurrent();
		Color black = new Color(device, 45, 35, 48);
		shell.setBackground(black);
		createUI();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}

		}
		display.dispose();
	}

	private void setText(String str) {
		if (str == null)
			return;
		String textString = text.getText();
		textString += str;
		text.setText(textString);
	}

	// seperate strings into nums;
	private void findNum(String type) {

		num1S = inp.substring(0, inp.indexOf(type));
		num2S = inp.substring(inp.indexOf(type) + 1);
		num1 = Integer.parseInt(num1S);//(parseInt) This function parses the string argument as a signed decimal integer.
		num2 = Integer.parseInt(num2S);

		// 123 + 3
		// +

	} // end findNum

	public void calculate() {

		// Display display = new Display ();
		// Shell shell = new Shell (display);
		// text = new Text(shell,SWT.NONE);

		// check the symbol
		switch (operation) {

		case "+":
			findNum("+");
			finalNum = num1 + num2;
			text.setText("" + finalNum);

			break;

		case "-":
			findNum("-");
			finalNum = num1 - num2;
			text.setText("" + finalNum);
			break;

		case "*":
			findNum("*");
			finalNum = num1 * num2;
			text.setText("" + finalNum);
			break;

		case "/":
			findNum("/");
			finalNum = num1 / num2;
			text.setText("" + finalNum);
			break;
			
			

		}// end switch

	} // end calculate

	private void createUI() {

		// Create text field and place into position
		text = new Text(shell, SWT.BORDER);

		// Create buttons and place into right positions
		digitButtons = new Button[10];
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i] = new Button(shell, SWT.PUSH);
			digitButtons[i].setText(String.valueOf(i));
		}

		digitButtons[0].setBounds(0, shellHeight - buttonHeight - 40, buttonZeroWidth, buttonZeroHeight);
		digitButtons[1].setBounds(0, shellHeight - buttonHeight - 40 - buttonHeight, buttonWidth, buttonHeight);
		digitButtons[2].setBounds(0 + buttonWidth, shellHeight - 2 * buttonHeight - 40, buttonWidth, buttonHeight);
		digitButtons[3].setBounds(0 + 2 * buttonWidth, shellHeight - 2 * buttonHeight - 40, buttonWidth, buttonHeight);
		digitButtons[4].setBounds(0, shellHeight - 3 * buttonHeight - 40, buttonWidth, buttonHeight);
		digitButtons[5].setBounds(0 + buttonWidth, shellHeight - 3 * buttonHeight - 40, buttonWidth, buttonHeight);
		digitButtons[6].setBounds(0 + 2 * buttonWidth, shellHeight - 3 * buttonHeight - 40, buttonWidth, buttonHeight);
		digitButtons[7].setBounds(0, shellHeight - 4 * buttonHeight - 40, buttonWidth, buttonHeight);
		digitButtons[8].setBounds(0 + buttonWidth, shellHeight - 4 * buttonHeight - 40, buttonWidth, buttonHeight);
		digitButtons[9].setBounds(0 + 2 * buttonWidth, shellHeight - 4 * buttonHeight - 40, buttonWidth, buttonHeight);

		digitButtons[0].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("0");

			}
		});

		digitButtons[1].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("1");

			}
		});

		digitButtons[2].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("2");

			}
		});

		digitButtons[3].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("3");

			}
		});

		digitButtons[4].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("4");

			}
		});

		digitButtons[5].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("5");

			}
		});

		digitButtons[6].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("6");

			}
		});

		digitButtons[7].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("7");

			}
		});

		digitButtons[8].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("8");

			}
		});

		digitButtons[9].addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setText("9");

			}
		});

		// clear button
		clear = new Button(shell, SWT.PUSH);
		clear.setText("AC");
		clear.setBounds(0, shellHeight - 5 * buttonHeight - 40, buttonWidth, buttonHeight);

		// plusMinus Button
		plusMinus = new Button(shell, SWT.PUSH);
		plusMinus.setText("+/-");
		plusMinus.setBounds(0 + buttonWidth, shellHeight - 5 * buttonHeight - 40, buttonWidth, buttonHeight);

		// mod button
		mod = new Button(shell, SWT.PUSH);
		mod.setText("%");
		mod.setBounds(0 + 2 * buttonWidth, shellHeight - 5 * buttonHeight - 40, buttonWidth, buttonHeight);

		// divide button
		divide = new Button(shell, SWT.PUSH);
		divide.setText("/");
		divide.setBounds(0 + 3 * buttonWidth, shellHeight - 5 * buttonHeight - 40, buttonWidth, buttonHeight);
		Device device = Display.getCurrent();
		Color orange = new Color(device, 251, 104, 20);
		divide.setBackground(orange);

		// multiply button
		multiply = new Button(shell, SWT.PUSH);
		multiply.setText("*");
		multiply.setBounds(0 + 3 * buttonWidth, shellHeight - 4 * buttonHeight - 40, buttonWidth, buttonHeight);
		device = Display.getCurrent();
		orange = new Color(device, 251, 104, 20);
		multiply.setBackground(orange);

		// minus button
		minus = new Button(shell, SWT.PUSH);
		minus.setText("-");
		minus.setBounds(0 + 3 * buttonWidth, shellHeight - 3 * buttonHeight - 40, buttonWidth, buttonHeight);
		device = Display.getCurrent();
		orange = new Color(device, 251, 104, 20);
		minus.setBackground(orange);

		// add button
		add = new Button(shell, SWT.PUSH);
		add.setText("+");
		add.setBounds(0 + 3 * buttonWidth, shellHeight - 2 * buttonHeight - 40, buttonWidth, buttonHeight);
		device = Display.getCurrent();
		orange = new Color(device, 251, 104, 20);
		add.setBackground(orange);

		// equal button
		equal = new Button(shell, SWT.PUSH);
		equal.setText("=");
		equal.setBounds(0 + 3 * buttonWidth, shellHeight - buttonHeight - 40, buttonWidth, buttonHeight);
		device = Display.getCurrent();
		orange = new Color(device, 251, 104, 20);
		equal.setBackground(orange);

		// dot button
		dot = new Button(shell, SWT.PUSH);
		dot.setText(".");
		dot.setBounds(0 + 2 * buttonWidth, shellHeight - buttonHeight - 40, buttonWidth, buttonHeight);

		// text box
		text = new Text(shell, SWT.BORDER);
		text.setBounds(0, 0, 300, buttonHeight);

		// clear button listener
		clear.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				finalNum = 0;
				hasNum = false;
				hasEquals = false;
				text.setText("");

			}
		});

		// equal button listener
		equal.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				inp = text.getText();
				calculate();
				hasEquals = true;
				// text.setText();
			}
		});
		

		// add.addListener(SWT.Selection, new Listener() {
		//
		// @Override
		// public void handleEvent(Event event) {
		//
		// if(hasNum) {
		// inp = text.getText();
		// calculate();
		// String calcNum = "" + finalNum;
		// text.setText(calcNum);
		// hasNum = false;
		// } if(hasEquals) {
		// String calcNum = "" + finalNum;
		// text.setText(calcNum);
		// hasEquals = false;
		// }
		//
		// }
		// });

		add.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object source = e.getSource();// source = Button {+}

				if (hasNum) {
					inp = text.getText();
					calculate();
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					// hasNum = false;
					num1 = finalNum;
				}
				if (hasEquals) {
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					hasEquals = false;
					num1 = finalNum;
				}
				if (source instanceof Button) {
					Button btn = (Button) source;
					String butSrcTxt = btn.getText();

					operation = String.valueOf(butSrcTxt.charAt(0));
					// System.out.println(operation);// +
					// System.out.println(text.getText());//1
					// System.out.println(butSrcTxt);// +
					text.setText(text.getText() + butSrcTxt);
					hasNum = true;
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		minus.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object source = e.getSource();// source = Button {-}

				if (hasNum) {
					inp = text.getText();
					calculate();
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					hasNum = false;
				}
				if (hasEquals) {
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					hasEquals = false;
				}
				if (source instanceof Button) {
					Button btn = (Button) source;
					String butSrcTxt = btn.getText();

					operation = String.valueOf(butSrcTxt.charAt(0));
					// System.out.println(operation);// +
					// System.out.println(text.getText());//1
					// System.out.println(butSrcTxt);// +
					text.setText(text.getText() + butSrcTxt);
					hasNum = true;
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		multiply.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object source = e.getSource();// source = Button {+}

				if (hasNum) {
					inp = text.getText();
					calculate();
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					hasNum = false;
				}
				if (hasEquals) {
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					hasEquals = false;
				}
				if (source instanceof Button) {
					Button btn = (Button) source;
					String butSrcTxt = btn.getText();

					operation = String.valueOf(butSrcTxt.charAt(0));
					// System.out.println(operation);// +
					// System.out.println(text.getText());//1
					// System.out.println(butSrcTxt);// +
					text.setText(text.getText() + butSrcTxt);
					hasNum = true;
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		divide.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object source = e.getSource();// source = Button {+}

				if (hasNum) {
					inp = text.getText();
					calculate();
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					hasNum = false;
				}
				if (hasEquals) {
					String calcNum = "" + finalNum;
					text.setText(calcNum);
					hasEquals = false;
				}
				if (source instanceof Button) {
					Button btn = (Button) source;
					String butSrcTxt = btn.getText();

					operation = String.valueOf(butSrcTxt.charAt(0));
					// System.out.println(operation);// +
					// System.out.println(text.getText());//1
					// System.out.println(butSrcTxt);// +
					text.setText(text.getText() + butSrcTxt);
					hasNum = true;
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

}
