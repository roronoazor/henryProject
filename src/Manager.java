import java.io.IOException;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Manager {
        private CompetitorList competitorList;
        public Manager(String path) throws FileNotFoundException {

            // constructor for the manager class
            // use the path of the file to create a file object, account for situations where the file does not exist
            //File cfile = new File(".");
            //System.out.println(cfile.getAbsolutePath());
            File file = new File("src/Sports/" + path);

            // File file = new File(path);

            // use the scanner class to read the file
            Scanner sc = new Scanner(file);

            // arraylist to hold all the competitors
            ArrayList<OHCompetitorClass> listOfCompetitors = new ArrayList<>();

            // use a while loop to create to read the lines of a file
            while (sc.hasNextLine()){
                // https://stackoverflow.com/questions/35769435/nextline-method-does-not-take-subsequent-string-inputs
                String competitorString = sc.nextLine();
                ArrayList<String> attributeList = parseCompetitorString(competitorString);

                int competitorNumber = Integer.parseInt(attributeList.get(0).trim());
                String competitorName = attributeList.get(1).trim();
                System.out.println(competitorName);
                String[] namesArray =  competitorName.split(" ");
                String firstName = namesArray[0];
                String lastName = namesArray[1];

                String country = attributeList.get(3).trim();
                double height = Double.parseDouble(attributeList.get(5).trim());
                double weight = Double.parseDouble(attributeList.get(4).trim());
                int age = Integer.parseInt(attributeList.get(6).trim());
                int level =  Integer.parseInt(attributeList.get(2).trim());

                int[] scores = {
                        Integer.parseInt(attributeList.get(7).trim()),
                        Integer.parseInt(attributeList.get(8).trim()),
                        Integer.parseInt(attributeList.get(9).trim()),
                        Integer.parseInt(attributeList.get(10).trim()),
                        Integer.parseInt(attributeList.get(11).trim()),
                };

                Name compName = new Name(firstName, lastName);
                OHCompetitorClass competitor = new OHCompetitorClass(
                        compName, competitorNumber, age, height, weight, country, level, scores
                );

                // add the new created competitor to the list of competitors
                listOfCompetitors.add(competitor);


            }
            this.competitorList = new CompetitorList(listOfCompetitors);
        }

        public Manager() throws FileNotFoundException {
            this("competitors.txt");
        }

        public ArrayList<String> parseCompetitorString(String competitorString){
            return new ArrayList<>(Arrays.asList(competitorString.split(",")));
        }

        public void generateReport(){
            this.competitorList.getCompetitorsReport();
        }

        public void findCompetitor(String competitorNumber){
            this.competitorList.findByCompetitorNumber(competitorNumber);
        }
}
