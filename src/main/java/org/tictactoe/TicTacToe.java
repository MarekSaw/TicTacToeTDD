package org.tictactoe;


import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static Scanner scanner = new Scanner(System.in);
    private Character[][] board =  {{'\0','\0','\0'},
                                    {'\0','\0','\0'},
                                    {'\0','\0','\0'}};
    private char lastPlayer = '\0';

    public static void main(String[] args){

        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.introduction();
        String status = ticTacToe.play(scanner.nextInt(),scanner.nextInt());
        ticTacToe.playAi();
        ticTacToe.showBoard();

        while (status.equals("No winner")){
            status = ticTacToe.play(scanner.nextInt(),scanner.nextInt());
            if(!status.equals("No winner")){
                ticTacToe.showBoard();
                break;
            }
            status = ticTacToe.playAi();
            ticTacToe.showBoard();
        }
        System.out.println(status);

    }

    public void introduction(){
        System.out.println("Witaj w grze Kółko i Krzyżyk!");
        System.out.println("Plansza do gry wygląda następująco:");
        System.out.println( "Y-------------\n" +
                            "3|   |   |   |\n" +
                           // "--------------\n" +
                            "2|   |   |   |\n" +
                           // "--------------\n" +
                            "1|   |   |   |\n" +
                            "+--1---2---3-X");
        System.out.println("Pole wybierasz wpisując współrzędne X oraz Y oddzielone spacją");
        System.out.println("Wybierz swój znak wpisując X lub O");
        chooseSign(scanner.nextLine().charAt(0));
        System.out.println("Aby rozpocząć podaj współrzedne");
    }

    public void showBoard(){
        System.out.println("Y-------------");
        for(int i = 2; i >= 0; i--){
            System.out.print(i+1+"|");
            for(int j = 0; j < 3; j++){
                System.out.print(" "+board[j][i]+" |");
            }
            System.out.println();
        }
        System.out.println("+--1---2---3-X");
    }

    public void chooseSign(char sign){
        if(sign != 'X' && sign != 'O'){
            throw new RuntimeException("Wrong input");
        }else if(sign == 'O'){
            lastPlayer = 'X';
        }
    }

    public String play(int X, int Y){
        checkAxis(X);
        checkAxis(Y);
        lastPlayer = nextPlayer();
        setBox(X, Y, lastPlayer);
        return checkWinner();
    }

    public String playAi(){
        String status;
        int x = new Random().nextInt(3) + 1;
        int y = new Random().nextInt(3) + 1;
        if(board[x-1][y-1] != '\0'){
            status = playAi();
        }else {
            status =  play(x, y);
        }
        return status;
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
        }else if(checkDraw() != null){
            return checkDraw();
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

    private String checkDraw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '\0'){
                    return null;
                }
            }
        }
        return "Draw!";
    }

    public char nextPlayer() {
        if(lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }
}
