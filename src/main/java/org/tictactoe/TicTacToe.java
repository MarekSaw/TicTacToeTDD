package org.tictactoe;

public class TicTacToe {
    private Character[][] board =  {{'\0','\0','\0'},
                                    {'\0','\0','\0'},
                                    {'\0','\0','\0'}};
    private char lastPlayer = '\0';

    public String play(int X, int Y){
        checkAxis(X);
        checkAxis(Y);
        setBox(X, Y);
        lastPlayer = nextPlayer();

        return "No winner";

    }

    public void checkAxis(int axis){
        if(axis < 1 || axis > 3){
            throw new RuntimeException("X is outside board");
        }
    }

    private void setBox(int X, int Y) {
        if(board[X-1][Y-1] != '\0'){
            throw new RuntimeException("Box is occupied");
        }else{
            board[X-1][Y-1] = 'X';
        }
    }


    public char nextPlayer() {
        if(lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }
}
