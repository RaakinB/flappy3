import javax.swing.*;

public class GUI {
    FlappyBird fb = new FlappyBird();
    public GUI () {
        initFrame1();
        initFrame2();
    }

    private void initFrame1() {
        JFrame jframe = new JFrame();

        jframe.add(fb);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(FlappyBird.WIDTH, FlappyBird.HEIGHT);
        jframe.setTitle("Flappy Bird");
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocation(100,100);
    }

    private void initFrame2() {
        JFrame jframe = new JFrame();
        Shop sh = new Shop(fb);

        jframe.add(sh);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(sh.WIDTH, sh.HEIGHT);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setTitle("Shop");
        jframe.setLocation(900, 100);
        jframe.repaint();


    }
}
