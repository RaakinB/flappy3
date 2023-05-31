import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Shop extends JPanel implements ActionListener {
    public static final int WIDTH = 400, HEIGHT = 800;





    public Shop() {

    }





    @Override
    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0,0, WIDTH, HEIGHT);

        g.setColor(Color.orange);
        g.fillRect(0, HEIGHT - 120, WIDTH, 120);

        g.setColor(Color.green);
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);





    }






}