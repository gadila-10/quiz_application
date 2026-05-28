package com.quizapp;

import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        QuizService quizService = new QuizService();
        Scanner scanner = new Scanner(System.in);

        // Seed data (Mimicking data layer fetch)
        quizService.addQuestion(new Question(
            "Which data type is used to create a variable that should store text in Java?",
            new String[]{"1. String", "2. txt", "3. myString", "4. char"}, 0
        ));
        quizService.addQuestion(new Question(
            "How do you insert COMMENTS in Java code?",
            new String[]{"1. # Comment", "2. /* Comment", "3. // Comment", "4. <!-- Comment -->"}, 2
        ));

        System.out.println("=== Welcome to the Java Online Quiz Application ===");
        
        for (int i = 0; i < quizService.getTotalQuestions(); i++) {
            Question q = quizService.getQuestions().get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getQuestionText());
            
            for (String option : q.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Your choice (1-4): ");
            int userChoice = scanner.nextInt() - 1; 

            if (q.isCorrectAnswer(userChoice)) {
                System.out.println("Result: Correct!");
                quizService.incrementScore();
            } else {
                System.out.println("Result: Wrong! The correct answer was option number " + (q.getCorrectOptionIndex() + 1));
            }
        }

        System.out.println("\n=== Quiz Finished ===");
        System.out.println("Final Score: " + quizService.getScore() + "/" + quizService.getTotalQuestions());
        scanner.close();
    }
}
