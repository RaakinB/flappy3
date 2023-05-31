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

        jframe.add(sh);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(sh.WIDTH, sh.HEIGHT);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setTitle("Shop");
        jframe.repaint();


    }
}
