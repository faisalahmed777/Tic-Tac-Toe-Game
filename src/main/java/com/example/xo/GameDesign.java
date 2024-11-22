package com.example.xo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDesign {
    private int [] [] gameBoard;
    private int [] winType = {-1 ,-1 ,-1};
    private Button playAganinBTN;
    private String[] PlayerNames={ "Player 1" , "Player 2" };
    private Button homeBTN;
    private TextView playerTurn;
    private int player = 1;
    GameDesign(){
        gameBoard = new int[3][3];
        for (int r =0 ; r <3 ; r++){
            for (int c =0 ; c <3 ; c++){
                gameBoard [r][c] = 0;
            }
        }

    }
    public boolean updateGameBoard(int row , int col){
        if (gameBoard[row-1][col-1] == 0){
            gameBoard[row-1][col-1] = player;
            if (player == 1){
                playerTurn.setText((PlayerNames[1]) + "'s Turn");
            }else {
                playerTurn.setText(PlayerNames[0] + "'s Turn");
            }

            return true;
        }
        else {
            return false;
        }

    }
    public boolean winnerCheck(){
        boolean isWinner = false;


        for (int r=0; r<3;r++){
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] != 0){

                winType = new int[]{r, 0 , 1};
                isWinner = true;
                break;
            }
        }
        for (int c=0; c<3;c++){
            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[2][c] == gameBoard[0][c] && gameBoard[0][c] != 0){

                winType = new int[]{0, c , 2};
                isWinner = true;
                break;
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[2][2] == gameBoard[0][0] && gameBoard[0][0] != 0){

            winType = new int[]{0, 2 , 3};
            isWinner = true;
        }


        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] && gameBoard[2][0] != 0){

            winType = new int[]{2, 2 , 4};
            isWinner = true;
        }

        int boardFaild = 0;
        for (int r =0 ; r <3 ; r++){
            for (int c =0 ; c <3 ; c++){
                if (gameBoard[r][c] != 0 ){
                    boardFaild += 1;
                }
            }
        }

        if (isWinner){
            playAganinBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((PlayerNames[player-1] + "Won!!"));
            return true;
        }
        else if (boardFaild == 9){
            playAganinBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText(("Draw!!"));
            return true;
        }
        return false;

    }
    public void resetGame(){
        for (int r =0 ; r <3 ; r++){
            for (int c =0 ; c <3 ; c++){
                gameBoard [r][c] = 0;
            }
        }
        player = 1;
        playAganinBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        playerTurn.setText((PlayerNames[0] + "'s Turn"));


    }

    public void setPlayAganinBTN(Button playAganinBTN) {
        this.playAganinBTN = playAganinBTN;
    }

    public void setPlayerNames(String[] playerNames) {
        this.PlayerNames = playerNames;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }


    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}