package com.example.PingPong;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

class PingPongGameTests {

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	PaddleTest paddleOne;
	PaddleTest paddleTwo;

	@Test
	void createPaddles() {

		paddleOne = new PaddleTest(0,(GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
				PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddleTwo = new PaddleTest(GAME_WIDTH - PADDLE_WIDTH, (GAME_WIDTH / 2) - (PADDLE_HEIGHT / 2),
				PADDLE_WIDTH, PADDLE_HEIGHT, 2);

	}

	public class PaddleTest extends Rectangle {

		int id;
		//int yVelocity;

		PaddleTest(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
			super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
			this.id = id;
		}
	}
}
