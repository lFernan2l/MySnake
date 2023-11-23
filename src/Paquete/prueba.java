
package Paquete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class prueba extends JPanel implements ActionListener {
    private static final int CELL_SIZE = 30;
    private static final int BOARD_SIZE = 30;
    private ArrayList<Point> snake1, snake2;
    private Point food;
    private char direction1, direction2;
    private Timer timer;
    private Random random;
    

    public prueba() {
        // initComponents();
        
        snake1 = new ArrayList<>();
        snake2 = new ArrayList<>();
        snake1.add(new Point(10, 10));
        snake2.add(new Point(15, 10));
        food = new Point(5, 5);
        direction1 = 'R';
        direction2 = 'L';
        random = new Random();

        timer = new Timer(200, this);
        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
    }

        private void handleKeyPress(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT) && (direction1 != 'R')) {
            direction1 = 'L';
        } else if ((key == KeyEvent.VK_RIGHT) && (direction1 != 'L')) {
            direction1 = 'R';
        } else if ((key == KeyEvent.VK_UP) && (direction1 != 'D')) {
            direction1 = 'U';
        } else if ((key == KeyEvent.VK_DOWN) && (direction1 != 'U')) {
            direction1 = 'D';
        } else if ((key == KeyEvent.VK_A) && (direction2 != 'R')) {
            direction2 = 'L';
        } else if ((key == KeyEvent.VK_D) && (direction2 != 'L')) {
            direction2 = 'R';
        } else if ((key == KeyEvent.VK_W) && (direction2 != 'D')) {
            direction2 = 'U';
        } else if ((key == KeyEvent.VK_S) && (direction2 != 'U')) {
            direction2 = 'D';
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        checkCollision();
        checkFood();
        repaint();
    }

    private void move() {
        Point head1 = snake1.get(0);
        Point head2 = snake2.get(0);

        Point newHead1 = calculateNewHead(head1, direction1);
        Point newHead2 = calculateNewHead(head2, direction2);

        snake1.add(0, newHead1);
        snake2.add(0, newHead2);

        snake1.remove(snake1.size() - 1);
        snake2.remove(snake2.size() - 1);
    }

    private Point calculateNewHead(Point head, char direction) {
        int x = head.x;
        int y = head.y;

        if (direction == 'L') {
            x = (x - 1 + BOARD_SIZE) % BOARD_SIZE;
        } else if (direction == 'R') {
            x = (x + 1) % BOARD_SIZE;
        } else if (direction == 'U') {
            y = (y - 1 + BOARD_SIZE) % BOARD_SIZE;
        } else if (direction == 'D') {
            y = (y + 1) % BOARD_SIZE;
        }

        return new Point(x, y);
    }

    private void checkCollision() {
        Point head1 = snake1.get(0);
        Point head2 = snake2.get(0);

        if (snake1.contains(head2) || snake2.contains(head1) || head1.equals(head2)) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over");
        }
    }

    private void checkFood() {
        if (snake1.get(0).equals(food) || snake2.get(0).equals(food)) {
            // Generate new food location
            food.setLocation(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
            // Increase the size of both snakes
            snake1.add(new Point(-1, -1));
            snake2.add(new Point(-1, -1));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw snakes
        g.setColor(Color.GREEN);
        for (Point p : snake1) {
            g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }

        g.setColor(Color.BLUE);
        for (Point p : snake2) {
            g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }

        // Draw food
        g.setColor(Color.RED);
        g.fillRect(food.x * CELL_SIZE, food.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    public static void main(String[] args) {
        
    }
    
     public void Iniciar (){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Snake Game");
                prueba vibora = new prueba();
                frame.add(vibora);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
