import java.awt.*;
import javax.swing.*;

public class Graphic extends JComponent {
    private int x;
    private int y;
    private int width;
    private int height;
    private int arcWidth;
    private int arcHeight;
    private int fontSize;
    private Color color;
    private String text;
    private String type;

    //Creats a roundRect graphics object
    public Graphic(int X, int Y, int W, int H, int arcW, int arcH, Color c, String Type) {
        x = X;
        y = Y;
        width = W;
        height = H;
        arcWidth = arcW;
        arcHeight = arcH;
        color = c;
        type = Type;

        setBounds(x,y,width,height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillRoundRect(0,0,width,height,arcWidth,arcHeight);
        g2.dispose();
    }
}
