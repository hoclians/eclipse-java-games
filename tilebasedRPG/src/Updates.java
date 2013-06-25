import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class Updates{
    private String tiles="back.png";
    private static int hero_x=425,hero_y=325,hero_dx,hero_dy;
	private int w_x=100,w_y=100,enemy_x=64,enemy_y=32,width,height,w_width,w_height;
    private boolean visible;
    private Image back,w_tile;
    static Hero Hero=new Hero();
    private static ArrayList fireBall,Wall,Enemys,Walls;
    fireBall fb=new fireBall();
    Wall wa=new Wall();
    public Updates(){
    	//Images
    	fireBall=new ArrayList();
        ImageIcon ii = new ImageIcon(this.getClass().getResource(tiles));
        back = ii.getImage();
        width = back.getWidth(null);
        height = back.getHeight(null);
    }
    public ArrayList getFireBall(){
        return fireBall;
    }
    public static void shootFireBall(){
        fireBall.add(new fireBall(hero_x,hero_y));
    }
    public void move(){
        hero_x+=hero_dx;
        hero_y+=hero_dy;
    }
    public int changeXY(){
    	if(w_x>Hero.getX()){w_x++;hero_x++;enemy_x++;}
    	if(w_x<Hero.getX()){w_x--;hero_x--;enemy_x--;}
    	if(w_y>Hero.getY()){w_y++;hero_y++;enemy_y++;}
    	if(w_y<Hero.getY()){w_y--;hero_y--;enemy_y--;}
    	return 0;
    }
    public static int hero_getX(){return hero_x;}
    public int hero_getY(){return hero_y;}
    public Image back_getImage(){return back;}
    public void setVisible(boolean visible){this.visible = visible;}
    public boolean isVisible(){return visible;}
    
    public void initAll(){
    	int posE[][]=positionE();
    	int posW[][]=positionW();
    	Enemys=new ArrayList();
    	Walls=new ArrayList();
    	for(int i=0;i<posE.length;i++){
    		Enemys.add(new Enemy(posE[i][0],posE[i][1]));
    	}
    	for(int i2=0;i2<posW.length;i2++){
    		Walls.add(new Wall(posW[i2][0],posW[i2][1]));
    	}
    }
	public int[][] positionE(){
		int[][]posE={{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8},{9,9},{10,10}};
		return posE;
	}
	public int[][] positionW(){
		int[][]posW={{32,32},{64,64},{96,96},{128,128},{160,160},{192,192},{224,224},{256,256},{288,288},{320,320}};
		return posW;
	}
    public int getEnemySize(){return Enemys.size();}
    public ArrayList getEnemys(){return Enemys;}
    public int getWallSize(){return Walls.size();}
    public ArrayList getWall(){return Walls;}
    public static void keyPressed(KeyEvent e){
    	int key = e.getKeyCode();
        if(key==KeyEvent.VK_1){shootFireBall();}
        if(key==KeyEvent.VK_2){}
        if(key==KeyEvent.VK_3){/*heal*/}
        if(key==KeyEvent.VK_4){/*Blast*/}
        if(key==KeyEvent.VK_5){/*Finish*/}
        if(key==KeyEvent.VK_SPACE){/*interact||talk*/}
        if(key==KeyEvent.VK_A){
            hero_dx=-1;
        }
        if(key==KeyEvent.VK_D){
            hero_dx=1;
        }
        if(key==KeyEvent.VK_W){
            hero_dy=-1;
        }
        if(key==KeyEvent.VK_S){
            hero_dy=1;
        }
    }
    public static void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_1){/*sword*/}
        if(key==KeyEvent.VK_2){/*fireball*/}
        if(key==KeyEvent.VK_3){/*heal*/}
        if(key==KeyEvent.VK_4){/*Blast*/}
        if(key==KeyEvent.VK_5){/*Finish*/}
        if(key==KeyEvent.VK_SPACE){/*interact||talk*/}
        if(key==KeyEvent.VK_A){
            hero_dx=0;
        }
        if(key==KeyEvent.VK_D){
            hero_dx=0;
        }
        if(key==KeyEvent.VK_W){
            hero_dy=0;
        }
        if(key==KeyEvent.VK_S){
            hero_dy=0;
        }
    }
}