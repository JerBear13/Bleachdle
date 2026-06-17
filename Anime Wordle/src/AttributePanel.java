import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.ArrayList;
public class AttributePanel extends JPanel {

    Graphic Bar = new Graphic(5, 50, 1425, 40, 20, 20, Color.WHITE, "roundRect");

    //used to store all RoundRects that need to be drawn
    ArrayList<RoundRectangle2D> shapes = new ArrayList<>(); 

    //used to store all the colors of each RoundRect 
    ArrayList<Color> colors = new ArrayList<>(); 

    //used to store the value of all the strings used for each box
    ArrayList<String> attributes = new ArrayList<>();

    //used to store all Text objects that hold the drawString perameters
    ArrayList<Text> texts = new ArrayList<>();

    //used to store Y poitons for new boxes to be added at
    int attributesY;

    //used to controll when to add new attributes.
    boolean addRow = false;

    public AttributePanel() {
        setBackground(Color.lightGray);
        setLayout(null);
        setHeaders();
        add(Bar);
    }

    public void setAddRow(boolean r) {
         addRow = r;
    }

    //used to add Values to texts
    // 18 for affiliation
    // 105 for 1 
    // 100 115 for 2
    // 90 105 120 for 3
    // 85 100 115 130 for 4
    public void setAttributes(ArrayList<String> peram) {
        for(int i = 0; i < peram.size(); i++) {
            String[] words = peram.get(i).split(" ");

            if(i == 0) {

            } else if(i == 1) {
                System.out.println("name is being added to texts");
                System.out.println("number of words " + words.length);
                if(words.length == 1) texts.add(new Text(words[0],111,attributesY-50+105));
                else {
                    String lineToAdd = "";
                    String allLines = "";
                    for(int j = 0; j < words.length; j ++) {
                        String word = words[j];
                        System.out.println("Current Word " + word);
                        if(lineToAdd.length() + word.length() <= 13) {
                            lineToAdd += word + " ";
                            System.out.println("lineToAdd is " + lineToAdd);
                        } else {
                            allLines += lineToAdd + "=";
                            lineToAdd = word;
                            System.out.println("allLines is " + allLines);
                            System.out.println("lineToAdd is now " + lineToAdd);
                        }
                    }
                    if(!allLines.contains(lineToAdd)) allLines += lineToAdd + "=";
                    System.out.println("After loop allLines is " + allLines);

                    String[] lines = allLines.split("=");
                    System.out.println(lines.length);
                    if(lines.length == 1) {
                        texts.add(new Text(lines[0],111,attributesY-50+105));
                    } else if(lines.length == 2) {
                        texts.add(new Text(lines[0],111,attributesY-50+100));
                        texts.add(new Text(lines[1],111,attributesY-50+115));
                    } else if(lines.length == 3) {
                        texts.add(new Text(lines[0],111,attributesY-50+90));
                        texts.add(new Text(lines[1],111,attributesY-50+105));
                        texts.add(new Text(lines[2],111,attributesY-50+120));
                    } else if(lines.length == 4) {
                        texts.add(new Text(lines[0],111,attributesY-50+85));
                        texts.add(new Text(lines[1],111,attributesY-50+100));
                        texts.add(new Text(lines[2],111,attributesY-50+115));
                        texts.add(new Text(lines[3],111,attributesY-50+130));
                    }
                }
            } else if(i == 2) {
                texts.add(new Text(words[0], 245,attributesY-50+105));
            } else if(i == 3) {
                texts.add(new Text(peram.get(i), 350,attributesY-50+105));
            } else if(i == 4) {
                texts.add(new Text(peram.get(i), 455,attributesY-50+105));
            } else if(i == 5) {
                texts.add(new Text(peram.get(i), 560,attributesY-50+105));
            } else if(i == 6) {
                texts.add(new Text(peram.get(i), 665,attributesY-50+105));
            } else if(i == 7) {
                if(words.length == 1) texts.add(new Text(words[0],770,attributesY-50+105));
                else {
                    String lineToAdd = "";
                    String allLines = "";
                    for(int j = 0; j < words.length; j ++) {
                        String word = words[j];
                        if(lineToAdd.length() + word.length() <= 13) {
                            lineToAdd += word + " ";
                        } else {
                            allLines += lineToAdd + "=";
                            lineToAdd = word;
                        }
                    }
                    if(!allLines.contains(lineToAdd)) allLines += lineToAdd + "=";
                    String[] lines = allLines.split("=");
                    if(lines.length == 1) {
                        texts.add(new Text(lines[0],770,attributesY-50+105));
                    } else if(lines.length == 2) {
                        texts.add(new Text(lines[0],770,attributesY-50+100));
                        texts.add(new Text(lines[1],770,attributesY-50+115));
                    } else if(lines.length == 3) {
                        texts.add(new Text(lines[0],770,attributesY-50+90));
                        texts.add(new Text(lines[1],770,attributesY-50+105));
                        texts.add(new Text(lines[2],770,attributesY-50+120));
                    } 
                }
            } else if(i == 8) {
                if(words.length == 1) texts.add(new Text(words[0],931,attributesY-50+105));
                else {
                    String lineToAdd = "";
                    String allLines = "";
                    for(int j = 0; j < words.length; j ++) {
                        String word = words[j];
                        if(lineToAdd.length() + word.length() <= 13) {
                            lineToAdd += word + " ";
                        } else {
                            allLines += lineToAdd + "=";
                            lineToAdd = word;
                        }
                    }
                    if(!allLines.contains(lineToAdd)) allLines += lineToAdd + "=";
                    String[] lines = allLines.split("=");
                    if(lines.length == 1) {
                        texts.add(new Text(lines[0],931,attributesY-50+105));
                    } else if(lines.length == 2) {
                        texts.add(new Text(lines[0],931,attributesY-50+100));
                        texts.add(new Text(lines[1],931,attributesY-50+115));
                    } 
                }
            } else if(i == 9) {
                if(words.length == 1) texts.add(new Text(words[0],1061,attributesY-50+105));
                else {
                    String lineToAdd = "";
                    String allLines = "";
                    for(int j = 0; j < words.length; j++) {
                        String word = words[j];
                        System.out.println(word);
                        if(lineToAdd.length() + word.length() <= 17) {
                            lineToAdd += word + " ";
                        } else {
                            allLines += lineToAdd + "=";
                            lineToAdd = word + " ";
                        }
                    }
                    if(!allLines.contains(lineToAdd)) allLines += lineToAdd + "=";
                    String[] lines = allLines.split("=");
                    if(lines.length == 1) {
                        texts.add(new Text(lines[0],1061,attributesY-50+105));
                    } else if(lines.length == 2) {
                        texts.add(new Text(lines[0],1061,attributesY-50+100));
                        texts.add(new Text(lines[1],1061,attributesY-50+115));
                    } else if(lines.length == 3) {
                        texts.add(new Text(lines[0],1061,attributesY-50+90));
                        texts.add(new Text(lines[1],1061,attributesY-50+105));
                        texts.add(new Text(lines[2],1061,attributesY-50+120));
                    } 
                }
            } else if(i == 10) {
                texts.add(new Text(peram.get(i), 1230,attributesY-50+105));
            } else if(i == 11) {
                texts.add(new Text(peram.get(i), 1335,attributesY-50+105));
            }
        }
    }

