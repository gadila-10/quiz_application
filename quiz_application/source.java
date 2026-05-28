// File: QuizGUI.java
// Java Swing Frontend Quiz Application

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizGUI extends JFrame implements ActionListener {

    // Questions
    String[] questions = {
        "What is the capital of India?",
        "Which language is used for Android Development?",
        "What is 10 + 5?"
    };

    // Options
    String[][] options = {
        {"Mumbai", "Delhi", "Chennai", "Kolkata"},
        {"Python", "Java", "Swift", "PHP"},
        {"12", "13", "15", "20"}
    };

    // Correct Answers
    char[] answers = {'B', 'B', 'C'};

    int currentQuestion = 0;
    int score = 0;

    // GUI Components
    JLabel questionLabel;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup bg;
    JButton nextButton;

    public QuizGUI() {

        setTitle("Quiz Application");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Question Label
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(questionLabel, BorderLayout.NORTH);

        // Options Panel
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        bg = new ButtonGroup();

        bg.add(option1);
        bg.add(option2);
        bg.add(option3);
        bg.add(option4);

        optionsPanel.add(option1);
        optionsPanel.add(option2);
        optionsPanel.add(option3);
        optionsPanel.add(option4);

        add(optionsPanel, BorderLayout.CENTER);

        // Next Button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        add(nextButton, BorderLayout.SOUTH);

        loadQuestion();

        setVisible(true);
    }

    // Load Question
    public void loadQuestion() {

        questionLabel.setText(
            "Q" + (currentQuestion + 1) + ": "
            + questions[currentQuestion]
        );

        option1.setText("A. " + options[currentQuestion][0]);
        option2.setText("B. " + options[currentQuestion][1]);
        option3.setText("C. " + options[currentQuestion][2]);
        option4.setText("D. " + options[currentQuestion][3]);

        bg.clearSelection();
    }

    // Check Answer
    public void checkAnswer() {

        char selectedAnswer = ' ';

        if (option1.isSelected()) selectedAnswer = 'A';
        if (option2.isSelected()) selectedAnswer = 'B';
        if (option3.isSelected()) selectedAnswer = 'C';
        if (option4.isSelected()) selectedAnswer = 'D';

        if (selectedAnswer == answers[currentQuestion]) {
            score++;
        }
    }

    // Button Action
    public void actionPerformed(ActionEvent e) {

        checkAnswer();

        currentQuestion++;

        if (currentQuestion < questions.length) {

            loadQuestion();

        } else {

            JOptionPane.showMessageDialog(
                this,
                "Quiz Completed!\nYour Score: "
                + score + "/" + questions.length
            );

            System.exit(0);
        }
    }

    // Main Method
    public static void main(String[] args) {

        new QuizGUI();
    }
}