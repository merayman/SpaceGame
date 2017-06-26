package gui;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import game.GameObject;
import game.Level;
import game.Drawable;

public class GameControl implements KeyListener, MouseListener, MouseMotionListener{
	private Level spaceGame;
	private GameScreen gameScreen;
	private boolean K_UP = false, K_LEFT = false, K_RIGHT = false, K_DOWN = false;
	
	public GameControl(Level spaceGame, GameScreen gameScreen){
		this.spaceGame = spaceGame;
		this.gameScreen = gameScreen;
		spaceGame.atStart();
		Timer gameTimer = new Timer();
		TimerTask frame = new TimerTask(){
			public void run() {
				if(K_UP){
					spaceGame.upPressed();
				}
				
				if(K_DOWN){
					spaceGame.downPressed();
				}
				
				if(K_LEFT){
					spaceGame.leftPressed();
				}
					
				if(K_RIGHT){
					spaceGame.rightPressed();
				}
				
				spaceGame.tick();
				gameScreen.repaint();
			}
		};
		gameTimer.schedule(frame, 0, 10);
	}
	
	private Point getArtificialCenter(){
		Point artificialCenter = new Point();
		GameObject centerObject = spaceGame.getCenterActor();
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
		spaceGame.mousePressed(e.getX() + (int)artificialCenter.getX(), e.getY() + (int)artificialCenter.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("key typed");
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

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
