package com.example.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText your_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start_button = (Button) findViewById(R.id.start);
        your_name = findViewById(R.id.your_name);
    }

    public void start(View view) {
        String name = your_name.getText().toString();
        if (name == null || name.trim().equalsIgnoreCase("")){
            Toast.makeText(this, "please enter your name", Toast.LENGTH_LONG).show();
        }else{
            Intent GoToQuestionsPage = new Intent(this,Questions.class);
            GoToQuestionsPage.putExtra("name",name);
            startActivity(GoToQuestionsPage);
        }
    }
}
