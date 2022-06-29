package com.example.PingPong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PingPongGameTests {

	//Checks title of the game
	@Test
	void checkTitle() {
		GameFrame frame = new GameFrame();
		String title = frame.getTitle();
		frame.setTitle("Ping-Pong Game");
		Assertions.assertEquals(frame.getTitle(), title);
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

}
