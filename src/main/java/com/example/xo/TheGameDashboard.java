package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TheGameDashboard extends AppCompatActivity {
    private XOGameBoard xoGameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_game_dashboard);
        Button playAgainBTN = findViewById(R.id.play_again_btn);
        Button homeBTN = findViewById(R.id.home_btn);
        TextView theDisplayedText = findViewById(R.id.text_view);
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        String [] playerNames  = getIntent().getStringArrayExtra("PLAYERS_NAMES");
        if (playerNames != null){
            theDisplayedText.setText((playerNames[0] + "'s Turn"));
        }
        xoGameBoard = findViewById(R.id.XOGameBoard);
        xoGameBoard.setUpGame(playAgainBTN , homeBTN , theDisplayedText , playerNames);

    }
    public void playAgainButton(View view){
        xoGameBoard.resetGame();
        xoGameBoard.invalidate();
    }

    public void homeButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}