import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static char currentPlayer = 'X';
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;

        while (gameOn) {
            printBoard();
            System.out.println("Pemain " + currentPlayer + ", masukkan baris (1-3) dan kolom (1-3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Cek apakah input valid
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Posisi tidak valid! Coba lagi.");
                continue;
            }

            board[row][col] = currentPlayer; // Set simbol pemain di papan
            
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Selamat! Pemain " + currentPlayer + " menang!");
                gameOn = false;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("Permainan seri!");
                gameOn = false;
            } else {
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                } // ini untuk mengganti giliran pemain
            }
        }
        scanner.close();
    }

    // ini untuk mencetak papan tictactoe nya
    public static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // validasi apakah ada pemain yang menang
    public static boolean checkWin(char player) {
        // mengecek baris dan kolom
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Baris
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Kolom
                return true;
            }
        }
        // mengecek diagonal
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    // validasi apakah board sudah penuh atau belum
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
