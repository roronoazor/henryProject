public class OHRunnerCompetitorClass extends OHCompetitorClass{

    private String category = "running";

    public OHRunnerCompetitorClass(
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

        int totalPoints =  scores[0] + (scores[1]*2) + (scores[2]*3) + (scores[3]*4) + (scores[4]*5);
        float scaledDown = (float) totalPoints / 75;

        return scaledDown * 5;
    }

    public String getCompetitionDescription(){
        return "Details of this competition";
    }


}
