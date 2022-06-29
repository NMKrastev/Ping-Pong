package com.example.PingPong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static java.awt.Color.*;
import static java.awt.Color.blue;

class PingPongGameTests {

	GameFrame frame = new GameFrame();
	GamePanel panel = new GamePanel();
	int GAME_WIDTH = 1000;
	int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	int BALL_DIAMETER = 20;
	int PADDLE_WIDTH = 25;
	int PADDLE_HEIGHT = 100;
	//Checks title of the game.
	@Test
	void checkTitle() {
		Assertions.assertEquals("Ping-Pong Game", frame.getTitle());
	}

	//Checks if the window is resizeable
	@Test
	void checkResizeAbility() {
		Assertions.assertEquals(false, frame.isResizable());
	}

	//Checks if the background color is black
	@Test
	void checkBackgroundColor() {
		Assertions.assertEquals(black, frame.getBackground());
	}

	//Checks DefaultCloseOperation
	@Test
	void checkDefaultCloseOperation() {
		Assertions.assertEquals(JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());
	}

	//Checks visibility
	@Test
	void checkVisibility() {
		Assertions.assertEquals(true, frame.isVisible());
	}



	//Checks window dimensions
	@Test
	void checkWindowDimensions() {
		Assertions.assertEquals(1000, GamePanel.GAME_WIDTH);
		Assertions.assertEquals((int)(1000 * 0.5555), GamePanel.GAME_HEIGHT);
	}

	//Checks if the paddles dimensions
	@Test
	void checkPaddleDimensions() {
		Assertions.assertEquals(25, GamePanel.PADDLE_WIDTH);
		Assertions.assertEquals(100, GamePanel.PADDLE_HEIGHT);
	}

	//Checks ball diameter
	@Test
	void checkBallDiameter() {
		Assertions.assertEquals(20, GamePanel.BALL_DIAMETER);
	}

	//Checks creation of the same paddles as needed
	@Test
	void createNewPaddles() {

		Paddle paddleOne = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
				PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		Paddle paddleTwo = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
				PADDLE_WIDTH, PADDLE_HEIGHT, 2);
		Assertions.assertEquals(paddleOne, panel.paddleOne);
		Assertions.assertEquals(paddleTwo, panel.paddleTwo);
	}
}