    //ussed to add values to colors
    public void setColors(ArrayList<Color> peram) {
        for(Color c : peram) {
            colors.add(c);
        }
    }

    /* 
     * will update when new garpahics objects are added to the panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int i = 0;
        for(RoundRectangle2D shape : shapes) {
            if(colors.isEmpty()) g2.setColor(Color.WHITE);
            else g2.setColor(colors.get(i));
            g2.fill(shape);
            i++;
        }

        for(Text text : texts) {
            g2.setFont(new Font("Roboto", Font.PLAIN, 18));
            g2.setColor(Color.BLACK);
            g2.drawString(text.getText(), text.getX(), text.getY());
        }

        if(addRow == true) {
            addCharacter(g);
            Bar.setLocation(5, attributesY);
            addRow = false;
        }

        //g2.setFont(new Font("Roboto", Font.PLAIN, 18));
        //g2.setColor(Color.BLACK);
        //g2.drawString("Arrancar: Hueco Mundo Sneak Entry Arc", 1065, attributesY-155+105);

    }

    /*
     * Used to draw a new charecters attriubtes to boxes that store the result of comparing the guessed character
     * to the random one
     *   
     */
    public void addCharacter(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        shapes.add(new RoundRectangle2D.Double(5,attributesY,100,100,20,20)); // draws box for image
        shapes.add(new RoundRectangle2D.Double(110,attributesY,125,100,20,20)); // draws box for name
        shapes.add(new RoundRectangle2D.Double(240,attributesY,100,100,20,20)); // draws box for gender
        shapes.add(new RoundRectangle2D.Double(345,attributesY,100,100,20,20)); // draws box for race
        shapes.add(new RoundRectangle2D.Double(450,attributesY,100,100,20,20));// draws box for age
        shapes.add(new RoundRectangle2D.Double(555,attributesY,100,100,20,20));// draws box for hair
        shapes.add(new RoundRectangle2D.Double(660,attributesY,100,100,20,20)); // draws box for height
        shapes.add(new RoundRectangle2D.Double(765,attributesY,160,100,20,20));// draws box for affiliation
        shapes.add(new RoundRectangle2D.Double(930,attributesY,125,100,20,20));// draws box for origin
        shapes.add(new RoundRectangle2D.Double(1060,attributesY,160,100,20,20));// draws box for appearence
        shapes.add(new RoundRectangle2D.Double(1225,attributesY,100,100,20,20));// draws box for cannon
        shapes.add(new RoundRectangle2D.Double(1330,attributesY,100,100,20,20));// draws box for living

        attributesY +=105;
    }

