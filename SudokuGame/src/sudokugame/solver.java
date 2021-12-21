
package sudokugame;

public class solver {
    
     public static boolean solve(int board[][]) {
         
        int find[] = new int[2];
        find = find_empty(board);
        
        if (find[0] == -1 && find[1] == -1) {
            return true;
        } else {
            for (int i = 1; i < 10; i++) {
                if (valid_board(board, i, find)) {
                    board[find[0]][find[1]] = i;
                    if (solve(board)) {
                        return true;
                    }
                    board[find[0]][find[1]] = 0;
                }     
            }
            return false;
        }
    }
   
    
     public static int[] find_empty(int board[][]) {
        
        int coordinates[] = new int[2];
        coordinates[0] = -1;
        coordinates[1] = -1;
        
        for (int x = 0; x < board[0].length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == 0) {
                    coordinates[0] = x;
                    coordinates[1] = y;
                    return coordinates;
                }
            }
        }
        return coordinates;
    }
     
     public static boolean valid_board(int board[][], int check, int cord[]) {
        
        // check rows
        for (int x = 0; x < board[0].length; x++) {
            if (board[cord[0]][x] == check && cord[1] != x) {
                return false;
            }
        }
        
        // check columns
        for (int y = 0; y < board[0].length; y++) {
            if (board[y][cord[1]] == check && cord[0] != y) {
                return false;
            }
        
        }
        
        // check submatrix
        int x_cord = cord[0] / 3;
        int y_cord = cord[1] / 3;
        
        for (int x = x_cord * 3; x < x_cord * 3 + 3; x++) {
            for (int y = y_cord * 3; y < y_cord * 3 + 3; y++) {
                if (board[x][y] == check && x != cord[0] && y != cord[1]) {
                    return false;
                }
            }
        }
        return true;
    }
     
     
     public static void copy(int bank[][], int copy[][]) {  
        for (int x = 0; x < bank[0].length; x++) {
            for (int y = 0; y < bank[0].length; y++) {
                copy[x][y] = bank[x][y];
            }
        }
    }
    
}
