import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;
public class Main extends JFrame {

    public Main() throws IOException {
        add(new Window());

        setSize(1370,770);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws IOException {

        //Bleachdle test = new Bleachdle();
        //Scanner scan = new Scanner(System.in);
        //boolean isRunning = true;
        //BleachCharacter randomCharacter = test.generateCharacter();
        //while (isRunning) {
        //    System.out.println("Guess a Character");
        //    BleachCharacter guess = test.getCharacter(scan.nextLine());
        //    test.compareCharacters(guess, randomCharacter);
        //}

        new Main();
    }
}
