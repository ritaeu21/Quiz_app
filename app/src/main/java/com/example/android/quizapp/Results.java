package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    int points;
    String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        points = getIntent().getIntExtra(Utils.A, -1);

        TextView scoreView = (TextView) findViewById(R.id.result);
        scoreView.setText(String.valueOf(points));

        user_name = getIntent().getStringExtra(Utils.B);
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(String.valueOf(user_name));





    }

    public void tryAgain (View view) {


        onBackPressed();

    }
    public void answers (View view) {
        Intent intent = new Intent(Results.this, Answers.class);
        startActivity(intent) ;
    }


}
