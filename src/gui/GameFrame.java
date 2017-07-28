package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GameControl;
import engine.*;
import game.*;

import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		
		//Game screen
		GameScreen gameScreen = new GameScreen();
		contentPane.add(gameScreen, BorderLayout.CENTER);
		//initialize the entrance
		Entrance entranceLevel = new Entrance();
		//set the game
		SpaceGame spaceGame = new SpaceGame();
		//create game control
		GameControl gameControl = new GameControl(spaceGame, gameScreen);
		//add listeners
		addKeyListener(gameControl);
		addMouseListener(gameControl);
		addMouseMotionListener(gameControl);
	}

}
