import javax.swing.*;
import java.awt.*;
import java.io.*;

public class DataViewer extends JFrame {
    private JTable dataTable;

    public DataViewer() {
        super("Data Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Title", "Description"};
        Object[][] data = readDataFromFile("data.txt");

        dataTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Object[][] readDataFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Count the number of lines in the file
            int numLines = 0;
            while (reader.readLine() != null) {
                numLines++;
            }
            reader.close();

            // Read the data into a 2D array
            Object[][] data = new Object[numLines][2];
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" , ");
                data[i][0] = parts[0];
                data[i][1] = parts[1];
                i++;
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}