    /*
     * Used to set up the column headers for each attribute for a charecter
     */
    public void setHeaders() {

        JLabel imageL = new JLabel("Image");
        imageL.setFont(new Font("Roboto", Font.PLAIN, 18));
        imageL.setForeground(Color.BLACK);
        imageL.setBounds(30,8,100,30);
        add(imageL);

        JLabel nameL = new JLabel("Name");
        nameL.setFont(new Font("Roboto", Font.PLAIN, 18));
        nameL.setForeground(Color.BLACK);
        nameL.setBounds(148,8,125,30);
        add(nameL);

        JLabel genderL = new JLabel("Gender");
        genderL.setFont(new Font("Roboto", Font.PLAIN, 18));
        genderL.setForeground(Color.BLACK);
        genderL.setBounds(259,8,75,30);
        add(genderL);

        JLabel raceL = new JLabel("Race");
        raceL.setFont(new Font("Roboto", Font.PLAIN, 18));
        raceL.setForeground(Color.BLACK);
        raceL.setBounds(373,8,100,30);
        add(raceL);

        JLabel ageL = new JLabel("Age");
        ageL.setFont(new Font("Roboto", Font.PLAIN, 18));
        ageL.setForeground(Color.BLACK);
        ageL.setBounds(483,8,100,30);
        add(ageL);

        JLabel hairL = new JLabel("Hair");
        hairL.setFont(new Font("Roboto", Font.PLAIN, 18));
        hairL.setForeground(Color.BLACK);
        hairL.setBounds(588,8,75,30);
        add(hairL);

        JLabel heightL = new JLabel("Height");
        heightL.setFont(new Font("Roboto", Font.PLAIN, 18));
        heightL.setForeground(Color.BLACK);
        heightL.setBounds(683,8,100,30);
        add(heightL);

        JLabel affL = new JLabel("Affiliation");
        affL.setFont(new Font("Roboto", Font.PLAIN, 18));
        affL.setForeground(Color.BLACK);
        affL.setBounds(810,8,160,30);
        add(affL);

        JLabel originL = new JLabel("Place of Origin");
        originL.setFont(new Font("Roboto", Font.PLAIN, 18));
        originL.setForeground(Color.BLACK);
        originL.setBounds(933,8,125,30);
        add(originL);

        JLabel appearL = new JLabel("First Appearence");
        appearL.setFont(new Font("Roboto", Font.PLAIN, 18));
        appearL.setForeground(Color.BLACK);
        appearL.setBounds(1071,8,160,30);
        add(appearL);

        JLabel cannonL = new JLabel("Cannon");
        cannonL.setFont(new Font("Roboto", Font.PLAIN, 18));
        cannonL.setForeground(Color.BLACK);
        cannonL.setBounds(1243,3,75,30);
        add(cannonL);

        JLabel cannon2L = new JLabel("Status");
        cannon2L.setFont(new Font("Roboto", Font.PLAIN, 18));
        cannon2L.setForeground(Color.BLACK);
        cannon2L.setBounds(1249,19,75,30);
        add(cannon2L);

        JLabel livingL = new JLabel("Living");
        livingL.setFont(new Font("Roboto", Font.PLAIN, 18));
        livingL.setForeground(Color.BLACK);
        livingL.setBounds(1357,3,75,30);
        add(livingL);

        JLabel living2L = new JLabel("Status");
        living2L.setFont(new Font("Roboto", Font.PLAIN, 18));
        living2L.setForeground(Color.BLACK);
        living2L.setBounds(1355,19,75,30);
        add(living2L);

        add(new Graphic(5, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Image
        add(new Graphic(110, 5, 125, 40, 20, 20, Color.WHITE, "roundRect")); // Name
        add(new Graphic(240, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Gender
        add(new Graphic(345, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Race
        add(new Graphic(450, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Age
        add(new Graphic(555, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Hair
        add(new Graphic(660, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Height
        add(new Graphic(765, 5, 160, 40, 20, 20, Color.WHITE, "roundRect")); // Affiliation
        add(new Graphic(930, 5, 125, 40, 20, 20, Color.WHITE, "roundRect")); // Origin
        add(new Graphic(1060, 5, 160, 40, 20, 20, Color.WHITE, "roundRect")); // Appearence
        add(new Graphic(1225, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Cannon
        add(new Graphic(1330, 5, 100, 40, 20, 20, Color.WHITE, "roundRect")); // Living

        attributesY = 50;
    }

    /*
     * Will increase the size of the AttributePanel based on how many objects are on it.
     */
    @Override
    public Dimension getPreferredSize() {
        int maxX = 0;
        int maxY = 0;

        for (Component c : getComponents()) {
            int right  = c.getX() + c.getWidth();
            int bottom = c.getY() + c.getHeight();

            if (right  > maxX) maxX = right;
            if (bottom > maxY) maxY = bottom;
        }

        return new Dimension(maxX + 20, maxY + 20);
    }
}
