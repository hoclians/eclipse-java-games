import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class Hero{
    private String hero="hero.gif";
    private int width,height,life=1;
    private double health=100;
    private int hero_x=425,hero_y=325;
    private boolean visible;
    private Image tile;
    public Hero(){
        ImageIcon ii_h=new ImageIcon(this.getClass().getResource(hero));
        tile=ii_h.getImage();
        width=tile.getWidth(null);
        height=tile.getHeight(null);
        visible = true;
    }
    public double health(double damage,double boon){if(health==0){life=0;}health+=damage;health+=boon;return 0;}
    public double getHealth(){return health;}
    public int isAlive(){return life;}
    public int getX(){return hero_x;}
    public int getY(){return hero_y;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public Image getImage(){return tile;}
    public void setVisible(boolean visible){this.visible = visible;}
    public boolean isVisible(){return visible;}
    public Rectangle getBounds(){return new Rectangle(hero_x,hero_y,width+1,height+1);}
}