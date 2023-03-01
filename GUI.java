import javax.swing.*;
import java.awt.event.*;
public class GUI extends JFrame {
    public GUI() {
        // Set up the main frame
        setTitle("Button Example");
        setSize(300, 200);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the button
        JButton button = new JButton("Switch to Screen 2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the second screen
                dispose(); // Close the main frame
                new SecondFrame().setVisible(true); // Open the second frame
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




class SecondFrame extends JFrame {
    public SecondFrame() {
        // Set up the second frame
        setTitle("Second Screen");
        setSize(300, 200);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a label to the second frame
        JLabel label = new JLabel("You have switched to the second screen.");
        getContentPane().add(label);
    }
}
    class ThirdFrame extends JFrame {
        public ThirdFrame() {
            // Set up the third frame
            setTitle("Third Screen");
            setSize(300, 200);
            setLocationRelativeTo(null); // Center on screen
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Add a label to the third frame
            JLabel label = new JLabel("You have switched to the third screen.");
            getContentPane().add(label);
        }
    }

