import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;
public class Bleachdle {

    File bleachdle = new File("src\\Bleachdle.csv");
    private BleachCharacter[] characterList = new BleachCharacter[179];

    public Bleachdle() throws IOException {
        readFile();
    }
    
    
    public void readFile() throws IOException {
        Scanner scan = new Scanner(bleachdle);
        int i = 0;
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String data[] = line.split(",");
            BleachCharacter character = new BleachCharacter(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12]);
            characterList[i] = character;
            i++;
        }
        scan.close();
    }

    //generates a random character
    public BleachCharacter generateCharacter() {
        Random ran = new Random();
        int index = ran.nextInt(178) + 1;
        return characterList[index];
    }

    //used to retrieve a character from characterList based on name 
    public BleachCharacter getCharacter(String name) {
        for(int i = 0; i < characterList.length; i++) {
            if(characterList[i].getName().equals(name)) return characterList[i];
        }

        return null;
    }

    /* 
     * used to get weather a guess character is the same as the randomly picked character and it will return
     * the color of what the result should be as either
     * red for wrong
     * yellow for within range 
     * green for correct
     */
    public ArrayList<Color> getCharacterColorComparison(BleachCharacter gCharacter, BleachCharacter rCharacter) {

        ArrayList<Color> results = new ArrayList<>();

        String gName = gCharacter.getName();
        String gGender = gCharacter.getGender();
        String gRace = gCharacter.getRace();
        int gAgeNum = gCharacter.getNumericAge();
        String gHairColor = gCharacter.getHairColor();
        String gHeight = gCharacter.getHeight();
        int gH1 = gCharacter.getH1();
        int gH2 = gCharacter.getH2();
        int rH1 = rCharacter.getH1();
        int rH2 = rCharacter.getH2();
        String gAffiliation = gCharacter.getAffiliation();
        String gLocation = gCharacter.getLocation();
        int gArcPos = gCharacter.getArcPosition();
        String gCanon = gCharacter.getCanon();
        String gStatus = gCharacter.getStatus();

        //image
        results.add(Color.WHITE);

        //Name
        if(gName.equals(rCharacter.getName())) results.add(Color.GREEN);
        else results.add(Color.RED);

        //Gender
        if(gGender.equals(rCharacter.getGender())) results.add(Color.GREEN);
        else results.add(Color.RED);

        //Race
        if(gRace.equals(rCharacter.getRace())) results.add(Color.GREEN);
        else results.add(Color.RED);

        //Age
        if(gAgeNum < rCharacter.getNumericAge()) results.add(Color.RED);
        else if(gAgeNum > rCharacter.getNumericAge()) results.add(Color.RED);
        else results.add(Color.GREEN);

        //Hair Color
        if(gHairColor.equals(rCharacter.getHairColor())) results.add(Color.GREEN);
        else results.add(Color.RED);

        //Height
        if(rH1 == 0 && rH2 == 0) { //r is Uknown
            if(gHeight.equals(rCharacter.getHeight())) results.add(Color.GREEN);
            else results.add(Color.RED);
        } else if(rH1 != rH2) { //r is a range
            if(rH1 > gH1) results.add(Color.RED);
            else if(rH2 < gH2) results.add(Color.RED);
            else if(rH1 < gH1 && rH2 > gH2) results.add(Color.YELLOW);
            else results.add(Color.GREEN);
        } else {// r is single
            if(gH1 < rH1 && gH2 > rH2) results.add(Color.YELLOW);
            else if(rH1 > gH1) results.add(Color.RED);
            else if(rH2 < gH2) results.add(Color.RED);
            else results.add(Color.GREEN);
        }

        //Affiliation
        if(gAffiliation.equals(rCharacter.getAffiliation())) results.add(Color.GREEN);
        else results.add(Color.RED);

        //Location
        if(gLocation.equals(rCharacter.getLocation())) results.add(Color.GREEN);
        else results.add(Color.RED);

        //Arc
        if(gArcPos < rCharacter.getArcPosition()) results.add(Color.RED);
        else if(gArcPos > rCharacter.getArcPosition()) results.add(Color.RED);
        else  results.add(Color.GREEN);

        //Canon
        if(gCanon.equals(rCharacter.getCanon())) results.add(Color.GREEN);
        else results.add(Color.RED);

        //Status
        if(gStatus.equals(rCharacter.getStatus())) results.add(Color.GREEN);
        else results.add(Color.RED);

        return results;
    }

    /*
     * used to get weather a guess character is the same as the randomly picked character and it will return
     * its attributes as strings and will use arrows to specify if the value is lower or higher then the guessed value
     */
    public ArrayList<String> getCharacterStringComparison(BleachCharacter gCharacter, BleachCharacter rCharacter) {

        ArrayList<String> results = new ArrayList<>();

        int gAgeNum = gCharacter.getNumericAge();
        String gHeight = gCharacter.getHeight();
        int gH1 = gCharacter.getH1();
        int gH2 = gCharacter.getH2();
        int rH1 = rCharacter.getH1();
        int rH2 = rCharacter.getH2();
        int gArcPos = gCharacter.getArcPosition();

        results.add(gCharacter.getImage());
        results.add(gCharacter.getName());
        results.add(gCharacter.getGender());
        results.add(gCharacter.getRace());
        if(gAgeNum < rCharacter.getNumericAge()) results.add(gCharacter.getAge() + " ▲");
        else if(gAgeNum > rCharacter.getNumericAge()) results.add(gCharacter.getAge() + " ▼");
        else results.add(gCharacter.getAge());
        results.add(gCharacter.getHairColor());
        if(rH1 == 0 && rH2 == 0) { //r is Uknown
            if(gHeight.equals(rCharacter.getHeight())) results.add(gCharacter.getHeight());
            else results.add(gCharacter.getHeight() + " ▲");
        } else if(rH1 != rH2) { //r is a range
            if(rH1 > gH1) results.add(gCharacter.getHeight() + " ▲");
            else if(rH2 < gH2) results.add(gCharacter.getHeight() + " ▼");
            else results.add(gCharacter.getHeight());
        } else {// r is single
            if(rH1 > gH1) results.add(gCharacter.getHeight() + " ▲");
            else if(rH2 < gH2) results.add(gCharacter.getHeight() + " ▼");
            else results.add(gCharacter.getHeight());
        }
        results.add(gCharacter.getAffiliation());
        results.add(gCharacter.getLocation());
        if(gArcPos < rCharacter.getArcPosition()) results.add(gCharacter.getFirstArc() + " ▲");
        else if(gArcPos > rCharacter.getArcPosition()) results.add(gCharacter.getFirstArc() + " ▼");
        else  results.add(gCharacter.getFirstArc());
        results.add(gCharacter.getCanon());
        results.add(gCharacter.getStatus());

        return results;
    }

    public List<String> getAllNames() {
        List<String> names = new ArrayList<>();
        for (BleachCharacter c : characterList) {
            if (c != null) {
                names.add(c.getName());
            }
        }
        return names;
    }


    
}
