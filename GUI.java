import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GUI extends JFrame {
    public GUI() {
        // Set up the main frame
        setTitle("Button Example");
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
        JButton button2 = new JButton("Switch to Screen 3");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the third screen
                dispose(); // Close the main frame
                new ThirdFrame().setVisible(true); // Open the third frame
            }
        });

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
        setTitle("Second Screen");
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

class ThirdFrame extends JFrame {
    public ThirdFrame() {
        // Set up the third frame
        setTitle("Third Screen");
        setSize(800, 600);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add a label to the third frame
        JLabel label = new JLabel("You have switched to the third screen.");
        getContentPane().add(label);
    }
}

