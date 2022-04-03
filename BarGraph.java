import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;
import java.util.*; import java.util.List;
public class BarGraph extends JComponent{
    int[] attributes = new int[3]; //maxIndex, width, height
    double[] values; char color; Dimension bounds; Random rnd = new Random();
    public BarGraph (int[] values, char colorScheme) {
        this.values = new double[values.length];
        double max = 0;
        for (int i = 0; i < values.length; i++){
            this.values[i] = (double) values[i];
            max = Math.max(max,this.values[i]);
            attributes[0] = (max == this.values[i])? i : attributes[0];
        }
        this.color = colorScheme;
    }
    public BarGraph (double[] values, char colorScheme) {
        this.values = new double[values.length];
        double max = 0;
        for (int i = 0; i < values.length; i++){
            this.values[i] = values[i];
            max = Math.max(max,this.values[i]);
            attributes[0] = (max == this.values[i])? i : attributes[0];
        }
        this.color = colorScheme;
    }
    public BarGraph (List<Integer> values, char colorScheme) {
        this.values = new double[values.size()];
        double max = 0;
        for (int i = 0; i < this.values.length; i++){
            this.values[i] = (double) values.get(i);
            max = Math.max(max,this.values[i]);
            attributes[0] = (max == this.values[i])? i : attributes[0];
        }
        this.color = colorScheme;
    }
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        attributes[1] = getBounds().width;
        attributes[2] = getBounds().height;
        int incX = (int) (attributes[1]/this.values.length);
        int incY = (int) (attributes[2]/this.values[this.attributes[0]]);
        for (int i = 0; i < this.values.length; i++){
            g.setColor(new Color((color=='r')?255:190,
                        (color=='g')?255:190,(color=='b')?255:190));
            g.fillRect(i*incX,(int)(attributes[2]-this.values[i]*incY),incX,(int)this.values[i]*incY);
            g.setColor(Color.BLACK);
            g.drawRect(i*incX,(int)(attributes[2]-this.values[i]*incY),incX,(int)this.values[i]*incY);
        }
    }
}
