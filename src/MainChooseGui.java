import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;


public class MainChooseGui extends JFrame implements ActionListener {
	
	// declarations
	private JPanel controlpanel = new JPanel();
	private JMenuBar menubar= new JMenuBar();
	private JMenu help = new JMenu("Help");
	private JMenuItem aboutb = new JMenuItem("About");
	private JButton musicbutton = new JButton("Music");
	private JButton moviesbutton = new JButton("Movies");
	private JButton booksbutton = new JButton("Books");
	
	public MainChooseGui() {
		/*
		 * TODO
		 * fix the buttons better
		 * fix the menu
		 */
		
		super("Media Manager");
		setSize(350, 150);
		setResizable(true); // test for resize
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		// creation of menubar with all buttons
		setJMenuBar(menubar);
		menubar.add(help);
		help.add(aboutb);
		
		// declare listeners for menubar buttons
		//aboutb.addActionListener(this);
		
		add(controlpanel);
		controlpanel.add(musicbutton);
		controlpanel.add(moviesbutton);
		controlpanel.add(booksbutton);
		
		// declare listeners for the 3 buttons
		musicbutton.addActionListener(this);
		moviesbutton.addActionListener(this);
		booksbutton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 *  TODO after creating the basic program add here the entries of the JTable
		 */
		
		if (e.getSource() == this.musicbutton) {
			BasicGui basicscreen = new BasicGui();
			basicscreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			basicscreen.setVisible(true);
		} else if (e.getSource() == this.moviesbutton) {
			/*basicGui basicscreen = new basicGui();
			basicscreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			basicscreen.setVisible(true);
		} else if (e.getSource() == this.booksbutton) {
			basicGui basicscreen = new basicGui();
			basicscreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			basicscreen.setVisible(true);*/
		}
		
	}
}