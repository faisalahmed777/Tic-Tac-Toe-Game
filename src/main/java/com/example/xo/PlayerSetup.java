package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {
    private EditText player1;
    private EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);
        player1 = findViewById(R.id.p1Name);
        player2 = findViewById(R.id.p2Name);
    }

    public void supmitNameButton(View view){
        String p1Name = player1.getText().toString();
        String p2Name = player2.getText().toString();
        Intent intent = new Intent(this, TheGameDashboard.class);
        intent.putExtra("PLAYERS_NAMES", new String[]{p1Name , p2Name});
        startActivity(intent);
    }

}