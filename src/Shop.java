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



    private FlappyBird fb;

    public Shop(FlappyBird fb) {
        setFont(new Font("Arial", 1, 100));






        this.fb = fb;

        red = new JButton("Red");
        red.setFont(new Font("Arial", 1, 15));
        red.setVisible(true);
        add(red);
        red.addActionListener(this);

        blue = new JButton("Blue");
        blue.setFont(new Font("Arial", 1, 15));
        blue.setVisible(true);
        add(blue);
        blue.addActionListener(this);

        green = new JButton("Green");
        green.setFont(new Font("Arial", 1, 15));
        green.setVisible(true);
        add(green);
        green.addActionListener(this);

        yellow = new JButton("Yellow");
        yellow.setFont(new Font("Arial", 1, 15));
        yellow.setVisible(true);
        add(yellow);
        yellow.addActionListener(this);

        orange = new JButton("Orange");
        orange.setFont(new Font("Arial", 1, 15));
        orange.setVisible(true);
        add(orange);
        orange.addActionListener(this);

        pink = new JButton("Pink");
        pink.setFont(new Font("Arial", 1, 15));
        pink.setVisible(true);
        add(pink);
        pink.addActionListener(this);


    }





    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (text.equals("Red")) {
            fb.setBirdColor(Color.red);
        } else if (text.equals("Blue")) {
            fb.setBirdColor(Color.blue);
        } else if (text.equals("Green")) {
            fb.setBirdColor(Color.green);
        } else if (text.equals("Yellow")) {
            fb.setBirdColor(Color.yellow);
        } else if (text.equals("Orange")) {
            fb.setBirdColor(Color.orange);
        } else if (text.equals("Pink")) {
            fb.setBirdColor(Color.pink);
        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        g.setFont(new Font("Arial", 1, 30));
        g.setColor(Color.orange);
        g.drawString("SHOP", WIDTH /2 - 60, 50);

        red.setSize(100,50);
        red.setLocation(WIDTH - 200,100);
        red.setBackground(Color.red.brighter());
        red.setBorderPainted(false);

        blue.setSize(100,50);
        blue.setLocation(WIDTH - 200,200);
        blue.setBackground(Color.blue.brighter());
        blue.setBorderPainted(false);

        green.setSize(100,50);
        green.setLocation(WIDTH - 200,300);
        green.setBackground(Color.green.brighter());
        green.setBorderPainted(false);

        yellow.setSize(100,50);
        yellow.setLocation(WIDTH - 200,400);
        yellow.setBackground(Color.yellow.brighter());
        yellow.setBorderPainted(false);

        orange.setSize(100,50);
        orange.setLocation(WIDTH - 200,500);
        orange.setBackground(Color.orange.brighter());
        orange.setBorderPainted(false);

        pink.setSize(100,50);
        pink.setLocation(WIDTH - 200,600);
        pink.setBackground(Color.pink);
        pink.setBorderPainted(false);




        setBackground(Color.gray);
    }


}