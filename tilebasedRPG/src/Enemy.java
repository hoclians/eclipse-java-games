import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Enemy{
    private String enemy = "enemy.gif";
    private int width,height,x,y,health=100,life=1;
    private boolean visible;
    private Image image;
    public Enemy(){
    	
    }
    public Enemy(int x, int y) {
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(enemy));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;
    }
    public double health(double damage,double boon){if(health==0){life=0;Kill();}health+=damage;health+=boon;return 0;}
    public double getHealth(){return health;}
    public int isAlive(){return life;}
    public void move() {
        if (x < 0)
            x = 400;
        x -= 1;
    }
    public void Kill(){
    	Updates Updates=new Updates();
    	for(int j=0;j<Updates.getEnemySize();j++) {
            Enemy a=(Enemy)Updates.getEnemys().get(j);
            Rectangle r2=a.getBounds();
            a.setVisible(false);
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    public boolean getVisible(){
    	return visible;
    }
    public Image getImage() {
        return image;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}