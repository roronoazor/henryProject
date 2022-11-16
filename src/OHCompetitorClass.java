import java.util.HashMap;

public class OHCompetitorClass {

    private int competitorNumber;               // competitors ID e.g. 101
    private Name competitorName;
    private int age;
    private double height;
    private double weight;
    private String country;
    private int level;                      // group stage - 1, quarter final - 2, semifinal - 3, final - 4
    private int[] scores;                   // array

    public OHCompetitorClass(              // declare3 the parameters
         Name competitorName,
         int competitorNumber,
         int age,
         double height,
         double weight,
         String country,
         int level,
         int[] scores
    ){
        // bind the parameters of the constructor to the instance variables of the class
        this.competitorName = competitorName;
        this.competitorNumber = competitorNumber;
        this.age = age;
        this.height = height; // measured in cm
        this.weight = weight; // measured in kg
        this.country = country;
        this.level = level;
        this.scores = scores;
    }

    // getters
    public String getCompetitorName() {
        return this.competitorName.getFirstName() + " " + this.competitorName.getLastName();
    }

    public int getCompetitorNumber() {
        return this.competitorNumber;
    }

    public int getAge() {
        return this.age;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight () {
        return this.weight;
    }

    public String getCountry () {
        return this.country;
    }

    public int getLevel () {
        return this.level;
    }

    public int[] getScoreArray() {
        return this.scores;
    }


    //setters
    public Name setCompetitorName(Name newName) {
        this.competitorName = newName;
        return this.competitorName;
    }

    public int setCompetitorNumber(int newNumber) {
        this.competitorNumber = newNumber;
        return this.competitorNumber;
    }

    public int setAge(int newAge) {
        this.age = newAge;
        return this.age;
    }

    public double setHeight(double newHeight) {
        this.height = newHeight;
        return this.height;
    }

    public double setWeight(double newWeight) {
        this.weight = newWeight;
        return this.weight;
    }

    // enter only a valied country name but this can accept any string values
    public String setCountry(String newCountry){
        this.country = newCountry;
        return this.country;
    }

    public int setLevel (int newLevel) {
        this.level = newLevel;
        return this.level;
    }

    public float getOverallScore(){
        // ****************
        // weighted points for each level:-
        // level 1 - 1 point
        // level 2 - 3 points
        // level 3 - 5 points
        // level 4 - 10 points
        // ***************
        // To calculate the average score:
        // 1. get the competitor level
        // 2. loop through the scores array
        // 3. for each score in the scores array multiply it by the corresponding weighted points for that level
        // 4. add it to sum
        // 5. divide the total sum by 5
        // 6. scale the result to 5
        //*******************
        int sum = 0;
        int level = this.getLevel();

        int scaleX = 1;
        if (level == 2) scaleX = 3;
        if (level == 3) scaleX = 5;
        if (level == 4) scaleX = 10;

        int[] scores = this.getScoreArray();
        for(int i = 0 ; i < this.getScoreArray().length; i++){
            switch (level) {
                case 1 -> sum += (scores[i]);
                case 2 -> sum += (scores[i] * 3);
                case 3 -> sum += (scores[i] * 5);
                case 4 -> sum += (scores[i] * 10);
                default -> {
                    continue;
                }
            }
        }

        float sumScore = (float)sum;
        return (sumScore / (25 * scaleX)) * 5;
    }

    // Using StringBuilder to convert the String array to String and delimiter to separate the arrays
    public String convertStringArrayToString(int[] strArr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int n : strArr)
            sb.append(Integer.toString(n)).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }

    public String getFullDetails() {

        // get all the values of the competitor class,
        // and store them in local variables
        String competitorName = this.getCompetitorName();
        int competitorNumber = this.getCompetitorNumber();
        int age = this.getAge();
        double height = this.getHeight();
        double weight = this.getWeight();
        String country = this.getCountry();
        int level = this.getLevel();

        // use the variable to format the text
        String fullDetails = String.format(
                "Competitor Number: %d, Competitor Name: %s, Age: %d," +
                        "Height: %.2f (cm), Weight: %.2f (kg), Country: %s, level: %d, " +
                        "and received these scores: %s, which gives him an overall score of %.2f",
                competitorNumber, competitorName, age, height, weight, country,
                level, this.convertStringArrayToString(this.getScoreArray(), ","), this.getOverallScore()
        );

        // return full Details
        return fullDetails;
    }


    public String getShortDetails() {

        // get the values that will make the short details text
        String competitorName = this.getCompetitorName();
        int competitorNumber = this.getCompetitorNumber();
        float overallScore = this.getOverallScore();

        // format the string with required values
        String shortDetails =  String.format(
                "CN %d (%s) has overall score %.2f",
                competitorNumber, competitorName, overallScore
        );

        // return the text
        return shortDetails;
    }

}
