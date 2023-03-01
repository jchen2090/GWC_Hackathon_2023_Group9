import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GUI extends JFrame {
    public GUI() {
        // Set up the main frame
        setTitle("Start Screen");
        setSize(800, 600);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the button
        JButton button = new JButton("Switch to Screen 2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the second screen
                dispose(); // Close the main frame
                new ReportScreen().setVisible(true); // Open the second frame
            }
        });
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        JButton button2 = new JButton("Switch to Screen 3");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the third screen
                dispose(); // Close the main frame
                new ViewReportScreen().setVisible(true); // Open the third frame
            }
        });
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);

        // Add the buttons to the main frame
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button2);
        getContentPane().add(panel);
    }

}

class ReportScreen extends JFrame {
    private JPanel panel;
    JTextField titleField;
    JTextArea descField;
    JButton submitButton, backButton;
    
    public ReportScreen() {
        // Set up the second frame
        setTitle("Report Screen");
        setSize(800, 600);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        this.panel = new JPanel(null);
        setupPanel();
        getContentPane().add(panel);
    }

    private void setupPanel() {
        backButton = new JButton("Back");
        backButton.setBounds(0, 0, 80, 25);
        backButton.addActionListener(onClick -> {
            dispose();
            new GUI().setVisible(true);
        });
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        panel.add(backButton);

        titleField = new JTextField(10);
        titleField.setBounds(20, 50, 740, 35);
        titleField.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(titleField);

        descField = new JTextArea();
        descField.setBounds(20, 110, 740, 300);
        panel.add(descField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(280, 450, 200, 35);
        submitButton.setFocusPainted(false);
        submitButton.setContentAreaFilled(false);
        submitButton.addActionListener(onClick -> {
            String title = titleField.getText();
            String description = descField.getText();
            
            saveData(title, description);

            titleField.setText("");
            descField.setText("");
        });
        panel.add(submitButton);
    }

    private void saveData(String title, String description) {
        FileWriter dataFile;

        try {
            dataFile = new FileWriter("data.txt");

            BufferedWriter writer = new BufferedWriter(dataFile);
            writer.write(title + " | " + description);

            writer.close();
        }
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}

class ViewReportScreen extends JFrame {
    private JTable table;
    JPanel panel = new JPanel();
    
    public ViewReportScreen() {

        // Set up the third frame
        setTitle("View Reports Screen");
        setSize(800, 800);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Data Viewer");
        setSize(800, 800);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Read data from file and add to table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("title");
        tableModel.addColumn("decription ");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                tableModel.addRow(parts);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create the table and add to main frame
        table = new JTable(tableModel);
        JButton button = new JButton("Switch to Main Screen");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the main screen
                dispose(); // Close the second frame
                new GUI().setVisible(true); // Open the main frame
            }
        });
        
        panel.add(button);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        getContentPane().add(panel);
    }
}

