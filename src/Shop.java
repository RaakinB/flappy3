import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Shop extends JPanel implements ActionListener {
    public static final int WIDTH = 400, HEIGHT = 800;
    public JButton red, blue, green, yellow, orange, pink;
    public JButton theme, bird;
    public JButton hellfire, ocean, candyland, minima, blackhole, valley;


    public boolean redOwned = false, blueOwned = false, greenOwned = false, yellowOwned = false, orangeOwned = false;
    private boolean isTheme = false;
    private String str1 = "50 Coins", str2 = "50 Coins", str3 = "50 Coins", str4 = "50 Coins", str5 = "50 Coins";
    private String Bstr1 = "500 Coins", Bstr2 = "400 Coins", Bstr3 = "300 Coins", Bstr4 = "200 Coins", Bstr5 = "100 Coins";
    public boolean hfOwned = false, oOwned = false, clOwned = false, mOwned = false, bhOwned = false;
    private FlappyBird fb;

    public Shop(FlappyBird fb) {
        setFont(new Font("Arial", 1, 100));


        this.fb = fb;

        red = new JButton("Red");
        red.setFont(new Font("Arial", 1, 20));
        red.setVisible(true);
        red.setBackground(Color.red.brighter());
        red.setBorderPainted(false);
        red.setForeground(Color.WHITE);
        red.setFocusPainted(false);

        add(red);
        red.addActionListener(this);

        blue = new JButton("Blue");
        blue.setFont(new Font("Arial", 1, 20));
        blue.setVisible(true);
        blue.setBackground(Color.blue.brighter());
        blue.setBorderPainted(false);
        blue.setForeground(Color.WHITE);
        blue.setFocusPainted(false);

        add(blue);
        blue.addActionListener(this);

        green = new JButton("Green");
        green.setFont(new Font("Arial", 1, 20));
        green.setVisible(true);
        green.setBackground(Color.green.brighter());
        green.setBorderPainted(false);
        green.setForeground(Color.WHITE);
        green.setFocusPainted(false);

        add(green);
        green.addActionListener(this);

        yellow = new JButton("Yellow");
        yellow.setFont(new Font("Arial", 1, 20));
        yellow.setVisible(true);
        yellow.setBackground(Color.yellow.brighter());
        yellow.setBorderPainted(false);
        yellow.setForeground(Color.WHITE);
        yellow.setFocusPainted(false);

        add(yellow);
        yellow.addActionListener(this);

        orange = new JButton("Orange");
        orange.setFont(new Font("Arial", 1, 17));
        orange.setVisible(true);
        orange.setBackground(Color.orange);
        orange.setBorderPainted(false);
        orange.setForeground(Color.WHITE);
        orange.setFocusPainted(false);

        add(orange);
        orange.addActionListener(this);

        pink = new JButton("Pink");
        pink.setFont(new Font("Arial", 1, 20));
        pink.setVisible(true);
        pink.setBackground(Color.pink);
        pink.setBorderPainted(false);
        pink.setForeground(Color.WHITE);
        pink.setFocusPainted(false);

        add(pink);
        pink.addActionListener(this);

        theme = new JButton("Theme");
        theme.setFont(new Font("Arial", 1, 20));
        theme.setVisible(true);
        theme.setBackground(Color.GRAY);
        theme.setBorderPainted(false);
        theme.setForeground(Color.WHITE);
        theme.setFocusPainted(false);

        add(theme);
        theme.addActionListener(this);

        bird = new JButton("Bird");
        bird.setFont(new Font("Arial", 1, 20));
        bird.setVisible(true);
        bird.setBackground(Color.GRAY);
        bird.setBorderPainted(false);
        bird.setForeground(Color.WHITE);
        bird.setFocusPainted(false);

        add(bird);
        bird.addActionListener(this);

        hellfire = new JButton("Hellfire");
        hellfire.setFont(new Font("Arial", 1, 20));
        hellfire.setVisible(false);
        hellfire.setBackground(Color.red.brighter());
        hellfire.setBorderPainted(false);
        hellfire.setForeground(Color.WHITE);
        hellfire.setFocusPainted(false);

        add(hellfire);
        hellfire.addActionListener(this);

        ocean = new JButton("Ocean");
        ocean.setFont(new Font("Arial", 1, 20));
        ocean.setVisible(false);
        ocean.setBackground(Color.blue.brighter());
        ocean.setBorderPainted(false);
        ocean.setForeground(Color.WHITE);
        ocean.setFocusPainted(false);

        add(ocean);
        ocean.addActionListener(this);

        candyland = new JButton("Candyland");
        candyland.setFont(new Font("Arial", 1, 20));
        candyland.setVisible(false);
        candyland.setBackground(Color.green.brighter());
        candyland.setBorderPainted(false);
        candyland.setForeground(Color.WHITE);
        candyland.setFocusPainted(false);

        add(candyland);
        candyland.addActionListener(this);

        minima = new JButton("Minima");
        minima.setFont(new Font("Arial", 1, 20));
        minima.setVisible(false);
        minima.setBackground(Color.yellow.brighter());
        minima.setBorderPainted(false);
        minima.setForeground(Color.WHITE);
        minima.setFocusPainted(false);

        add(minima);
        minima.addActionListener(this);

        blackhole = new JButton("Void");
        blackhole.setFont(new Font("Arial", 1, 17));
        blackhole.setVisible(false);
        blackhole.setBackground(Color.orange);
        blackhole.setBorderPainted(false);
        blackhole.setForeground(Color.WHITE);
        blackhole.setFocusPainted(false);

        add(blackhole);
        blackhole.addActionListener(this);

        valley = new JButton("Valley");
        valley.setFont(new Font("Arial", 1, 20));
        valley.setVisible(false);
        valley.setBackground(Color.pink);
        valley.setBorderPainted(false);
        valley.setForeground(Color.WHITE);
        valley.setFocusPainted(false);

        add(valley);
        valley.addActionListener(this);


    }





    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (text.equals("Red")) {
            if (fb.getCoins() >= 50 && !redOwned) {
                fb.updateCoins(-50);
                fb.setBirdColor(Color.red);
                redOwned = true;
                str1 = "Owned";
                repaint();
            } else if (redOwned) {

                fb.setBirdColor(Color.red);
            }

        } else if (text.equals("Blue")) {
            if (fb.getCoins() >= 50 && !blueOwned) {
                fb.updateCoins(-50);
                fb.setBirdColor(Color.blue);
                blueOwned = true;
                str2 = "Owned";
                repaint();
            } else if (blueOwned) {

                fb.setBirdColor(Color.blue);
            }

        } else if (text.equals("Green")) {
            if (fb.getCoins() >= 50 && !greenOwned) {
                fb.updateCoins(-50);
                fb.setBirdColor(Color.green);
                greenOwned = true;
                str3 = "Owned";
                repaint();
            } else if (greenOwned) {

                fb.setBirdColor(Color.green);
            }

        } else if (text.equals("Yellow")) {
            if (fb.getCoins() >= 50 && !yellowOwned) {
                fb.updateCoins(-50);
                fb.setBirdColor(Color.yellow);
                yellowOwned = true;
                str4 = "Owned";
                repaint();
            } else if (yellowOwned) {

                fb.setBirdColor(Color.yellow);
            }

        } else if (text.equals("Orange")) {
            if (fb.getCoins() >= 50 && !orangeOwned) {
                fb.updateCoins(-50);
                fb.setBirdColor(Color.orange);
                orangeOwned = true;
                str5 = "Owned";
                repaint();
            } else if (orangeOwned) {

                fb.setBirdColor(Color.orange);
            }

        } else if (text.equals("Pink")) {

                fb.setBirdColor(Color.pink);


        } else if (text.equals("Theme")) {
            isTheme = true;
            red.setVisible(false);
            blue.setVisible(false);
            green.setVisible(false);
            yellow.setVisible(false);
            orange.setVisible(false);
            pink.setVisible(false);

            hellfire.setVisible(true);
            ocean.setVisible(true);
            candyland.setVisible(true);
            minima.setVisible(true);
            blackhole.setVisible(true);
            valley.setVisible(true);


            repaint();
        } else if (text.equals("Bird")) {
            isTheme = false;
            red.setVisible(true);
            blue.setVisible(true);
            green.setVisible(true);
            yellow.setVisible(true);
            orange.setVisible(true);
            pink.setVisible(true);

            hellfire.setVisible(false);
            ocean.setVisible(false);
            candyland.setVisible(false);
            minima.setVisible(false);
            blackhole.setVisible(false);
            valley.setVisible(false);

            repaint();
        } else if (text.equals("Hellfire")) {
            if (fb.getCoins() >= 500 && !hfOwned) {
                fb.updateCoins(-500);
                fb.setTheme("Hellfire");
                hfOwned = true;
                Bstr1 = "Owned";
                repaint();
                fb.repaint();
            } else if (hfOwned) {

                fb.setTheme("Hellfire");
            }
        }else if (text.equals("Ocean")) {
            if (fb.getCoins() >= 400 && !oOwned) {
                fb.updateCoins(-400);
                fb.setTheme("Ocean");
                oOwned = true;
                Bstr2 = "Owned";
                repaint();
                fb.repaint();
            } else if (oOwned) {

                fb.setTheme("Ocean");
            }
        }else if (text.equals("Candyland")) {
            if (fb.getCoins() >= 300 && !clOwned) {
                fb.updateCoins(-300);
                fb.setTheme("Candyland");
                clOwned = true;
                Bstr3 = "Owned";
                repaint();
                fb.repaint();
            } else if (clOwned) {

                fb.setTheme("Candyland");
            }
        }else if (text.equals("Minima")) {
            if (fb.getCoins() >= 200 && !mOwned) {
                fb.updateCoins(-200);
                fb.setTheme("Minima");
                mOwned = true;
                Bstr4 = "Owned";
                repaint();
                fb.repaint();
            } else if (mOwned) {

                fb.setTheme("Minima");
            }
        }else if (text.equals("Void")) {
            if (fb.getCoins() >= 100 && !bhOwned) {
                fb.updateCoins(-100);
                fb.setTheme("Void");
                bhOwned = true;
                Bstr5 = "Owned";
                repaint();
                fb.repaint();
            } else if (bhOwned) {

                fb.setTheme("Void");
            }
        }else if (text.equals("Valley")) {
                fb.setTheme("Valley");


                repaint();
                fb.repaint();

        }


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon ii = new ImageIcon("src/bgFinal.jpg");
        Image i = ii.getImage();
        g.drawImage(i, 0, 0, null);
        g.setFont(new Font("Arial", 1, 50));
        g.setColor(Color.orange.darker());
        g.drawString("SHOP", WIDTH /2 - 75, 56);
        g.setColor(Color.orange);
        g.drawString("SHOP", WIDTH /2 - 75, 50);
        g.setFont(new Font("Arial", 1, 13));
        g.setColor(Color.white.darker());
        g.drawString("Important: Bird color and Theme colors may overlap!", 31, 116);
        g.setColor(Color.white);
        g.drawString("Important: Bird color and Theme colors may overlap!", 31, 115);
        g.setFont(new Font("Arial", 1, 30));
        g.setColor(Color.orange);
        if (!isTheme) {
            g.drawString(str1, WIDTH - 350, 185);
            g.drawString(str2, WIDTH - 350, 285);
            g.drawString(str3, WIDTH - 350, 385);
            g.drawString(str4, WIDTH - 350, 485);
            g.drawString(str5, WIDTH - 350, 585);
            g.drawString("Default", WIDTH - 350, 685);


            g.setColor(Color.red.darker());
            g.fillRect(WIDTH - 150, 155, 100, 50);
            red.setSize(100,50);
            red.setLocation(WIDTH - 150,150);

            g.setColor(Color.blue.darker());
            g.fillRect(WIDTH - 150, 255, 100, 50);
            blue.setSize(100,50);
            blue.setLocation(WIDTH - 150,250);

            g.setColor(Color.green.darker());
            g.fillRect(WIDTH - 150, 355, 100, 50);
            green.setSize(100,50);
            green.setLocation(WIDTH - 150,350);

            g.setColor(Color.yellow.darker());
            g.fillRect(WIDTH - 150, 455, 100, 50);
            yellow.setSize(100,50);
            yellow.setLocation(WIDTH - 150,450);

            g.setColor(Color.orange.darker());
            g.fillRect(WIDTH - 150, 555, 100, 50);
            orange.setSize(100,50);
            orange.setLocation(WIDTH - 150,550);

            g.setColor(Color.pink.darker());
            g.fillRect(WIDTH - 150, 655, 100, 50);
            pink.setSize(100,50);
            pink.setLocation(WIDTH - 150,650);
        } else {
            g.drawString(Bstr1, WIDTH - 350, 185);
            g.drawString(Bstr2, WIDTH - 350, 285);
            g.drawString(Bstr3, WIDTH - 350, 385);
            g.drawString(Bstr4, WIDTH - 350, 485);
            g.drawString(Bstr5, WIDTH - 350, 585);
            g.drawString("Default", WIDTH - 350, 685);

            g.setColor(Color.red.darker());
            g.fillRect(WIDTH - 180, 155, 150, 50);
            hellfire.setSize(150,50);
            hellfire.setLocation(WIDTH - 180,150);

            g.setColor(Color.blue.darker());
            g.fillRect(WIDTH - 180, 255, 150, 50);
            ocean.setSize(150,50);
            ocean.setLocation(WIDTH - 180,250);

            g.setColor(Color.green.darker());
            g.fillRect(WIDTH - 180, 355, 150, 50);
            candyland.setSize(150,50);
            candyland.setLocation(WIDTH - 180,350);

            g.setColor(Color.yellow.darker());
            g.fillRect(WIDTH - 180, 455, 150, 50);
            minima.setSize(150,50);
            minima.setLocation(WIDTH - 180,450);

            g.setColor(Color.orange.darker());
            g.fillRect(WIDTH - 180, 555, 150, 50);
            blackhole.setSize(150,50);
            blackhole.setLocation(WIDTH - 180,550);

            g.setColor(Color.pink.darker());
            g.fillRect(WIDTH - 180, 655, 150, 50);
            valley.setSize(150,50);
            valley.setLocation(WIDTH - 180,650);
        }


        g.setColor(Color.GRAY.darker());
        g.fillRect(10, 10, 100, 55);
        theme.setSize(100,50);
        theme.setLocation(10, 10);

        g.setColor(Color.GRAY.darker());
        g.fillRect(WIDTH - 123, 10, 100, 55);
        bird.setSize(100,50);
        bird.setLocation(WIDTH - 123, 10);
    }


}