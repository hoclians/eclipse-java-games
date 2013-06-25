import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class fireBall{
    private int x, y;
    private Image image;
    boolean visible;
    private int width, height;
    private final int MISSILE_SPEED=5;
	int BOARD_WIDTH=800,BOARD_HEIGHT=600;
    public fireBall(){}
    public fireBall(int x, int y) {
        ImageIcon ii=new ImageIcon(this.getClass().getResource("fireBall.gif"));
        image=ii.getImage();
        width=image.getWidth(null);
        height=image.getHeight(null);
        visible=true;
        this.x=x;
        this.y=y;
    }
    public Image getImage(){
        return image;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean isVisible(){
        return visible;
    }
    public void setVisible(boolean visible){this.visible = visible;}
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void move(){
        y-=MISSILE_SPEED;
        if(x>BOARD_WIDTH)
            visible=false;
        if(y>BOARD_HEIGHT)
        	visible=false;
        if(y<0)
        	visible=false;
    }
}