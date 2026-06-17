public class BleachCharacter {

    private String name;
    private String gender;
    private String race;
    private String age;
    private String hairColor;
    private String height;
    private int h1;
    private int h2;
    private String affiliation;
    private String location;
    private String firstArc;
    private String canon;
    private String status;
    private String difficulty;
    private String Image;

    /* 
     * Will create a charecter and assign their attributes to them which can be retrieved 
     * when needed.
     * 
     */
    public BleachCharacter (String n, String g, String r, String a, String hc, String h, String af, String l, String f, String c, String s, String d, String i) {
        name = n;
        gender = g;
        race = r;
        if(a.equals("001-20")) age = "1-20";
        else age = a;
        hairColor = hc;
        height = h;
        setH1H2();
        affiliation = af;
        location = l;
        firstArc = f;
        canon = c;
        status = s;
        difficulty = d;
        Image = i;
    }

    //gets name
    public String getName() {
        return name;
    }

    //gets gender
    public String getGender() {
        return gender;
    }

    //gets race
    public String getRace() {
        return race;
    }

    //gets age
    public String getAge() {
        return age;
    }

    //gets age and returns a numeric value representing the group that the age is in 
    public int getNumericAge() {
        switch (age) {
            case "1-20": return 20;
            case "21-40": return 40;
            case "41-60": return 60;
            case "61-100": return 100;
            case "100-1000": return 1000;
            case "1000+": return 1001;
            case "1000000+": return 1000000;
            default: return 0;
        }
    }

    //gets hair color
    public String getHairColor() {
        return hairColor;
    }

    //gets height
    public String getHeight() {
        return height;
    }

    //sets h1 and h2 as an int , if its a range then it will grab the max and min and set h1 nad h2 to them,
    // if the height is Unknown then the h1 and h2 will equal 0, otherwise h1 and h2 will be set to the same value
    public void setH1H2() {
        String[] heights = height.split("-");

        if(heights.length > 1) { /* for range of heights */
            try {
                h1 = Integer.parseInt(heights[0]);
                h2 = Integer.parseInt(heights[1]);
            } catch (NumberFormatException e) {

            }
        } else if(!heights[0].equals("Unknown")) { /* for single height */
            try {
                h1 = Integer.parseInt(heights[0]);
                h2 = Integer.parseInt(heights[0]);
            } catch (NumberFormatException e) {

            }
        } else { /* for if height is Unkown */
            h1 = 0;
            h2 = 0;
        }
    }

    //gets h1
    public int getH1() {
        return h1;
    }

    //gets h2
    public int getH2() {
        return h2;
    }

    //gets affiliation
    public String getAffiliation() {
        return affiliation;
    }

    //gets location
    public String getLocation() {
        return location;
    }

    //gets frist arc
    public String getFirstArc() {
        return firstArc;
    }

    //retruns the arc as an int representing its value in chronological order
    public int getArcPosition() {
        switch (firstArc) {
            case "Agent of the Shinigami Arc": return 1;
            case "Soul Society: The Sneak Entry Arc": return 2;
            case "Soul Society: The Rescue Arc": return 3;
            case "Arrancar: The Arrival Arc": return 4;
            case "Arrancar: Hueco Mundo Sneak Entry Arc": return 5;
            case "Arrancar: The Fierce Fight Arc": return 6;
            case "The Lost Agent of The Shinigami Arc": return 7;
            case "The 1000 Year Blood War Arc": return 8;
            default: return 0;
        }
    }

    //gets weather the charecter is canon or not
    public String getCanon() {
        return canon;
    }

    //gets status of life
    public String getStatus() {
        return status;
    }

    //gets difficulty
    public String getDifficulty() {
        return difficulty;
    }

    //gets image
    public String getImage() {
        return Image;
    }

    //returns a string that holds all attributes of a character
    public String toString() {
        return "Name: " + name + "\nGender: " + gender + "\nRace: " + race + "\nAge: " + age +
        "\nHair Color: " + hairColor + "\nHeight: " + height + "\nAffiliation: " + affiliation + 
        "\nLocation: " + location + "\nFirst Appearence: " + firstArc + "\nCanoninity: " + canon +
        "\nStatus: " + status;
    }
}