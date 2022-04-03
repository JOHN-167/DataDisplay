import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;
import java.util.*; import java.util.List;
public class DataFrame extends JFrame{
    final static int BarGraph = 1;
    final static int PieChart = 2;
    final static int LineGraph = 3;
    public DataFrame (String[] attributes, int[] values, char colorScheme, int graphType) {
        setSize(new Dimension(600,480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Canvas(attributes, values, colorScheme, graphType));
    }
    public static void main (String[] args){
        char colorScheme = 'g'; //r = red, g = green, b = blue
        int[] values = new int[]{15,28,12,17}; //list the values to be graphed (int/double)
        String[] attributes = new String[]{
            "Demo Graph", //title
            "X-Axis", //label for x-axis
            "Y-Axis"}; //label for y-axis
        DataFrame theFrame = new DataFrame(attributes, values, colorScheme, BarGraph);
        theFrame.setVisible(true);
    } 
}
class Canvas extends JPanel {
    Canvas (String[] attributes, int[] values, char colorScheme, int graphType) {
        setBackground(new Color(240,240,240));
        setLayout(new BorderLayout(10,10));
        JLabel title = new JLabel(attributes[0]);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);
        add(new JLabel(attributes[2]), BorderLayout.WEST);
        switch (graphType) {
            case 1:
                add(new BarGraph(values, colorScheme), BorderLayout.CENTER);
                break;
        }
        JLabel labelX = new JLabel(attributes[1]);
        labelX.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelX, BorderLayout.SOUTH);
    }
}