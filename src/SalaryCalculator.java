/**
 * @author Shreeniket Bendre
 * Project: SalaryCalculator
 * Class: SalaryCalculator
 * 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalculator {

	public static void main(String[] args) {
		
		//================================================================================
	    // JFrame Elements
	    //================================================================================

		
		//Frame
		JFrame frame = new JFrame("Salary Calculator");
		frame.setBounds(300, 300, 300, 200);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.orange);
		//Labels
		JLabel rateLabel = new JLabel("Hourly Rate:");
		frame.add(rateLabel);
		rateLabel.setBounds(20,20,100,25);

		JLabel hrsLabel = new JLabel("Hours/Week:");
		frame.add(hrsLabel);
		hrsLabel.setBounds(20,45,100,25);
		
		JLabel resultLabel = new JLabel("Annual Salary: $");
		frame.add(resultLabel);
		resultLabel.setBounds(125,95,300,25);

		//TextFields
		JTextField rateTextField = new JTextField();
		frame.add(rateTextField);
		rateTextField.setBounds(100, 20, 120, 25);

		JTextField hrsTextField = new JTextField();
		frame.add(hrsTextField);
		hrsTextField.setBounds(100, 45, 120, 25);

		//Buttons
		JCheckBox checkBox = new JCheckBox("Full Time");
		frame.add(checkBox);
		checkBox.setBackground(Color.orange);
		checkBox.setBounds(20, 70, 100, 20);

		JButton calcButton = new JButton("Calculate");
		frame.add(calcButton);
		calcButton.setBounds(20, 95, 100, 25);
		

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//================================================================================
		// Action Listeners
		//================================================================================
				
		//Button Listener
		calcButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(checkBox.isSelected()) {
					String rateString = rateTextField.getText();
					double rate = 0;
					boolean errorOccur = false;
					try {
						rate = Double.parseDouble(rateString);
					}
					catch(Exception error) {
						errorOccur = true;
					}
					if (!errorOccur) {
						double yearlySalary = (rate*40)*52;
						resultLabel.setText("Annual Salary: $"+yearlySalary);
					}
				}
				else {
					String rateString = rateTextField.getText();
					String hrsString = hrsTextField.getText();
					boolean errorOccur = false;

					double rate = 0, hrs = 0;
					try {
						rate = Double.parseDouble(rateString);
						hrs = Double.parseDouble(hrsString);
					}
					catch(Exception error) {
						errorOccur = true;
					}
					if (!errorOccur) {
						double yearlySalary = (rate*hrs)*52;

						resultLabel.setText("Annual Salary: $"+yearlySalary);
					}
				}

			}

		});
		
		//CheckBox Listener
		checkBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (checkBox.isSelected()) {
					hrsTextField.setText("DISABLED");
					hrsTextField.setEnabled(false);
				}
				else {
					hrsTextField.setText("");
					hrsTextField.setEnabled(true);
				}
			}

		});
		


	}

}
