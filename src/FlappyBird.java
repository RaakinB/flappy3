import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener, MouseListener, KeyListener {
    public static final int WIDTH = 800, HEIGHT = 800;

    public String theme = "Valley";
    public Color birdColor = Color.pink;
    public Rectangle bird;

    public int ticks, yMotion, score, MAX = 0, Coins = 0;
    public boolean gameOver, started;
    public ArrayList<Rectangle> columns;

    public Random rand;
    public FlappyBird() {
        rand = new Random();
        Timer timer = new Timer(20, this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        bird = new Rectangle(WIDTH/2 - 10, HEIGHT / 2 - 10, 20,20);
        columns = new ArrayList<Rectangle>();
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        timer.start();
    }

    public void addColumn(boolean start) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        if (start) {
            columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120,width, height));
            columns.add(new Rectangle(WIDTH + width + ((columns.size() - 1) * 300), 0, width, HEIGHT - height - space));
        } else {
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
        }
    }
    public void paintColumn(Graphics g, Rectangle column) {
        if (theme.equals("Valley")) {
            g.setColor(Color.red.darker());
            g.fillRect(column.x, column.y, column.width, column.height);
        } else if (theme.equals("Hellfire")) {
            g.setColor(Color.orange);
            g.fillRect(column.x, column.y, column.width, column.height);
        }else if (theme.equals("Ocean")) {
            g.setColor(Color.blue.darker());
            g.fillRect(column.x, column.y, column.width, column.height);
        }else if (theme.equals("Candyland")) {
            g.setColor(Color.pink.darker());
            g.fillRect(column.x, column.y, column.width, column.height);
        }else if (theme.equals("Minima")) {
            g.setColor(Color.white.darker());
            g.fillRect(column.x, column.y, column.width, column.height);
        }else if (theme.equals("Void")) {
            g.setColor(Color.gray);
            g.fillRect(column.x, column.y, column.width, column.height);
        }

    }

    public void jump() {
        if (gameOver) {
            bird = new Rectangle(WIDTH/2 - 10, HEIGHT / 2 - 10, 20,20);
            columns.clear();
            columns = new ArrayList<Rectangle>();
            yMotion = 0;
            if (score > MAX ) {
                MAX = score;
                Coins += score;
            }

            score = 0;

            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);
            gameOver = false;
        }
        if (!started) {
            started = true;
        } else if (!gameOver){
            if (yMotion > 0) {
                yMotion = 0;
            }

            yMotion -= 10;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 10;
        ticks++;

        if (started) {
            for(int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                column.x -= speed;
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion+= 2;
            }

            for(int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                if (column.x + column.width < 0 ) {
                    columns.remove(column);
                    if (column.y == 0) {
                        addColumn(false);
                    }

                }

            }
            bird.y += yMotion;

            for (Rectangle column : columns) {
                if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10) {
                    score++;
                    Coins++;

                }
                if (column.intersects(bird)) {
                    gameOver = true;
                    if (bird.x <= column.x) {
                        bird.x = column.x - bird.width;
                    } else {
                        if (column.y != 0) {
                            bird.y = column.y - bird.height;
                        } else if (bird.y < column.height) {
                            bird.y = column.height;
                        }
                    }

                }
            }

            if (bird.y > HEIGHT - 120 || bird.y < 0) {

                gameOver = true;

            }
            if (bird.y + yMotion >= HEIGHT - 120) {
                bird.y = HEIGHT - 120 - bird.height;
            }
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (theme.equals("Hellfire")) {
            g.setColor(Color.red);
            g.fillRect(0,0, WIDTH, HEIGHT);
            g.setColor(Color.black);
            g.fillOval(-100,-100, 200, 200);
            g.setColor(Color.black);
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);
            g.setColor(Color.black);
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);
        } else if (theme.equals("Ocean")){
            g.setColor(Color.cyan);
            g.fillRect(0,0, WIDTH, HEIGHT);
            g.setColor(Color.yellow);
            g.fillOval(-100,-100, 200, 200);
            g.setColor(Color.blue.darker());
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);
            g.setColor(Color.blue);
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);

        } else if (theme.equals("Candyland")){
            g.setColor(Color.MAGENTA);
            g.fillRect(0,0, WIDTH, HEIGHT);
            g.setColor(Color.yellow);
            g.fillOval(-100,-100, 200, 200);
            g.setColor(Color.pink);
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);
            g.setColor(Color.pink.darker());
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);

        }else if (theme.equals("Minima")){
            g.setColor(Color.white);
            g.fillRect(0,0, WIDTH, HEIGHT);
            g.setColor(Color.black);
            g.fillOval(-100,-100, 200, 200);
            g.setColor(Color.white);
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);
            g.setColor(Color.white);
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);

        }else if (theme.equals("Void")){
            g.setColor(Color.black);
            g.fillRect(0,0, WIDTH, HEIGHT);
            g.setColor(Color.gray);
            g.fillOval(-100,-100, 200, 200);
            g.setColor(Color.gray);
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);
            g.setColor(Color.lightGray);
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);

        } else {
            g.setColor(Color.cyan);
            g.fillRect(0,0, WIDTH, HEIGHT);

            g.setColor(Color.yellow);
            g.fillOval(-100,-100, 200, 200);

            g.setColor(Color.orange);
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);

            g.setColor(Color.green);
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);
        }








        g.setColor(birdColor);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        for (Rectangle column : columns) {
            paintColumn(g, column);
        }

        if (theme.equals("Minima")) {
            g.setColor(Color.gray);
        } else {
            g.setColor(Color.white);
        }


        g.setFont(new Font("Arial", 1, 30));
        g.drawString("High Score: " + MAX, WIDTH - 275, 50);

        g.setColor(Color.orange);
        g.drawString("Coins: " + Coins, WIDTH - 200, 85);

        if (theme.equals("Minima")) {
            g.setColor(Color.gray);
        } else {
            g.setColor(Color.white);
        }
        g.setFont(new Font("Arial", 1, 100));
        if (!started) {
//            g.setFont(new Font("Arial", 1, 30));
//            g.drawString("High Score: " + String.valueOf(MAX), WIDTH / 2 - 300, 75);
            g.setFont(new Font("Arial", 1, 50));
            g.drawString("Click or Space to Start!", 125, HEIGHT / 2 - 50);
        }
        if (gameOver) {
//            g.setFont(new Font("Arial", 1, 30));
//            g.drawString("High Score: " +String.valueOf(MAX), WIDTH / 2 - 300, 75);
            g.setFont(new Font("Arial", 1, 35));
            g.drawString("Game Over! Click or Space to restart.", 110, HEIGHT / 2 - 50);

        }
        if (!gameOver && started) {
//            g.setFont(new Font("Arial", 1, 30));
//            g.drawString("High Score: " +String.valueOf(MAX), WIDTH / 2 - 300, 75);
            g.setFont(new Font("Arial", 1, 100));
            g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
        }



    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jump();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    public void setBirdColor(Color color) {
        birdColor = color;
    }


    public int getCoins() {
        return Coins;
    }

    public void updateCoins(int update) {
        Coins += update;
    }
    public void setTheme(String newTheme) {theme = newTheme;}

}


