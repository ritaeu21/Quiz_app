package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int points;
    RadioGroup question1, question2, question3, question4, question5;
   EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question1 = findViewById(R.id.question_1_group);
        question2 = findViewById(R.id.question_2_group);
        question3 = findViewById(R.id.question_3_group);
        question4 = findViewById(R.id.question_4_group);
        question5 = findViewById(R.id.question_5_group);


    }


    public void checkAnswers() {


        if (question1.getCheckedRadioButtonId() == R.id.q1a1) {
            points = points + 1;
        } else if (question1.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }
        if (question2.getCheckedRadioButtonId() == R.id.q2a2) {
            points = points + 1;
        } else if (question2.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }
        if (question3.getCheckedRadioButtonId() == R.id.q3a4) {
            points = points + 1;
        } else if (question3.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }
        if (question4.getCheckedRadioButtonId() == R.id.q4a2) {
            points = points + 1;
        } else if (question4.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }
        if (question5.getCheckedRadioButtonId() == R.id.q5a4) {
            points = points + 1;

        } else if (question5.getCheckedRadioButtonId() == -1) {
            showError();
        }

    }



    public void submit (View view){
            checkAnswers();
        name = findViewById(R.id.name);
        String name_user = name.getText().toString();

        Intent intent = new Intent(MainActivity.this, Results.class);
        intent.putExtra(Utils.A,points);
        intent.putExtra(Utils.B, name_user);

        startActivity(intent);



    }
    void showError() {
        // Show an error message as a toast
        Toast.makeText(this, "Please select answers to all questions.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        points = 0;
        question1.clearCheck();
        question2.clearCheck();
        question3.clearCheck();
        question4.clearCheck();
        question5.clearCheck();

    }
}
