import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Board extends JPanel implements ActionListener{
	private Updates Updates=new Updates();
	private Hero Hero=new Hero();
	private Wall Wall=new Wall();
	private Enemy Enemy=new Enemy();
	private Timer timer;
	private boolean ingame;
	public int width=10000,tileWidth=20,height=10000,tileHeight=20;
	fireBall fb=new fireBall();
	ArrayList ms=Updates.getFireBall();
	public Board(){
		addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame=true;
        setSize(800, 600);
        Updates.initAll();
        timer=new Timer(5, this);
        timer.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		if(ingame=true){
			g.translate(-Updates.hero_getX()+425,-Updates.hero_getY()+325);
			
			g.drawImage(Updates.back_getImage(),-2500,-2500, this);
			if(Hero.isVisible())
                g.drawImage(Hero.getImage(),Updates.hero_getX(),Updates.hero_getY(),this);
            for(int i=0;i<ms.size();i++){
                fireBall m=(fireBall)ms.get(i);
                g.drawImage(m.getImage(),m.getX(),m.getY(),this);
            }
            for (int i=0;i<Updates.getEnemySize();i++){
                Enemy a=(Enemy)Updates.getEnemys().get(i);
                if(a.isVisible())
                    g.drawImage(a.getImage(),a.getX(),a.getY(),this);
            }
            for (int i=0;i<Updates.getWallSize();i++){
                Wall a=(Wall)Updates.getWall().get(i);
                if(a.isVisible())
                    g.drawImage(a.getImage(),a.getX(),a.getY(),this);
            }
            g.setColor(Color.WHITE);
            g.drawString("HEALTH: "+Hero.getHealth(),Updates.hero_getX()-425,Updates.hero_getY()-293);
            g.drawString("MAGICA:  "+Enemy.getHealth(),Updates.hero_getX()-425,Updates.hero_getY()-271);
		}
		Toolkit.getDefaultToolkit().sync();
        g.dispose();
	}
	public void actionPerformed(ActionEvent e){
		ArrayList ms = Updates.getFireBall();
        for (int i = 0; i < ms.size(); i++) {
            fireBall m = (fireBall) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }
        //movement code make this move along with the rest of the background
        for (int i=0;i<Updates.getEnemySize();i++){
            Enemy a=(Enemy)Updates.getEnemys().get(i);
            if(a.isVisible()) 
                a.move();
            else Updates.getEnemys().remove(i);
        }
        
        Updates.move();
        checkCollisions();
        repaint();
    }
	public void checkCollisions(){
		//if(w.intersects(hero)){Updates.changeXY();}
		//if(hero.intersects(e)){Hero.health(-.2,0);}
		Rectangle r3=Hero.getBounds();
        for (int j=0;j<Updates.getEnemySize();j++){
            Enemy a=(Enemy)Updates.getEnemys().get(j);
            Rectangle r2=a.getBounds();
            if(r3.intersects(r2)){
                Hero.setVisible(false);
                a.setVisible(false);
                ingame=false;
            }
        }
        Rectangle r=Hero.getBounds();
        for (int j=0;j<Updates.getWallSize();j++){
            Wall a=(Wall)Updates.getWall().get(j);
            Rectangle r2=a.getBounds();
            if(r.intersects(r2)){
                Updates.hero_getX();
            }
        }
        ArrayList ms = Updates.getFireBall();
        for(int i=0;i<ms.size();i++) {
            fireBall fb=(fireBall)ms.get(i);
            Rectangle r1=fb.getBounds();
            for(int j=0;j<Updates.getEnemySize();j++) {
                Enemy a=(Enemy)Updates.getEnemys().get(j);
                Rectangle r2=a.getBounds();
                if(r1.intersects(r2)){
                	Enemy.health(-10,0);
                    fb.setVisible(false);
                }
            }
        }
        Enemy a=new Enemy();
        fireBall fb=new fireBall();
        if(a.getVisible()==false){
        	fb.setVisible(false);
        }
    }
	private class TAdapter extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            Updates.keyReleased(e);
        }
        public void keyPressed(KeyEvent e){
            Updates.keyPressed(e);
        }
    }
}
