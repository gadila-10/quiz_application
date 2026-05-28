package com.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuizService {
    private List<Question> questions;
    private int score;

    public QuizService() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void incrementScore() {
        this.score++;
    }

    public int getScore() {
        return score;
    }
    
    public int getTotalQuestions() {
        return questions.size();
    }
}
