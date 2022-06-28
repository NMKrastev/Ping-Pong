package com.example.PingPong;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;

class PingPongGameTests {

	GamePanel panel;

	@Test
	void createFrame() {

		GameFrame frame = new GameFrame();
		panel = new GamePanel();
		frame.add(panel);
		frame.setTitle("Ping-Pong Game");
		frame.setResizable(false);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}
}
