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
        return Float.parseFloat("1.2");
    }

    public String getCompetitionDescription(){
        return "Details of this competition";
    }
}
