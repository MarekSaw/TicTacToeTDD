package org.tictactoe;

public class TicTacToe {
    private Character[][] board =  {{'\0','\0','\0'},
                                    {'\0','\0','\0'},
                                    {'\0','\0','\0'}};
    private char lastPlayer = '\0';

    public String play(int X, int Y){
        checkAxis(X);
        checkAxis(Y);
        lastPlayer = nextPlayer();
        setBox(X, Y, lastPlayer);
        return checkHorizontal();



    }

    private void checkAxis(int axis){
        if(axis < 1 || axis > 3){
            throw new RuntimeException("X is outside board");
        }
    }

    private void setBox(int X, int Y, char lastPlayer) {
        if(board[X-1][Y-1] != '\0'){
            throw new RuntimeException("Box is occupied");
        }else{
            board[X-1][Y-1] = lastPlayer;
        }
    }

    private String checkHorizontal(){
        for(int index=0;index<3;index++){
            if(board[0][index] == lastPlayer
                    && board[1][index] == lastPlayer
                    && board[2][index] == lastPlayer){
                return lastPlayer+" is the winner";
            }
        }
        return "No winner";
    }

    public char nextPlayer() {
        if(lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }
}
