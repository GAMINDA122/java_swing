import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JLabel celsiusLabel, fahrenheitLabel;
    private JTextField celsiusField, fahrenheitField;
    private JButton convertButton;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        celsiusLabel = new JLabel("Celsius: ");
        celsiusField = new JTextField();
        fahrenheitLabel = new JLabel("Fahrenheit: ");
        fahrenheitField = new JTextField();
        fahrenheitField.setEditable(false);

        convertButton = new JButton("Convert");

        panel.add(celsiusLabel);
        panel.add(celsiusField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitField);
        panel.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    Temperature temperature = new Temperature(celsius);
                    double fahrenheit = temperature.toFahrenheit();
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for Celsius.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverterGUI();
            }
        });
    }
}

class Temperature {
    private double celsius;

    // No-Arg Constructor
    public Temperature() {
        this.celsius = 0.0;
    }

    // Parameterized Constructor
    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    // Getter for Fahrenheit
    public double toFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    // Getter for Celsius
    public double toCelsius() {
        return celsius;
    }

    // Setter for Fahrenheit
    public void setFahrenheit(double fahrenheit) {
        celsius = (fahrenheit - 32) * 5 / 9;
    }

    // Setter for Celsius
    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
}

