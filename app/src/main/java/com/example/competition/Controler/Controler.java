package com.example.competition.Controler;

import androidx.appcompat.app.AppCompatActivity;
import com.example.competition.model.Question;
import com.example.competition.model.QuestionReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controler {

    public List<Question> folderQuestions (AppCompatActivity activity){
        List<Question> questionsView = new ArrayList<>();
        {
            Question question = new Question();
            List<Question> q = new ArrayList<>();
           while (!q.isEmpty())
            try {
                QuestionReader questionReader = new QuestionReader();
                q = questionReader.getQuestions(activity,"Questions.txt");
                Collections.shuffle(q);
                question = q.remove(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            questionsView.add(question);

        }
        return questionsView;
    }



}
