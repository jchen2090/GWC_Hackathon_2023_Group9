import javax.swing.JFrame;

public class GUI extends JFrame {
    public GUI() {
        // Finalize name later
        super("Temporary Name");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
