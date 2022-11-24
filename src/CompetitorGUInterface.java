import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class CompetitorGUInterface {

    private CompetitorList competitorList;

    public CompetitorGUInterface(CompetitorList competitorList){

        JFrame frame = new JFrame("Main Page");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Options");

        // BUTTONS //
        JButton registrationButton = new JButton("Register Competitor");
        JButton scoreCompetitorButton = new JButton("Score Competitor");
        JButton detailCompetitorButton = new JButton("View Competitor Detail");
        JButton printReportButton = new JButton("Print Report");
        JButton competitorsButton = new JButton("View Competitors");

        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        registrationButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        registrationButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        scoreCompetitorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        scoreCompetitorButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        detailCompetitorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        detailCompetitorButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        printReportButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        printReportButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        competitorsButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        competitorsButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);

        // ACTIONS //
        //  on click of registration button //
        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel panel = new JPanel();
                JFrame formFrame = new JFrame("Competitor Registration Form");

                formFrame.setSize(new Dimension(600,500));
                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                formFrame.add(panel);

                panel.setLayout(null);

                JLabel label = new JLabel("Name");
                label.setBounds(10,20, 165, 25);
                panel.add(label);

                JTextField competitorName = new JTextField(20);
                competitorName.setBounds(160, 20, 165, 25);
                panel.add(competitorName);

                JLabel competitorEmailLabel = new JLabel("Email");
                competitorEmailLabel.setBounds(10, 50, 165, 25);
                panel.add(competitorEmailLabel);

                JTextField competitorEmail = new JTextField(20);
                competitorEmail.setBounds(160, 50, 165, 25);
                panel.add(competitorEmail);

                JLabel dateOfBirthLabel = new JLabel("D.O.B (YYYY-MM-DD)");
                dateOfBirthLabel.setBounds(10, 80, 350, 25);
                panel.add(dateOfBirthLabel);

                JTextField dateOfBirth = new JTextField(20);
                dateOfBirth.setBounds(160, 80, 165, 25);
                panel.add(dateOfBirth);

                JLabel categoryLabel = new JLabel("Category");
                categoryLabel.setBounds(10, 110, 80, 25);
                panel.add(categoryLabel);

                String categories[] = {"Swimming", "Running", "Long Jump"};
                JComboBox categoriesBox = new JComboBox(categories);
                categoriesBox.setBounds(160, 110, 165, 25);
                panel.add(categoriesBox);

                JLabel levelsLabel = new JLabel("Levels");
                levelsLabel.setBounds(10, 140, 80, 25);
                panel.add(levelsLabel);

                String levels[] = {"Beginner", "Amateur", "Expert"};
                JComboBox levelsBox = new JComboBox(levels);
                levelsBox.setBounds(160, 140, 165, 25);
                panel.add(levelsBox);

                JLabel heightLabel = new JLabel("Height");
                heightLabel.setBounds(10, 170, 80, 25);
                panel.add(heightLabel);


                JTextField competitorHeight = new JTextField();
                competitorHeight.setBounds(160, 170, 165, 25);
                panel.add(competitorHeight);

                JLabel weightLabel = new JLabel("Weight");
                weightLabel.setBounds(10, 200, 80, 25);
                panel.add(weightLabel);

                JTextField competitorWeight = new JTextField();
                competitorWeight.setBounds(160, 200, 165, 25);
                panel.add(competitorWeight);

                JLabel notificationMessage = new JLabel("");
                notificationMessage.setBounds(10, 230, 1000, 25);
                panel.add(notificationMessage);

                JButton registerButton = new JButton("Submit");
                registerButton.setBounds(10, 260, 200, 25);
                panel.add(registerButton);

                registerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        notificationMessage.setText("");
                        String vName = competitorName.getText().trim();




                        String vEmail = competitorEmail.getText().trim();
                        String vDob = dateOfBirth.getText().trim();
                        String vCategory = ((String) categoriesBox.getSelectedItem()).trim();
                        String vLevel = ((String) levelsBox.getSelectedItem()).trim();
                        String vHeight = competitorHeight.getText().trim();
                        String vWeight = competitorWeight.getText().trim();

                        System.out.printf(
                                "%s %s %s %s %s", vName, vEmail, vDob, vCategory, vLevel
                        );

                        String isDataClean = competitorList.validate(
                                vName,
                                vEmail,
                                vDob,
                                vCategory,
                                vLevel,
                                vHeight,
                                vWeight
                        );

                        if (!isDataClean.equalsIgnoreCase("")){
                            System.out.println(isDataClean);
                            notificationMessage.setText(isDataClean);
                            return;
                        }

                        String vfirstName = vName.split(" ")[0];
                        String vlastName = vName.split(" ")[1];

                        notificationMessage.setText("");
                        String response = competitorList.addCompetitor(
                                vfirstName,
                                vlastName,
                                vEmail,
                                vCategory,
                                vDob,
                                vHeight,
                                vWeight,
                                "",
                                vLevel
                        );
                        notificationMessage.setText(response);
                        System.out.println(competitorList.getCompetitorsFullList());

                    }
                });

                formFrame.setVisible(true);


