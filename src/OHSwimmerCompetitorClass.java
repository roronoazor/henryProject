public class OHSwimmerCompetitorClass extends OHCompetitorClass {

    private String category = "swimming";

    public OHSwimmerCompetitorClass(
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

        int totalPoints =  (scores[0]*5) + (scores[1]*5) + (scores[2]*5) + (scores[3]*5) + (scores[4]*5) ;
        float scaledDown = (float) totalPoints / 125;

        return scaledDown * 5;
    }

    public String getCompetitionDescription(){
        return "Details of this competition";
    }
}
