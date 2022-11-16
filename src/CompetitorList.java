import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

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
}
