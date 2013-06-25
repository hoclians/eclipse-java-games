import javax.swing.JFrame;
public class image extends JFrame{
	public image(){
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 650);
        setLocationRelativeTo(null);
        setTitle("RPG");
        setResizable(false);
        setVisible(true);
	}
	public static void main(String args[]){
		new image();
	}

}
