package com.example.competition.model;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionReader {
    AppCompatActivity activity;

    public List<Question> getQuestions(String filename) throws IOException {
        InputStream inputStream = activity.getAssets().open(filename);
        Scanner scanner = new Scanner(inputStream);
        List<Question> questionList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String qquestiontext = scanner.nextLine();
            List<String> choice = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                choice.add(scanner.nextLine());
            }
            String CorrectQuestiontext = scanner.nextLine();
            String photo = scanner.nextLine();
            String photofilename = photo.substring(0,photo.lastIndexOf("."));
            Question q = new Question();
            q.setChoices(choice);
            q.setQuestionText(qquestiontext);
            q.setCorrectAnswer(CorrectQuestiontext);
            q.setPhoto(photofilename);
            questionList.add(q);
        }
        return questionList;
    }
}
