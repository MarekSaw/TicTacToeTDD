package org.tictactoe;

public class TicTacToe {
    private Character[][] board =  {{'\0','\0','\0'},
                                    {'\0','\0','\0'},
                                    {'\0','\0','\0'}};

    public void play(int X, int Y){

        if(X < 1 || X > 3){
            throw new RuntimeException("X is outside board");
        } else if(Y < 1 || Y > 3){
            throw new RuntimeException("Y is outside board");
        }
        if(board[X-1][Y-1] != '\0'){
            throw new RuntimeException("Box is occupied");
        }else{
            board[X-1][Y-1] = 'X';
        }




    }


}
