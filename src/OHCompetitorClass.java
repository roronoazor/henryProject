import java.util.HashMap;

abstract class OHCompetitorClass {

    private String competitorNumber;
    private Name competitorName;
    private int age;
    private double height;
    private double weight;
    private String country;
    private int level;                      // group stage - 1, quarter final - 2, semifinal - 3, final - 4
    private int[] scores;
    // array
    private String competitorEmail;

    public OHCompetitorClass(              // declare3 the parameters
         Name competitorName,
         String competitorEmail,
         int age,
         double height,
         double weight,
         String country,
         int level,
         int[] scores
    ){
        // bind the parameters of the constructor to the instance variables of the class
        this.competitorName = competitorName;
        this.age = age;
        this.height = height; // measured in cm
        this.weight = weight; // measured in kg
        this.country = country;
        this.level = level;
        this.competitorEmail = competitorEmail;
        this.scores = scores;
    }

    // getters
    public String getCompetitorName() {
        return this.competitorName.getFirstName() + " " + this.competitorName.getLastName();
    }

    public String getCompetitorEmail(){
        return this.competitorEmail;
    }

    public String getCompetitorNumber() {
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

    public String setCompetitorNumber(String newNumber) {
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

    public int[] setScores(int[] scores){
        this.scores = scores;
        return this.scores;
    }

    abstract float getOverallScore();

    abstract String getCategory();

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
        String competitorNumber = this.getCompetitorNumber();
        int age = this.getAge();
        double height = this.getHeight();
        double weight = this.getWeight();
        String country = this.getCountry();
        String level = this.getLevelString();
        String category = this.getCategory();

        // use the variable to format the text
        String fullDetails = String.format(
                "Competitor Number: %s, Competitor Name: %s, Age: %d," +
                        "Height: %.2f (cm), Weight: %.2f (kg), Country: %s, level: %s, Category: %s " +
                        "and received these scores: %s, which gives him an overall score of %.2f",
                competitorNumber, competitorName, age, height, weight, country,
                level, category, this.convertStringArrayToString(this.getScoreArray(), ","), this.getOverallScore()
        );

        // return full Details
        return fullDetails;
    }


    public String getShortDetails() {

        // get the values that will make the short details text
        String competitorName = this.getCompetitorName();
        String competitorNumber = this.getCompetitorNumber();
        float overallScore = this.getOverallScore();

        // format the string with required values
        String shortDetails =  String.format(
                "CN %s (%s) has overall score %.2f",
                competitorNumber, competitorName, overallScore
        );

        // return the text
        return shortDetails;
    }


    public String getLevelString(){

        if (this.level <= 1){
            return "Beginner";
        }else if (this.level == 2){
            return "Amateur";
        }else {
            return "Expert";
        }
    }



    public String getScoresString(){
        return (
                this.scores[0] + ", " +
                this.scores[1] + ", " +
                this.scores[2] + ", " +
                this.scores[3] + ", " +
                this.scores[4] + ", "
                );
    }

}
