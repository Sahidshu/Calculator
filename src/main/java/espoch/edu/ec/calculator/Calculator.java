/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package espoch.edu.ec.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.symja.eval.ExpressionEvaluator;
import org.symja.eval.ExpressionParser;

public class IntegralCalculator extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton calculateButton;

    public IntegralCalculator() {
        // Set up the frame
        setTitle("Integral Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input field for the integral expression
        inputField = new JTextField();
        inputField.setToolTipText("Enter the function to integrate (e.g., x^2)");
        add(inputField, BorderLayout.NORTH);

        // Output area for displaying results
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Calculate button
        calculateButton = new JButton("Calculate Integral");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateIntegral();
            }
        });
        add(calculateButton, BorderLayout.SOUTH);
    }

    private void calculateIntegral() {
        String expression = inputField.getText();
        if (expression.isEmpty()) {
            outputArea.setText("Please enter a valid expression.");
            return;
        }

        try {
            // Create an instance of the ExpressionEvaluator
            ExpressionEvaluator evaluator = new ExpressionEvaluator();
            String integralExpression = "integrate(" + expression + ", x)";
            String result = evaluator.evaluate(integralExpression).toString();
            outputArea.setText("Integral of " + expression + " is: " + result);
        } catch (Exception e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IntegralCalculator calculator = new IntegralCalculator();
            calculator.setVisible(true);
        });
    }
}