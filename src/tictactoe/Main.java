package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Задаём пустое поле
        char[][] field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
            }
        }

        //Играем
        for (int turn = 1; turn < 10 && !wins(field, 'X') && !wins(field, 'O'); turn++) {
            //Вывод текущего состояния поля
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");

            // Ввод координаты
            boolean inputCorrect = false;
            while (inputCorrect == false) {
                String input = scanner.nextLine();
                if (input.length() == 3 && input.charAt(1) == ' ') {
                    int x = Character.getNumericValue(input.charAt(0));
                    int y = Character.getNumericValue(input.charAt(2));
                    if (x > 0 && x < 4 && y > 0 && y < 4) {
                        if (field[3 - y][x - 1] == ' ') {
                            field[3 - y][x - 1] = (turn % 2 == 1) ? 'X' : 'O';
                            inputCorrect = true;
                        }
                        else System.out.println("This cell is occupied! Choose another one!");
                    }
                    else System.out.println("Coordinates should be from 1 to 3!");
                }
                else System.out.println("You should enter numbers!");
            }

        }
        //Вывод итога игры
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        if (wins(field,'X')) System.out.println("X wins");
        else if (wins(field,'O')) System.out.println("O wins");
        else System.out.println("Draw");
    }





        /* Временно отключить
        boolean xWon = wins(field, 'X');
        boolean oWon = wins(field, 'O');
        if ((xWon && oWon) || numDifference(cells) > 1) {
            System.out.println("Impossible");
        }
        else if (!xWon && !oWon && cells.indexOf("_") >= 0) {
            System.out.println("Game not finished");
        }
        else if (xWon == false && oWon == false && cells.indexOf("_") == -1) {
            System.out.println("Draw");


        }
        else if (xWon) {
            System.out.println("X wins");
        }
        else if (oWon) {
            System.out.println("O wins");
        }
        */



    //Метод, определяющий, выиграл ли игрок
    public static boolean wins(char[][] field, char symbol) {
        boolean result = false;
        for (int j = 0; j < 3; j++) {
            if (field[0][j] == symbol && field[1][j] == symbol && field[2][j] == symbol) {
                result = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) {
                result = true;
            }
        }
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
            result = true;
        }
        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
            result = true;
        }
        return result;
    }

    // Метод, определяющий заполненность поля
    public static boolean fullField(char[][] field) {
        boolean result = true;
        for (int i = 0; i < 3 && result; i++) {
            for (int j = 0; j < 3 && result; j++) {
                if (field[i][j] == ' ') result = false;
            }
        }
        return result;
    }




}
