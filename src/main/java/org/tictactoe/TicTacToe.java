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
        return checkWinner();



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

    private String checkWinner(){
        if(checkHorizontal() != null){
            return checkHorizontal();
        }else if(checkVertical() != null){
            return checkVertical();
        }else if(checkDiagonalNorthEast() != null){
            return checkDiagonalNorthEast();
        }else if(checkDiagonalNorthWest() != null){
            return checkDiagonalNorthWest();
        }
        return "No winner";
    }

    private String checkHorizontal(){
        for(int index=0;index<3;index++){
            if(board[0][index] == lastPlayer
                    && board[1][index] == lastPlayer
                    && board[2][index] == lastPlayer){
                return lastPlayer+" is the winner";
            }
        }
        return null;
    }

    private String checkVertical(){
        for(int index=0;index<3;index++){
            if(board[index][0] == lastPlayer
                    && board[index][1] == lastPlayer
                    && board[index][2] == lastPlayer){
                return lastPlayer+" is the winner";
            }
        }
        return null;
    }

    private String checkDiagonalNorthEast() {
        if (board[0][0] == lastPlayer
                && board[1][1] == lastPlayer
                && board[2][2] == lastPlayer) {
            return lastPlayer + " is the winner";
        }
        return null;
    }

    private String checkDiagonalNorthWest() {
        if (board[2][0] == lastPlayer
                && board[1][1] == lastPlayer
                && board[0][2] == lastPlayer) {
            return lastPlayer + " is the winner";
        }
        return null;
    }

    public char nextPlayer() {
        if(lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }
}
