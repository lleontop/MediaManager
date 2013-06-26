import javax.swing.JFrame;

public class Base {

	/**
	 * Media Manager
	 * organize your music, movies, books
	 * @version 0.0.2
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainChooseGui basewin = new MainChooseGui();
		//Close frame
		basewin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		basewin.setVisible(true);
	
	}

}