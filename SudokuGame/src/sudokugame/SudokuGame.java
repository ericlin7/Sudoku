
package sudokugame;

public class SudokuGame implements Runnable {

    GUI gui = new GUI();
    
    public static void main(String[] args) {      
        new Thread(new SudokuGame()).start();
    }

    @Override
    public void run() {
        while(true) {
          gui.repaint();      
        }
    }
    
}
