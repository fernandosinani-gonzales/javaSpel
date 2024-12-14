//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        char[][] mytable = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mytable[i][j] = ' ';
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name for Player 0: ");
        String player0Name = sc.nextLine();
        System.out.print("Enter name for Player X: ");
        String playerXName = sc.nextLine();

        char currentPlayer = '0';
        boolean gameOver = false;

        while (!gameOver) {
            if (ismyTableCompleteFull(mytable)) {
                System.out.println("It is a draw! Try again!");
                break;
            }
            tableDesign(mytable);
            String currentPlayerName = (currentPlayer == '0') ? player0Name : playerXName;
            System.out.print(currentPlayerName + " is playing! Enter row [0-2] and column [0-2]: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (mytable[row][col] == ' ') {
                mytable[row][col] = currentPlayer;
                if (winnerChecker(mytable, currentPlayer)) {
                    tableDesign(mytable);
                    System.out.println(currentPlayerName + " wins!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == '0') ? 'X' : '0';
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }

        sc.close();
    }
    private static boolean ismyTableCompleteFull(char[][] tablefull) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablefull[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private static boolean winnerChecker(char[][] table, char player) {
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == player && table[i][1] == player && table[i][2] == player) ||
                    (table[0][i] == player && table[1][i] == player && table[2][i] == player)) {
                return true;
            }
        }
        return (table[0][0] == player && table[1][1] == player && table[2][2] == player) ||
                (table[0][2] == player && table[1][1] == player && table[2][0] == player);
    }

    private static void tableDesign(char[][] tabledrawinglines) {
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabledrawinglines[i][j] + " | ");
           }
            System.out.println();
        }



}
}