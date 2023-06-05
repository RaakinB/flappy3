import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Shop extends JPanel implements ActionListener {
    public static final int WIDTH = 400, HEIGHT = 800;
    public JButton red;
    public JButton blue;
    public JButton green;
    public JButton yellow;
    public JButton orange;
    public JButton pink;

    public boolean redOwned = false, blueOwned = false, greenOwned = false, yellowOwned = false, orangeOwned = false;

    private String str1 = "100 Coins", str2 = "100 Coins", str3 = "100 Coins", str4 = "100 Coins", str5 = "100 Coins";
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
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (text.equals("Red")) {
            if (fb.getCoins() >= 100 && !redOwned) {
                fb.updateCoins(-100);
                fb.setBirdColor(Color.red);
                redOwned = true;
                str1 = "Owned";
                repaint();
            } else if (redOwned) {

                fb.setBirdColor(Color.red);
            }

        } else if (text.equals("Blue")) {
            if (fb.getCoins() >= 100 && !blueOwned) {
                fb.updateCoins(-100);
                fb.setBirdColor(Color.blue);
                blueOwned = true;
                str2 = "Owned";
                repaint();
            } else if (blueOwned) {

                fb.setBirdColor(Color.blue);
            }

        } else if (text.equals("Green")) {
            if (fb.getCoins() >= 100 && !greenOwned) {
                fb.updateCoins(-100);
                fb.setBirdColor(Color.green);
                greenOwned = true;
                str3 = "Owned";
                repaint();
            } else if (greenOwned) {

                fb.setBirdColor(Color.green);
            }

        } else if (text.equals("Yellow")) {
            if (fb.getCoins() >= 100 && !yellowOwned) {
                fb.updateCoins(-100);
                fb.setBirdColor(Color.yellow);
                yellowOwned = true;
                str4 = "Owned";
                repaint();
            } else if (yellowOwned) {

                fb.setBirdColor(Color.yellow);
            }

        } else if (text.equals("Orange")) {
            if (fb.getCoins() >= 100 && !orangeOwned) {
                fb.updateCoins(-100);
                fb.setBirdColor(Color.orange);
                orangeOwned = true;
                str5 = "Owned";
                repaint();
            } else if (orangeOwned) {

                fb.setBirdColor(Color.orange);
            }

        } else if (text.equals("Pink")) {

                fb.setBirdColor(Color.pink);


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

        g.setFont(new Font("Arial", 1, 30));
        g.setColor(Color.orange);




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
        //setBackground(Color.gray);
    }


}