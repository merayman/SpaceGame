package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Drawable;
import game.Drawable.DrawType;
import game.Drawable.DrawingLayout;
import game.Level;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		GameScreen gameScreen = new GameScreen();
		Level spaceGame = new Level();
		gameScreen.addActorCollection(spaceGame);
		contentPane.add(gameScreen, BorderLayout.CENTER);
		GameControl gameControl = new GameControl(spaceGame, gameScreen);
		addKeyListener(gameControl);
		addMouseListener(gameControl);
		addMouseMotionListener(gameControl);
	}

}