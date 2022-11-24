import java.util.Arrays;

public class OHJumperCompetitorClass extends OHCompetitorClass {

    private String category = "jumping";

    public OHJumperCompetitorClass(
            Name competitorName,
            String competitorEmail,
            int age,
            double height,
            double weight,
            String country,
            int level,
            int[] scores
    ){
        // call the constructor of the parent class
        super(
            competitorName,
            competitorEmail,
            age,
            height,
            weight,
            country,
            level,
            scores
        );
    }

    public String getCategory(){
        return this.category;
    }

    public float getOverallScore(){

        int[] scores = this.getScoreArray();
        int sum = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];

        return (float) sum/5;
    }

    public String getCompetitionDescription(){
        return "Details of this competition";
    }

}
