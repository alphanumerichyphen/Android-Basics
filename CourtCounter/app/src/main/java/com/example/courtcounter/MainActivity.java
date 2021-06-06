package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the score for Team A
     */
    public void displayTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamA_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 3 points to the score
     */
    public void ThreeA(View view) {
        scoreTeamA += 3;
        displayTeamA(scoreTeamA);
    }

    /**
     * Adds 2 points to the score
     */
    public void TwoA(View view) {
        scoreTeamA += 2;
        displayTeamA(scoreTeamA);
    }

    /**
     * Adds 1 point to the score
     */
    public void OneA(View view) {
        scoreTeamA += 1;
        displayTeamA(scoreTeamA);
    }

    /**
     * Displays the score for Team B
     */
    public void displayTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamB_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 3 points to the score
     */
    public void ThreeB(View view) {
        scoreTeamB += 3;
        displayTeamB(scoreTeamB);
    }

    /**
     * Adds 2 points to the score
     */
    public void TwoB(View view) {
        scoreTeamB += 2;
        displayTeamB(scoreTeamB);
    }

    /**
     * Adds 1 point to the score
     */
    public void OneB(View view) {
        scoreTeamB += 1;
        displayTeamB(scoreTeamB);
    }

    /**
     * Resets the score for both teams to zero
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayTeamA(0);
        displayTeamB(0);
    }
}