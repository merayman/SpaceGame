package controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import game.*;
import engine.*;
import engine.Level.MouseCode;

public class GameControl implements KeyListener, MouseListener, MouseMotionListener{
	private Game spaceGame;
	private GameScreen gameScreen;
	private Level currentLevel;
	private boolean K_UP = false, K_LEFT = false, K_RIGHT = false, K_DOWN = false;
	private Timer gameTimer;
	private TimerTask frame;
	
	public GameControl(Game game, GameScreen gameScreen){
		currentLevel = game.getLevel();
		gameScreen.setActorCollection(currentLevel);
		this.spaceGame = game;
		this.gameScreen = gameScreen;
		spaceGame.atStart();
		gameTimer = new Timer();
		frame = new TimerTask(){
			public void run() {
				if(K_UP){
					spaceGame.getLevel().upPressed();
				}
				
				if(K_DOWN){
					spaceGame.getLevel().downPressed();
				}
				
				if(K_LEFT){
					spaceGame.getLevel().leftPressed();
				}
					
				if(K_RIGHT){
					spaceGame.getLevel().rightPressed();
				}
				
				spaceGame.tick();
				if(currentLevel!=spaceGame.getLevel()){
					currentLevel = spaceGame.getLevel();
					gameScreen.setActorCollection(spaceGame.getLevel());
				}
				gameScreen.repaint();
			}
		};
		gameTimer.schedule(frame, 0, 10);
	}
	
	private Point getArtificialCenter(){
		Point artificialCenter = new Point();
		Actor centerObject = spaceGame.getLevel().getCenterActor();
		int x, y;
		x = gameScreen.getWidth()/2-centerObject.getWidth()/2;
		y = gameScreen.getHeight()/2-centerObject.getHeight()/2;
		x = centerObject.getX()-x;
		y = centerObject.getY()-y;
		artificialCenter.setLocation(x, y);
		return artificialCenter;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point artificialCenter = getArtificialCenter();
		if(e.getButton()==MouseEvent.BUTTON1){
			spaceGame.getLevel().mousePressed(MouseCode.RIGHT,
					e.getX() + (int)artificialCenter.getX(),
					e.getY() + (int)artificialCenter.getY());
		}
		else if(e.getButton()==MouseEvent.BUTTON2){
			spaceGame.getLevel().mousePressed(MouseCode.LEFT,
					e.getX() + (int)artificialCenter.getX(),
					e.getY() + (int)artificialCenter.getY());
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_W || keyCode==KeyEvent.VK_UP)
			K_UP = true;
		
		if(keyCode==KeyEvent.VK_A || keyCode==KeyEvent.VK_LEFT)
			K_LEFT = true;
			
		if(keyCode==KeyEvent.VK_D || keyCode==KeyEvent.VK_RIGHT)
			K_RIGHT = true;
		
		if(keyCode==KeyEvent.VK_S || keyCode==KeyEvent.VK_DOWN)
			K_DOWN = true;
		
		if(keyCode==KeyEvent.VK_SPACE)
			spaceGame.getLevel().spacePressed();
		else if(keyCode==KeyEvent.VK_ESCAPE){
			spaceGame.getLevel().escapePressed();
		}
		else if(keyCode==KeyEvent.VK_ENTER){
			spaceGame.getLevel().enterPressed();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_W || keyCode==KeyEvent.VK_UP)
			K_UP = false;
		
		if(keyCode==KeyEvent.VK_A || keyCode==KeyEvent.VK_LEFT)
			K_LEFT = false;
			
		if(keyCode==KeyEvent.VK_D || keyCode==KeyEvent.VK_RIGHT)
			K_RIGHT = false;
		
		if(keyCode==KeyEvent.VK_S || keyCode==KeyEvent.VK_DOWN)
			K_DOWN = false;
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
