import java.text.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class CompetitorList {

    private ArrayList<OHCompetitorClass> competitors;

    public CompetitorList(ArrayList<OHCompetitorClass> listOfCompetitors){
        this.competitors = listOfCompetitors;    
    }

    public String getHighestScoredCompetitor(){

        float highestScore = (this.competitors.get(0)).getOverallScore();
        String competitorName = (this.competitors.get(0)).getCompetitorName();

        for ( OHCompetitorClass competitor : this.competitors ){

            if (competitor.getOverallScore() > highestScore){
             highestScore = competitor.getOverallScore();
             competitorName = competitor.getCompetitorName();
            }
        }
        String header = "#####################################################\n";
        String body = "The Competitor with the highest score was " + competitorName + " with a score of " + highestScore + "\n";
        String footer = "#####################################################\n";

        return (header + body + footer);
    }

    public String getCompetitorsFullList(){
        String header = "################## COMPETITORS LIST ########################\n";
        StringBuilder body = new StringBuilder();

        for ( OHCompetitorClass competitor:
                this.competitors) {
            body.append(competitor.getFullDetails() + "\n");
        }

        String footer = "############################################################\n";
        return (header + body + footer);
    }

    public ArrayList<OHCompetitorClass> addCompetitor(
            String firstName,
            String lastName,
            String competitorEmail,
            String category,
            String dob,
            String height,
            String weight,
            String country,
            String level
    ){

        int[] scores = {0,0,0,0,0};
        Name name = new Name(firstName, lastName);
        // at this point, this data has already been cleaned
        // convert the data to the valid
        // data types
        OHRunnerCompetitorClass competitor = new OHRunnerCompetitorClass(
                name,
                competitorEmail,
                12,
                23.1,
                12.3,
                "Nigeria",
                2,
                scores
        );
        if (category.equalsIgnoreCase("running")){

        }else if (category.equalsIgnoreCase("swimming")){

        }else {

        }
        System.out.println("firing");
        this.competitors.add(competitor);
        return this.competitors;
    }

    public float[] getCompetitorsScores() {
        float[] scores = new float[this.competitors.size()];

        for (int i = 0; i < this.competitors.size(); i++){
             scores[i] = this.competitors.get(i).getOverallScore();
        };

        return scores;
    }

    public String getStatisticsReport(){

        // this function loop through the overall scores of each competitor
        // and extract statistics such as (max, min, avg)
        float[] scores = getCompetitorsScores();

        StringBuilder body = new StringBuilder();

        // sorts the array from the smallest to largest //
        Arrays.sort(scores);
        float max = scores[scores.length - 1];
        float min = scores[0];

        String statisticTitle = "Competitors Statistic Report\n";
        String underlineHighlight = "#######################################\n";
        String maxScoreString = "Max Score is : " + Float.toString(max) + "\n";
        String minScoreString = "Min Score is : " + Float.toString(min) + "\n";

        float sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        float average = sum / scores.length;
        String averageString = "Average score is : " + Float.toString(average) + "\n";
        return (
                statisticTitle + underlineHighlight + maxScoreString + minScoreString + averageString
        );
    }
    
    public void getCompetitorsReport(){
        try {
            FileWriter fileReport = new FileWriter("src/report.txt");
            fileReport.write(this.getCompetitorsFullList());
            fileReport.write(this.getStatisticsReport());
            fileReport.write(this.getHighestScoredCompetitor());
            fileReport.close();
            this.getStatisticsReport();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void findByCompetitorNumber(String competitorNumber){
     boolean found = false;
     String details = "";

        for ( OHCompetitorClass competitor:
                this.competitors) {
            if (Integer.toString(competitor.getCompetitorNumber()).equals(competitorNumber)){
                found = true;
                details = competitor.getShortDetails();
                break;
            }
        }

        if (found){
            System.out.println("###############################################");
            System.out.println(details);
            System.out.println("################################################");
        }

         if (!found){
             System.out.println("competitor with number " + competitorNumber + " not found");
         }
    }


    public String validate(
            String name,
            String email,
            String dob,
            String category,
            String level,
            String height,
            String weight
    ){
        // validates the input data and returns a string
        // containing validation information if it fails
        // else it returns an empty string

        if (name.equalsIgnoreCase("")){
            return "Competitor Name is required";
        }

        if (!(name.split(" ").length == 2)){
            return "Please enter name in format 'lastName firstName'";
        }

        if (email.equalsIgnoreCase("")){
            return "Competitor Email is required";
        }

        if (dob.equalsIgnoreCase("")){
            return "Date of birth is required";
        }

        if (category.equalsIgnoreCase("")){
            return "Category is required";
        }

        if (level.equalsIgnoreCase("")){
            return "Level is required";
        }

        if (height.equalsIgnoreCase("")){
            return "Height is required";
        }

        if (weight.equalsIgnoreCase("")){
            return "Weight is required";
        }

        try{
            Float.parseFloat(height);
        }catch(NumberFormatException ex){
            return "Please enter a valid number or float for height";
        }

        try{
            Float.parseFloat(weight);
        }catch(NumberFormatException ex){
            return "Please enter a valid number or float for weight";
        }

        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(dob);

        }catch(ParseException ex){
            return "Please enter a valid date in the format YYYY-MM-DD e.g. 2020-01-31";
        }

        // check if the user email already exist
        Boolean doesEmailExist = this.validateCompetitorEmail(email);

        if (doesEmailExist){
            return "This competitor email already exists\n";
        }

        return "";
    }

    public Boolean validateCompetitorEmail(String email){

        Boolean found = false;

        for ( OHCompetitorClass competitor : this.competitors ){

            if (email.equalsIgnoreCase(competitor.getCompetitorEmail())){
                found = true;
                break;
            }
        }

        return found;
    }

}
