package com.example.PingPong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddleOne;
    Paddle paddleTwo;
    Ball ball;
    Score score;

    GamePanel() {

        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void  newBall() {
        //random = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2),
                (GAME_HEIGHT / 2)- (BALL_DIAMETER / 2),
                BALL_DIAMETER, BALL_DIAMETER);
    }
    public void newPaddles() {

        paddleOne = new Paddle(0,(GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddleTwo = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    public void draw(Graphics g) {
        paddleOne.draw(g);
        paddleTwo.draw(g);
        ball.draw(g);
    }
    public void move() {
        paddleOne.move();
        paddleTwo.move();
        ball.move();
    }
    public void checkCollision() {
        //Stop paddles at widows frame edges
        if (paddleOne.y <= 0) {
            paddleOne.y = 0;
        }
        if (paddleOne.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
            paddleOne.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
        if (paddleTwo.y <= 0) {
            paddleTwo.y = 0;
        }
        if (paddleTwo.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
            paddleTwo.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
    }
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            paddleOne.keyPressed(e);
            paddleTwo.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddleOne.keyReleased(e);
            paddleTwo.keyReleased(e);
        }
    }
}
