package com.example.mhcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class quiz extends AppCompatActivity {

    private TextView question;
    private TextView nextQuestion;
    int count = 0;
    private RadioGroup mcqGroup;
    private RadioButton mcqAns;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final View contextView = findViewById(R.layout.activity_quiz);

        question = findViewById(R.id.question);
        nextQuestion = findViewById(R.id.next_question);
        mcqGroup = findViewById(R.id.mcqOptions);

        final String[] Questions = {"Your life is on the right track", "You have been left alone when you don't want to be",
                "You can do whatever you want", "You have been thinking clearly and creatively", "You are a failure",
                "Nothing is fun anymore", "You like yourself", "You can't be bothered to do anything", "You are close to the people around you",
                "The best years of your life are over", "Your future looks good", "You don't care about other people", "You have energy to spare"};

        final int[] questionWeight = {1, 0, -1, 1, -1, -1, 1, -1, 1, -1, 1, -1, 1};
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final int len = Questions.length;
        System.out.println(len);



        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int selectedId = mcqGroup.getCheckedRadioButtonId();
                    if(selectedId!= -1) {

                        mcqAns = findViewById(selectedId);
                        View radioButton = mcqGroup.findViewById(selectedId);
                        int idx = mcqGroup.indexOfChild(radioButton);
                        //System.out.println(idx);

                        idx++;
                        idx = idx-2;

                        score+=questionWeight[count]*idx;
                       // System.out.println(score);

                        count++;
                        question.setText(Questions[count]);
                    }else{
                        Toast.makeText(quiz.this, "Please select appropriate option", Toast.LENGTH_SHORT).show();
                    }
                    if(count == len-1){
                        Intent intent = new Intent(quiz.this, userScore.class);
                        intent.putExtra("scoreC", score);
                        startActivity(intent);
                        finish();
                    }
            }
        });




    }

}
