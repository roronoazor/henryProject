import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            new Manager();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }

//        JFrame frame = new JFrame("Main Page");
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        JLabel label = new JLabel("JFrame By Example");
//
//        // BUTTONS //
//        JButton registrationButton = new JButton("Register Competitor");
//        JButton scoreCompetitorButton = new JButton("Score Competitor");
//        JButton detailCompetitorButton = new JButton("View Competitor Detail");
//
//        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        registrationButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        registrationButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
//        scoreCompetitorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        scoreCompetitorButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
//        detailCompetitorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        detailCompetitorButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
//
//        // ACTIONS //
//        //  on click of registration button //
//        registrationButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                JPanel panel = new JPanel();
//                JFrame formFrame = new JFrame("Competitor Registration Form");
//
//                formFrame.setSize(new Dimension(500,500));
//                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                formFrame.add(panel);
//
//                panel.setLayout(null);
//
//                JLabel label = new JLabel("Name");
//                label.setBounds(10,20, 165, 25);
//                panel.add(label);
//
//                JTextField competitorName = new JTextField(20);
//                competitorName.setBounds(160, 20, 165, 25);
//                panel.add(competitorName);
//
//                JLabel competitorEmailLabel = new JLabel("Email");
//                competitorEmailLabel.setBounds(10, 50, 165, 25);
//                panel.add(competitorEmailLabel);
//
//                JTextField competitorEmail = new JTextField(20);
//                competitorEmail.setBounds(160, 50, 165, 25);
//                panel.add(competitorEmail);
//
//                JLabel dateOfBirthLabel = new JLabel("D.O.B (YYYY-MM-DD)");
//                dateOfBirthLabel.setBounds(10, 80, 350, 25);
//                panel.add(dateOfBirthLabel);
//
//                JTextField dateOfBirth = new JTextField(20);
//                dateOfBirth.setBounds(160, 80, 165, 25);
//                panel.add(dateOfBirth);
//
//                JLabel categoryLabel = new JLabel("Category");
//                categoryLabel.setBounds(10, 110, 80, 25);
//                panel.add(categoryLabel);
//
//                String categories[] = {"Swimming", "Running", "Long Jump"};
//                JComboBox categoriesBox = new JComboBox(categories);
//                categoriesBox.setBounds(160, 110, 165, 25);
//                panel.add(categoriesBox);
//
//                JLabel levelsLabel = new JLabel("Levels");
//                levelsLabel.setBounds(10, 140, 80, 25);
//                panel.add(levelsLabel);
//
//                String levels[] = {"Beginner", "Amateur", "Expert"};
//                JComboBox levelsBox = new JComboBox(levels);
//                levelsBox.setBounds(160, 140, 165, 25);
//                panel.add(levelsBox);
//
//                JLabel notificationMessage = new JLabel("notification");
//                notificationMessage.setBounds(10, 170, 300, 25);
//                panel.add(notificationMessage);
//
//                JButton button = new JButton("Submit");
//                button.setBounds(10, 190, 200, 25);
//                panel.add(button);
//
//                formFrame.setVisible(true);
//
//
////                Container contentPane = newGameWindow.getContentPane();
////                contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
////                JPanel titlePanel = new JPanel();
////                titlePanel.setSize(new Dimension(300, 50));
////                JPanel formPanel = new JPanel();
//////                titlePanel.setLayout(new FlowLayout());
//////                formPanel.setLayout(new GridLayout(2, 2, 5, 5));
////
////                JTextField nameField = new JTextField(10);
////                JTextField emailField = new JTextField(10);
////
////                titlePanel.add(new JLabel("Please fill the form below"));
////                formPanel.add(new JLabel("Competitor Name"));
////                formPanel.add(nameField);
////                formPanel.add(new JLabel("Email Name"));
////                formPanel.add(emailField);
////
////                contentPane.add(titlePanel);
////                contentPane.add(formPanel);
////
////                newGameWindow.setPreferredSize(new Dimension(500, 500));
////                newGameWindow.setVisible(true);
////                newGameWindow.setLocationRelativeTo(null);
////                newGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////                newGameWindow.pack();
//
//            }
//        });
//
//        // on click of competitors score button //
//        scoreCompetitorButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                JPanel panel = new JPanel();
//                JFrame formFrame = new JFrame("Competitor Details Form");
//
//                formFrame.setSize(new Dimension(500,500));
//                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                formFrame.add(panel);
//
//                panel.setLayout(null);
//
//                JLabel label = new JLabel("Search Competitor Number");
//                label.setBounds(10,20, 265, 25);
//                panel.add(label);
//
//                JTextField competitorNumber = new JTextField(20);
//                competitorNumber.setBounds(220, 20, 165, 25);
//                panel.add(competitorNumber);
//
//                JButton searchButton = new JButton("Search");
//                searchButton.setBounds(390, 20, 95, 25);
//                panel.add(searchButton);
//
//                JLabel eventLabel1 = new JLabel("Score Event 1");
//                eventLabel1.setBounds(10,50, 265, 25);
//                panel.add(eventLabel1);
//
//                SpinnerModel value = new SpinnerNumberModel(0, 0, 5, 1);
//                JSpinner score1 = new JSpinner(value);
//                score1.setBounds(220,50, 265, 25);
//                panel.add(score1);
//
//                JLabel eventLabel2 = new JLabel("Score Event 2");
//                eventLabel2.setBounds(10,80, 265, 25);
//                panel.add(eventLabel2);
//
//                SpinnerModel value2 = new SpinnerNumberModel(0, 0, 5, 1);
//                JSpinner score2 = new JSpinner(value2);
//                score2.setBounds(220,80, 265, 25);
//                panel.add(score2);
//
//                JLabel eventLabel3 = new JLabel("Score Event 3");
//                eventLabel3.setBounds(10,110, 265, 25);
//                panel.add(eventLabel3);
//
//                SpinnerModel value3 = new SpinnerNumberModel(0, 0, 5, 1);
//                JSpinner score3 = new JSpinner(value3);
//                score3.setBounds(220,110, 265, 25);
//                panel.add(score3);
//
//                JLabel eventLabel4 = new JLabel("Score Event 4");
//                eventLabel4.setBounds(10,140, 265, 25);
//                panel.add(eventLabel4);
//
//                SpinnerModel value4 = new SpinnerNumberModel(0, 0, 5, 1);
//                JSpinner score4 = new JSpinner(value4);
//                score4.setBounds(220,140, 265, 25);
//                panel.add(score4);
//
//                JLabel eventLabel5 = new JLabel("Score Event 5");
//                eventLabel5.setBounds(10,170, 265, 25);
//                panel.add(eventLabel5);
//
//                SpinnerModel value5 = new SpinnerNumberModel(0, 0, 5, 1);
//                JSpinner score5 = new JSpinner(value5);
//                score5.setBounds(220,170, 265, 25);
//                panel.add(score5);
//
//                JButton button = new JButton("Submit");
//                button.setBounds(10, 200, 200, 25);
//                panel.add(button);
//
//                formFrame.setVisible(true);
//            }
//        });
//
//        // on click competitors detail button  //
//        detailCompetitorButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                JPanel panel = new JPanel();
//                JFrame formFrame = new JFrame("Competitor Details");
//
//                formFrame.setSize(new Dimension(500,500));
//                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                formFrame.add(panel);
//
//                panel.setLayout(null);
//
//                JLabel label = new JLabel("Search Competitor Number");
//                label.setBounds(10,20, 265, 25);
//                panel.add(label);
//
//                JTextField competitorNumber = new JTextField(20);
//                competitorNumber.setBounds(220, 20, 165, 25);
//                panel.add(competitorNumber);
//
//                JButton searchButton = new JButton("Search");
//                searchButton.setBounds(390, 20, 95, 25);
//                panel.add(searchButton);
//
//                JLabel competitorName = new JLabel("Competitor Name");
//                competitorName.setBounds(10,50, 265, 25);
//                panel.add(competitorName);
//
//                JLabel competitorNameLabel = new JLabel("");
//                competitorNameLabel.setBounds(220,50, 265, 25);
//                panel.add(competitorNameLabel);
//
//                JLabel competitorNumber2 = new JLabel("Competitor Number");
//                competitorNumber2.setBounds(10,80, 265, 25);
//                panel.add(competitorNumber2);
//
//                JLabel competitorNumberLabel = new JLabel("");
//                competitorNumberLabel.setBounds(220,80, 265, 25);
//                panel.add(competitorNumberLabel);
//
//                JLabel age = new JLabel("Age");
//                age.setBounds(10,110, 265, 25);
//                panel.add(age);
//
//                JLabel ageLabel = new JLabel("");
//                ageLabel.setBounds(220,110, 265, 25);
//                panel.add(ageLabel);
//
//                JLabel category = new JLabel("Category");
//                category.setBounds(10,140, 265, 25);
//                panel.add(category);
//
//                JLabel categoryLabel = new JLabel("");
//                categoryLabel.setBounds(220,140, 265, 25);
//                panel.add(categoryLabel);
//
//                JLabel level = new JLabel("Level");
//                level.setBounds(10,170, 265, 25);
//                panel.add(level);
//
//                JLabel levelLabel = new JLabel("");
//                levelLabel.setBounds(220,170, 265, 25);
//                panel.add(levelLabel);
//
//                JLabel scores = new JLabel("Scores");
//                scores.setBounds(10,200, 265, 25);
//                panel.add(scores);
//
//                /** on search */
//                searchButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent actionEvent) {
//
//                    }
//                });
//
//                formFrame.setVisible(true);
//            }
//        });
//
//        panel.add(label);
//        panel.add(Box.createVerticalStrut(5));
//        panel.add(registrationButton);
//        panel.add(Box.createVerticalStrut(5));
//        panel.add(scoreCompetitorButton);
//        panel.add(Box.createVerticalStrut(5));
//        panel.add(detailCompetitorButton);
//
//        frame.add(panel);
//        frame.setSize(200, 300);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//            Manager manager = new Manager();
//            manager.generateReport();
//            System.out.println("Report has been written to the src/reports.txt file");
//
//            Scanner command = new Scanner(System.in);
//            System.out.println("Enter competitor number to view details or exit to close: ");
//
//            boolean running = true;
//            while(running){
//
//                String competitorNumber = command.nextLine();
//                switch (competitorNumber) {
//                    case "exit" -> {
//                        System.out.println("Application Closed");
//                        running = false;
//                    }
//                    default -> manager.findCompetitor(competitorNumber);
//                }
//            }
//            command.close();


    }
}