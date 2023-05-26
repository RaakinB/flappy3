import javax.swing.*;

public class GUI {
    public GUI () {
        initFrame1();
        initFrame2();
    }

    private void initFrame1() {
        JFrame jframe = new JFrame();
        FlappyBird fb = new FlappyBird();
        jframe.add(fb);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(FlappyBird.WIDTH, FlappyBird.HEIGHT);
        jframe.setTitle("Flappy Bird");
        jframe.setResizable(false);
        jframe.setVisible(true);
    }

    private void initFrame2() {
        JFrame jframe = new JFrame();
        Shop sh = new Shop();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(sh.WIDTH, sh.HEIGHT);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setTitle("Shop");
        jframe.repaint();

        JButton red = new JButton("Red");
        red.setSize(sh.WIDTH, sh.HEIGHT / 5);
        jframe.add(red);

        JButton blue = new JButton("blue");
        blue.setSize(sh.WIDTH, sh.HEIGHT / 5);
        blue.setLocation(0,(sh.HEIGHT / 5) * 2);
        jframe.add(blue);

        JButton green = new JButton("green");
        green.setSize(sh.WIDTH, sh.HEIGHT / 5);
        jframe.add(green);

        JButton purple = new JButton("purple");
        purple.setSize(sh.WIDTH, sh.HEIGHT / 5);
        jframe.add(purple);

        JButton white = new JButton("white");
        white.setSize(sh.WIDTH, sh.HEIGHT / 5);
        jframe.add(white);
    }
}
