import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Components {
    public static void StartScreen(JFrame gui) {
        JPanel panel;
        JButton reportButton, viewReportButton;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        reportButton = new JButton("Report Issue");
        reportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportButton.addActionListener(onClick -> {
            gui.remove(panel);
            reportScreen(gui);
            gui.revalidate();
        });
        panel.add(reportButton);

        
        viewReportButton = new JButton("View Report");
        viewReportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewReportButton.addActionListener(onClick -> {
            gui.remove(panel);
            viewReportScreen(gui);
            gui.revalidate();
        });
        panel.add(viewReportButton);

        gui.setContentPane(panel);
    }

    private static void reportScreen(JFrame gui) {
        
        JPanel panel;
        
        panel = new JPanel();

        gui.setContentPane(panel);
    }

    public static void viewReportScreen(JFrame gui) {
        JPanel panel;

        panel = new JPanel();

        gui.setContentPane(panel);
    }
}
