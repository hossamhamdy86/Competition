package com.example.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.competition.Controler.Controler;
import com.example.competition.model.Question;
import com.example.competition.model.QuestionReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questions extends AppCompatActivity {

    int score = 0 ;
    TextView questiontext;
    Button choice1 , choice2 , choice3 ;
    ImageView photo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        TextView show_name = findViewById(R.id.name_show);
        TextView the_score = findViewById(R.id.the_score);
        questiontext = findViewById(R.id.the_question);
        choice1 = findViewById(R.id.button);
        choice2 = findViewById(R.id.button2);
        choice3 = findViewById(R.id.button3);
        Button[] choicebtn = {choice1 , choice2 , choice3};
        photo = findViewById(R.id.imageView);
        the_score.setText(""+score);
        if (getIntent() != null && getIntent().hasExtra("name")){
            show_name.setText(getIntent().getStringExtra("name"));

        }

        List<Question> questionList = new ArrayList<Question>();
        try {
            QuestionReader questionReader = new QuestionReader();
            questionList = questionReader.getQuestions(this,"Questions.txt");
            for (Question q : questionList) {
                Log.d("comp",q.getQuestionText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
