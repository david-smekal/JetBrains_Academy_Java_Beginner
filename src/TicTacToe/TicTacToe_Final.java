package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe_Final {
    public static final char[][] tictactoe = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xCoo;
        int yCoo;
        boolean xWin;
        boolean oWin;
        boolean gameNotFinished = true;
        boolean draw;
        int turn = 0; //determines which player is next
        String result = null;

        //fills array with empty cells
        for (char[] chars : tictactoe) {
            Arrays.fill(chars, '_');
        }

        //repeats game as long as it isn't finished
        while (gameNotFinished) {
            //print tictactoe grid
            System.out.println("---------");
            System.out.println("| " + tictactoe[0][0] + " " + tictactoe[0][1] + " " + tictactoe[0][2] + " |");
            System.out.println("| " + tictactoe[1][0] + " " + tictactoe[1][1] + " " + tictactoe[1][2] + " |");
            System.out.println("| " + tictactoe[2][0] + " " + tictactoe[2][1] + " " + tictactoe[2][2] + " |");
            System.out.println("---------");

            //check if input coordinates are valid
            boolean inputAccepted = false;
            do {
                System.out.print("> ");
                try {
                    String[] tempArray = sc.nextLine().replaceAll("> ", "").split(" ");
                    yCoo = Integer.parseInt(tempArray[0]);
                    xCoo = Integer.parseInt(tempArray[1]);
                    if (yCoo < 4 && yCoo > 0 && xCoo < 4 && xCoo > 0) {
                        if (tictactoe[yCoo - 1][xCoo - 1] != 'X' && tictactoe[yCoo - 1][xCoo - 1] != 'O') {
                            if (turn % 2 == 0) {
                                tictactoe[yCoo - 1][xCoo - 1] = 'X';
                            } else {
                                tictactoe[yCoo - 1][xCoo - 1] = 'O';
                            }
                            inputAccepted = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                }
            } while (!inputAccepted);

            //checks results
            xWin = xoWins(tictactoe, 'X');
            oWin = xoWins(tictactoe, 'O');
            gameNotFinished = gameNotFinished();
            draw = draw(tictactoe);

            //sets text to be printed for each result
            if (xWin && !oWin) {
                result = "X wins";
            } else if (oWin && !xWin) {
                result = "O wins";
            } else if (draw) {
                result = "Draw";
            }
            turn++;
        }

        System.out.println("---------");
        System.out.println("| " + tictactoe[0][0] + " " + tictactoe[0][1] + " " + tictactoe[0][2] + " |");
        System.out.println("| " + tictactoe[1][0] + " " + tictactoe[1][1] + " " + tictactoe[1][2] + " |");
        System.out.println("| " + tictactoe[2][0] + " " + tictactoe[2][1] + " " + tictactoe[2][2] + " |");
        System.out.println("---------");
        System.out.println(result);
    }

    public static boolean gameNotFinished() {
        return !xoWins(tictactoe, 'O') && !xoWins(tictactoe, 'X');
    }

    public static boolean draw(char[][] xo) {
        return !xoWins(xo, 'X') && !xoWins(xo, 'O');
    }

    public static boolean xoWins(char[][] xo, char checkXO) {
        boolean result = false;
        for (int i = 0; i < xo.length; i++) {
            if (xo[i][0] == checkXO && xo[i][1] == checkXO && xo[i][2] == checkXO) { //check if win horizontally
                result = true;
                break;
            }
        }
        for (int i = 0; i < xo[0].length; i++) {
            if (xo[0][i] == checkXO && xo[1][i] == checkXO && xo[2][i] == checkXO) { // check if win vertically
                result = true;
                break;
            }
        }
        if (xo[2][0] == checkXO && xo[1][1] == checkXO && xo[0][2] == checkXO) { //check if win diagonally (1)
            result = true;
        }
        if (xo[0][0] == checkXO && xo[1][1] == checkXO && xo[2][2] == checkXO) { //check if win diagonally (2)
            result = true;
        }
        return result;
    }
}