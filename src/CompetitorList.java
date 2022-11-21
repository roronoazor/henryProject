import java.text.*;
import java.time.LocalDate;
import java.time.Period;
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

    public int getAgeFromDobString(String dateOfString){
        LocalDate dob = LocalDate.parse(dateOfString);
        LocalDate curDate = LocalDate.now();
        return Period.between(dob, curDate).getYears();
    }

    public String generateCompetitorNumber(OHCompetitorClass competitor){

        // format used
        // YYYY/category/serialNumber

        // this allows for a million competitors with unique serialNumber
        String serialNumber = String.format("%06d", (this.competitors.size() + 1));
        String category = competitor.getCategory();
        String categoryCode = "";

        if (category.equalsIgnoreCase("running")){
            categoryCode = "101";
        }else if (category.equalsIgnoreCase("swimming")){
            categoryCode = "102";

        }else{
            categoryCode = "103";
        }

        return "2022/" + categoryCode + "/" + serialNumber;
    }

    public String addCompetitor(
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
        Double vHeight = Double.parseDouble(height);
        Double vWeight = Double.parseDouble(weight);
        int vAge = this.getAgeFromDobString(dob);

        OHCompetitorClass competitor;

        // at this point, this data has already been cleaned
        // convert the data to the valid
        // data types
        if (category.equalsIgnoreCase("running")){
            competitor = new OHRunnerCompetitorClass(
                    name,
                    competitorEmail,
                    vAge,
                    vHeight,
                    vWeight,
                    "",
                    2,
                    scores
            );
        }else if (category.equalsIgnoreCase("swimming")){
            competitor = new OHSwimmerCompetitorClass(
                    name,
                    competitorEmail,
                    vAge,
                    vHeight,
                    vWeight,
                    "",
                    2,
                    scores
            );
        }else {
            competitor = new OHJumperCompetitorClass(
                    name,
                    competitorEmail,
                    vAge,
                    vHeight,
                    vWeight,
                    "",
                    2,
                    scores
            );
        }
        String competitorNumber = this.generateCompetitorNumber(competitor);
        competitor.setCompetitorNumber(competitorNumber);

        this.competitors.add(competitor);
        return "Success!!! The competitor's number is: " + competitor.getCompetitorNumber()+ " please note it down";
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

    public OHCompetitorClass findByCompetitorNumber(String competitorNumber){
     boolean found = false;
     String details = "";
     OHCompetitorClass competitorObject = null;

        for ( OHCompetitorClass competitor:
                this.competitors) {
            if (competitor.getCompetitorNumber().equals(competitorNumber)){
                found = true;
                details = competitor.getShortDetails();
                competitorObject = competitor;
                System.out.println("this was found");
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
         return competitorObject;
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
            Double.parseDouble(height);
        }catch(NumberFormatException ex){
            return "Please enter a valid number or double for height";
        }

        try{
            Double.parseDouble(weight);
        }catch(NumberFormatException ex){
            return "Please enter a valid number or double for weight";
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