//                Container contentPane = newGameWindow.getContentPane();
//                contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
//                JPanel titlePanel = new JPanel();
//                titlePanel.setSize(new Dimension(300, 50));
//                JPanel formPanel = new JPanel();
////                titlePanel.setLayout(new FlowLayout());
////                formPanel.setLayout(new GridLayout(2, 2, 5, 5));
//
//                JTextField nameField = new JTextField(10);
//                JTextField emailField = new JTextField(10);
//
//                titlePanel.add(new JLabel("Please fill the form below"));
//                formPanel.add(new JLabel("Competitor Name"));
//                formPanel.add(nameField);
//                formPanel.add(new JLabel("Email Name"));
//                formPanel.add(emailField);
//
//                contentPane.add(titlePanel);
//                contentPane.add(formPanel);
//
//                newGameWindow.setPreferredSize(new Dimension(500, 500));
//                newGameWindow.setVisible(true);
//                newGameWindow.setLocationRelativeTo(null);
//                newGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                newGameWindow.pack();

            }
        });

        // on click of competitors score button //
        scoreCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JPanel panel = new JPanel();
                JFrame formFrame = new JFrame("Competitor Details Form");
                String selectedCompetitorNumber;

                formFrame.setSize(new Dimension(500,500));
                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                formFrame.add(panel);

                panel.setLayout(null);

                JLabel label = new JLabel("Search Competitor Number");
                label.setBounds(10,20, 265, 25);
                panel.add(label);

                JTextField competitorNumber = new JTextField(20);
                competitorNumber.setBounds(220, 20, 165, 25);
                panel.add(competitorNumber);

                JButton searchButton = new JButton("Search");
                searchButton.setBounds(390, 20, 95, 25);
                panel.add(searchButton);

                JLabel notificationLabel = new JLabel("");
                notificationLabel.setBounds(10,40, 265, 25);
                panel.add(notificationLabel);

                JLabel competitorNumberLabel = new JLabel("");
                competitorNumberLabel.setBounds(220,40, 265, 25);
                panel.add(competitorNumberLabel);

                JLabel eventLabel1 = new JLabel("Score Event 1");
                eventLabel1.setBounds(10,70, 265, 25);
                panel.add(eventLabel1);

                SpinnerModel value = new SpinnerNumberModel(0, 0, 5, 1);
                JSpinner score1 = new JSpinner(value);
                score1.setBounds(220,70, 265, 25);
                panel.add(score1);

                JLabel eventLabel2 = new JLabel("Score Event 2");
                eventLabel2.setBounds(10,100, 265, 25);
                panel.add(eventLabel2);

                SpinnerModel value2 = new SpinnerNumberModel(0, 0, 5, 1);
                JSpinner score2 = new JSpinner(value2);
                score2.setBounds(220,100, 265, 25);
                panel.add(score2);

                JLabel eventLabel3 = new JLabel("Score Event 3");
                eventLabel3.setBounds(10,130, 265, 25);
                panel.add(eventLabel3);

                SpinnerModel value3 = new SpinnerNumberModel(0, 0, 5, 1);
                JSpinner score3 = new JSpinner(value3);
                score3.setBounds(220,130, 265, 25);
                panel.add(score3);

                JLabel eventLabel4 = new JLabel("Score Event 4");
                eventLabel4.setBounds(10,160, 265, 25);
                panel.add(eventLabel4);

                SpinnerModel value4 = new SpinnerNumberModel(0, 0, 5, 1);
                JSpinner score4 = new JSpinner(value4);
                score4.setBounds(220,160, 265, 25);
                panel.add(score4);

                JLabel eventLabel5 = new JLabel("Score Event 5");
                eventLabel5.setBounds(10,190, 265, 25);
                panel.add(eventLabel5);

                SpinnerModel value5 = new SpinnerNumberModel(0, 0, 5, 1);
                JSpinner score5 = new JSpinner(value5);
                score5.setBounds(220,190, 265, 25);
                panel.add(score5);

                JButton button = new JButton("Submit");
                button.setBounds(10, 220, 200, 25);
                panel.add(button);

                JLabel postText = new JLabel("");
                postText.setBounds(10,250, 565, 25);
                panel.add(postText);

                // search button
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        notificationLabel.setText("");
                        competitorNumberLabel.setText("");
                        postText.setText("");

                        score1.setValue(0);
                        score2.setValue(0);
                        score3.setValue(0);
                        score4.setValue(0);
                        score5.setValue(0);

                        OHCompetitorClass competitor = competitorList.findByCompetitorNumber(competitorNumber.getText().trim());

                        if (competitor == null){
                            notificationLabel.setText("Not Found");
                            return;
                        }
                        notificationLabel.setText("Found " + competitor.getCompetitorName());
                        competitorNumberLabel.setText(competitor.getCompetitorNumber());

                        int[] scores = competitor.getScoreArray();

                        score1.setValue(scores[0]);
                        score2.setValue(scores[1]);
                        score3.setValue(scores[2]);
                        score4.setValue(scores[3]);
                        score5.setValue(scores[4]);

                    }
                });

                // submit action
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String competitorNumber = competitorNumberLabel.getText();
                        OHCompetitorClass competitor = competitorList.findByCompetitorNumber(competitorNumber);

                        if (competitor == null){
                            return;
                        }

                        int[] scores = {
                                (int) score1.getValue(),
                                (int) score2.getValue(),
                                (int) score3.getValue(),
                                (int) score4.getValue(),
                                (int) score5.getValue(),
                        };
                        competitor.setScores(scores);
                        postText.setText(
                                "Scores submitted successfully, overall score of competitor is " +
                                competitor.getOverallScore());
                        return;
                    }
                });

                formFrame.setVisible(true);
            }
        });

        // on click competitors detail button  //
        detailCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JPanel panel = new JPanel();
                JFrame formFrame = new JFrame("Competitor Details");

                formFrame.setSize(new Dimension(500,500));
                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                formFrame.add(panel);

                panel.setLayout(null);

                JLabel label = new JLabel("Search Competitor Number");
                label.setBounds(10,20, 265, 25);
                panel.add(label);

                JTextField competitorNumberField = new JTextField(20);
                competitorNumberField.setBounds(220, 20, 165, 25);
                panel.add(competitorNumberField);

                JButton searchButton = new JButton("Search");
                searchButton.setBounds(390, 20, 95, 25);
                panel.add(searchButton);

                JLabel notificationLabel = new JLabel("");
                notificationLabel.setBounds(10,35, 265, 25);
                panel.add(notificationLabel);

                JLabel competitorName = new JLabel("Competitor Name");
                competitorName.setBounds(10,50, 265, 25);
                panel.add(competitorName);

                JLabel competitorNameLabel = new JLabel("");
                competitorNameLabel.setBounds(220,50, 265, 25);
                panel.add(competitorNameLabel);

                JLabel competitorNumber2 = new JLabel("Competitor Number");
                competitorNumber2.setBounds(10,80, 265, 25);
                panel.add(competitorNumber2);

                JLabel competitorNumberLabel = new JLabel("");
                competitorNumberLabel.setBounds(220,80, 265, 25);
                panel.add(competitorNumberLabel);

                JLabel age = new JLabel("Age");
                age.setBounds(10,110, 265, 25);
                panel.add(age);

                JLabel ageLabel = new JLabel("");
                ageLabel.setBounds(220,110, 265, 25);
                panel.add(ageLabel);

                JLabel category = new JLabel("Category");
                category.setBounds(10,140, 265, 25);
                panel.add(category);

                JLabel categoryLabel = new JLabel("");
                categoryLabel.setBounds(220,140, 265, 25);
                panel.add(categoryLabel);

                JLabel level = new JLabel("Level");
                level.setBounds(10,170, 265, 25);
                panel.add(level);

                JLabel levelLabel = new JLabel("");
                levelLabel.setBounds(220,170, 265, 25);
                panel.add(levelLabel);

                JLabel scores = new JLabel("Scores");
                scores.setBounds(10,200, 265, 25);
                panel.add(scores);

                JLabel scoresLabel = new JLabel("");
                scoresLabel.setBounds(220,170, 265, 25);
                panel.add(scoresLabel);

                JLabel email = new JLabel("Email");
                email.setBounds(10,230, 265, 25);
                panel.add(scores);

                JLabel emailLabel = new JLabel("");
                emailLabel.setBounds(220,200, 265, 25);
                panel.add(emailLabel);

                /** on search */
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        notificationLabel.setText("");
                        competitorNameLabel.setText("");
                        competitorNumberLabel.setText("");
                        ageLabel.setText("");
                        categoryLabel.setText("");
                        levelLabel.setText("");
                        scoresLabel.setText("");
                        emailLabel.setText("");

                        String competitorNumber = competitorNumberField.getText().trim();
                        OHCompetitorClass competitor = competitorList.findByCompetitorNumber(competitorNumber);

                        if (competitor == null){
                            notificationLabel.setText("Not Found");
                            return;
                        }

                        notificationLabel.setText("Found");
                        competitorNameLabel.setText(competitor.getCompetitorName());
                        competitorNumberLabel.setText(competitor.getCompetitorNumber());
                        ageLabel.setText(Integer.toString(competitor.getAge()));
                        categoryLabel.setText(competitor.getCategory());
                        levelLabel.setText(competitor.getLevelString());
                        scoresLabel.setText(competitor.getScoresString());
                        emailLabel.setText(competitor.getCompetitorEmail());


                    }
                });

                formFrame.setVisible(true);
            }
        });

        printReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                competitorList.getCompetitorsReport();
            }
        });


        competitorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JPanel panel = new JPanel();
                JFrame formFrame = new JFrame("All Competitors");

                formFrame.setSize(new Dimension(500,500));
                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                formFrame.add(panel);

                panel.setLayout(null);

                ArrayList<OHCompetitorClass> competitors = competitorList.getCompetitors();
                Object[][] competitorsData = new Object[competitors.size()][5];
                for (int row = 0; row < competitors.size(); row++) {
                    for (int col = 0; col < competitorsData[row].length; col++) {
                        if (col == 0) {
                            competitorsData[row][col] = competitors.get(row).getCompetitorNumber();
                        }else if (col == 1) {
                            competitorsData[row][col] = competitors.get(row).getCompetitorName();
                        }else if ( col == 2 ) {
                            competitorsData[row][col] = competitors.get(row).getCategory();
                        }else if ( col == 3 ) {
                            competitorsData[row][col] = competitors.get(row).getLevelString();
                        }else {
                            competitorsData[row][col] = competitors.get(row).getOverallScore();
                        }
                    }
                }
                String[] column={"Competitor Number","Competitor Name","Category", "Level", "Overall Score"};

                JTable jt = new JTable(competitorsData, column);
                jt.setBounds(10,100,200,300);
                jt.setAutoCreateRowSorter(true);
                JScrollPane sp=new JScrollPane(jt);

                formFrame.add(sp);


                formFrame.setVisible(true);
            }
        });

        panel.add(label);
        panel.add(Box.createVerticalStrut(5));
        panel.add(registrationButton);
        panel.add(Box.createVerticalStrut(5));
        panel.add(scoreCompetitorButton);
        panel.add(Box.createVerticalStrut(5));
        panel.add(detailCompetitorButton);
        panel.add(Box.createVerticalStrut(5));
        panel.add(printReportButton);
        panel.add(Box.createVerticalStrut(5));
        panel.add(competitorsButton);


        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
