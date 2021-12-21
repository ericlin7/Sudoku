
package sudokugame;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class solutionwindow {
    
    JFrame frame = new JFrame();
    solver solve = new solver();
    
    int[][] play = new int[9][9];
    int [][] solved = new int[9][9];
    
    solutionwindow(int[][] play) {
        
        this.play = play;
        frame.setTitle("Sudoku Solution");
        frame.setSize(586, 618);
        Board_solution board = new Board_solution();
        frame.setContentPane(board);
        solve.copy(play, solved);
        solve.solve(solved);
        frame.setVisible(true);
        frame.setResizable(false);
 
    }
    
    public class Board_solution extends JPanel {
 
        public void paintComponent(Graphics g) {

            g.setColor(Color.black);
            g.fillRect(0, 0, 600, 576);
            g.setColor(Color.white);

            int x_shift = 2;
            int y_shift = 2;

            for (int x = 0; x < 9; x++) {
                if (x % 3 == 0 && x != 0) {
                    x_shift += 2;
                }
                for (int y = 0; y < 9; y++) {
                    if (y % 3 == 0 && y != 0) {
                        y_shift += 2;
                    }

                    g.fillRect(x_shift + 63 * x, y_shift + 63 * y, 61, 61);
                    if (solved[y][x] != 0) {
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("OpenSymbol", Font.BOLD, 20));
                        g.drawString(Integer.toString(solved[y][x]), 63 * x + 29, 63 * y + 31);
                        g.setColor(Color.white);
                    }
                    g.setColor(Color.white);
                }
                y_shift = 2;
            }

        }
               
    }
}
