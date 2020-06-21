package org.tictactoe;

public class TicTacToe {
    private Character[][] board =  {{'\0','\0','\0'},
                                    {'\0','\0','\0'},
                                    {'\0','\0','\0'}};

    public void play(int X, int Y){

        checkAxis(X);
        checkAxis(Y);
        setBox(X, Y);

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
        return 'X';
    }
}
