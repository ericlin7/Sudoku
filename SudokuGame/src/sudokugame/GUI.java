package sudokugame;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GUI extends JFrame {

    private int dx = 0;
    private int dy = 0;
    private int x_cord = 0;
    private int y_cord = 0;
    private int sec = 0;
    
    private Random r = new Random();
    private Button easy_button = new Button("Easy");
    private Button medium_button = new Button("Medium");
    private Button hard_button = new Button("Hard");
    private Button solve_button = new Button("Solution");
   
    private Date startDate = new Date();
    private JTextField enter = new JTextField();
    private solver solver = new solver();
    Font font1 = new Font("OpenSymbol", Font.PLAIN, 20);  
        
    private int[][] easyone = new int[][]{
        {6, 0, 9, 0, 0, 4, 0, 0, 1},
        {8, 0, 0, 0, 5, 0, 0, 0, 0},
        {0, 3, 5, 1, 0, 9, 0, 0, 8},
        {0, 0, 8, 0, 0, 0, 0, 0, 4},
        {0, 5, 0, 0, 0, 0, 0, 3, 0},
        {4, 0, 0, 0, 7, 0, 0, 5, 2},
        {0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 0, 4, 0, 0, 0, 0},
        {7, 6, 0, 9, 3, 0, 0, 0, 0}
    };
    
    private int[][] easytwo = new int[][]{
        {7, 4, 0, 0, 3, 0, 0, 1, 0},
        {0, 1, 9, 0, 6, 8, 5, 0, 2},
        {0, 0, 0, 0, 0, 4, 3, 0, 0},
        {0, 5, 6, 3, 7, 0, 0, 0, 1},
        {0, 0, 1, 8, 0, 0, 0, 9, 5},
        {0, 9, 0, 0, 2, 0, 6, 0, 0},
        {1, 0, 3, 4, 0, 7, 2, 0, 0},
        {5, 0, 0, 2, 0, 0, 0, 0, 8},
        {0, 8, 0, 0, 0, 1, 4, 7, 0}
    };
 
    int[][] easythree = new int[][]{
        {0, 3, 0, 0, 1, 0, 0, 6, 0},
        {7, 5, 0, 0, 3, 0, 0, 4, 8},
        {0, 0, 6, 9, 8, 4, 3, 0, 0},
        {0, 0, 3, 0, 0, 0, 8, 0, 0},
        {9, 1, 2, 0, 0, 0, 6, 7, 4},
        {0, 0, 4, 0, 0, 0, 5, 0, 0},
        {0, 0, 1, 6, 7, 5, 2, 0, 0},
        {6, 8, 0, 0, 9, 0, 0, 1, 5},
        {0, 9, 0, 0, 4, 0, 0, 3, 0}
    };
    
    
    private int[][] mediumone = new int[][]{
        {1, 5, 0, 2, 0, 9, 0, 0, 4},
        {0, 4, 0, 0, 0, 6, 0, 0, 0},
        {0, 0, 0, 0, 4, 0, 0, 6, 3},
        {0, 7, 0, 0, 0, 0, 8, 0, 6},
        {6, 0, 0, 0, 0, 0, 0, 0, 5},
        {2, 0, 8, 0, 0, 0, 0, 1, 0},
        {4, 6, 0, 0, 8, 0, 0, 0, 0},
        {0, 0, 0, 6, 0, 0, 0, 7, 0},
        {8, 0, 0, 5, 0, 1, 0, 4, 9}
    };

    private int[][] mediumtwo = new int[][]{
        {6, 4, 0, 9, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 3, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 2},
        {0, 3, 0, 0, 0, 0, 9, 0, 6},
        {1, 0, 0, 0, 0, 0, 7, 5, 0},
        {0, 2, 0, 0, 8, 5, 0, 0, 1},
        {0, 0, 0, 0, 0, 8, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 9, 7},
        {2, 7, 9, 0, 0, 0, 0, 6, 4}
    };

    private int[][] mediumthree = new int[][]{
        {4, 1, 0, 0, 0, 0, 0, 6, 8},
        {6, 0, 0, 0, 0, 0, 0, 2, 0},
        {0, 0, 0, 0, 0, 0, 5, 1, 0},
        {0, 0, 0, 2, 4, 0, 6, 9, 0},
        {3, 0, 0, 0, 5, 0, 0, 0, 0},
        {5, 0, 6, 0, 0, 9, 0, 0, 1},
        {0, 0, 0, 7, 0, 0, 3, 0, 0},
        {9, 0, 2, 0, 6, 4, 0, 0, 0},
        {0, 0, 7, 9, 0, 8, 0, 5, 0}
    };
    
    private int[][] hardone = new int[][]{
        {0, 0, 0, 7, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 4, 3, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 6},
        {0, 0, 0, 5, 0, 9, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 4, 1, 8},
        {0, 0, 0, 0, 8, 1, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 0, 5, 0},
        {0, 4, 0, 0, 0, 0, 3, 0, 0}
    };
    
            
    int[][] bank = new int[9][9]; 
    int[][] play = new int[9][9];

    public GUI() {
                 
        this.setTitle("Sudoku");
        this.setSize(586, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        this.setContentPane(board);
        this.setLayout(null);

        easy_button.setBounds(0, 580, 80, 80);
        board.add(easy_button);
        
        medium_button.setBounds(90, 580, 80, 80);
        board.add(medium_button);
        
        hard_button.setBounds(180, 580, 80, 80);
        board.add(hard_button);
        
        solve_button.setBounds(270, 580, 80, 80);
        board.add(solve_button);
        
        easy_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int random = r.nextInt(3) + 1;
                if (random == 1) {
                    copy(easyone, bank);
                    copy(easyone, play);
                } else if (random == 2) {
                    copy(easytwo, bank);
                    copy(easytwo, play);
                } else if (random == 3) {
                    copy(easythree, bank);
                    copy(easythree, play);
                    
                }
            }
        });
        
        medium_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int random = r.nextInt(3) + 1;
                if (random == 1) {
                    copy(mediumone, bank);
                    copy(mediumone, play);
                } else if (random == 2) {
                    copy(mediumtwo, bank);
                    copy(mediumtwo, play);
                } else if (random == 3) {
                    copy(mediumthree, bank);
                    copy(mediumthree, play);
                    
                }
            }
        });
        
        
        hard_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 copy(hardone, bank);
                 copy(hardone, play);
            }
        });
        
        
        solve_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   
                
                solutionwindow newwindow = new solutionwindow(bank);
            }
        });
        
        
        Move move = new Move();
        this.addMouseMotionListener(move);

        Click click = new Click(board);
        this.addMouseListener(click);
        
        enter.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
               
               String number = enter.getText();
               int new_number = Integer.parseInt(number);
                  
               if (bank[x_cord][y_cord] == 0) {  // play board
                  play[x_cord][y_cord] = new_number;
               }        
               
            }
        }

    });
    
        this.setVisible(true);
        this.setResizable(false);
        

    }

    public class Board extends JPanel {

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

                    if (dx >= x_shift + 63 * x && dx < x * 63 + 63 - x_shift
                            && dy >= y_shift + 63 * y && dy < 63 - y_shift + 63 * y) {
                        g.setColor(Color.RED);
                    }

                    g.fillRect(x_shift + 63 * x, y_shift + 63 * y, 61, 61);
                    if (play[x][y] != 0) {
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("OpenSymbol", Font.BOLD, 20));
                        g.drawString(Integer.toString(play[x][y]), 63 * x + 29, 63 * y + 31);
                        g.setColor(Color.white);
                    }

                    g.setColor(Color.white);
                }
                y_shift = 2;
            }
                           
            
            // Time Counter
            g.setColor(Color.white);
            g.fillRect(390, 580, 220, 80);
            sec = (int) ((new Date().getTime() - startDate.getTime()) / 1000);
            g.setColor(Color.black);
            g.setFont(new Font("OpenSymbol", Font.PLAIN, 30));

            g.drawString("Time: " + Integer.toString(sec), 400, 630); 

        }

    }

    public class Move implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            dx = e.getX();
            dy = e.getY();

        }

    }

    public class Click implements MouseListener {

        public Board board;

        public Click(Board board) {
            this.board = board;

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            int shift_x = 0;
            int shift_y = 0;

            if (getX() != -1 && getY() != -1) {
                System.out.println(getX() + " " + getY());
                
                if (getX() < 3) {
                    shift_x = 2;
                } else if (getX() >= 3 && getX() < 6) {
                    shift_x = 4;
                } else {
                    shift_x = 6;
                }

                if (getY() < 3) {
                    shift_y = 2;
                } else if (getY() >= 3 && getY() < 6) {
                    shift_y = 4;
                } else {
                    shift_y = 6;
                }
                
                if (bank[getX()][getY()] == 0) {
                enter.setBounds(shift_x + 63 * getX(), shift_y + 63 * getY(), 63, 63);
                enter.setFont(font1);
                enter.setHorizontalAlignment(JTextField.CENTER);
                enter.setText("");
                board.add(enter);
                x_cord = getX();
                y_cord = getY();
                }
                        
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public int getX() {
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

                if (dx >= x_shift + 63 * x && dx < x * 63 + 63 - x_shift
                        && dy >= y_shift + 63 * y && dy < 63 - y_shift + 63 * y) {
                    return x;
                }
            }
            y_shift = 2;
        }
        return -1;
    }

    public int getY() {
        
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
                if (dx >= x_shift + 63 * x && dx < x * 63 + 63 - x_shift
                        && dy >= y_shift + 63 * y && dy < 63 - y_shift + 63 * y) {
                    return y;
                }
            }
            y_shift = 2;
        }
        return -1;
    }
    
    public static void copy(int bank[][], int copy[][]) {  
        for (int x = 0; x < bank[0].length; x++) {
            for (int y = 0; y < bank[0].length; y++) {
                copy[x][y] = bank[x][y];
            }
        }
    }
    
}
