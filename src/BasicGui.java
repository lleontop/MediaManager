import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;


public class BasicGui extends JFrame implements ActionListener{
	
	// declarations
	private JMenuBar menubar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenu help = new JMenu("Help");
	private JMenuItem importb = new JMenuItem("Import Excel File");
	private JMenuItem saveb = new JMenuItem("Save");
	private JMenuItem saveasb = new JMenuItem("Save As...");
	private JMenuItem printb = new JMenuItem("Print...");
	private JMenuItem exitb = new JMenuItem("Exit");
	private JMenuItem undob = new JMenuItem("Undo last");
	private JMenuItem cutb = new JMenuItem("Cut");
	private JMenuItem copyb = new JMenuItem("Copy");
	private JMenuItem searchb = new JMenuItem("Search");
	private JMenuItem aboutb = new JMenuItem("About");
	
	private static JTable table = new JTable();
	
	public BasicGui() {
		/*
		 *  TODO make the skeleton for the 3 sub-programs
		 *  create an initial empty jtable
		 *  fix the listeners
		 *  when finish with basic excel import add jprogressbar (visual)
		 */
		
		super("Media Manager");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		// creation of menubar with all buttons
		setJMenuBar(menubar);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		file.add(importb);
		file.add(saveb);
		file.add(saveasb);
		file.addSeparator();
		file.add(printb);
		file.addSeparator();
		file.add(exitb);
		edit.add(undob);
		edit.add(cutb);
		edit.add(copyb);
		help.add(searchb);
		help.add(aboutb);
		
		// add actionlisteners for the menu items
		importb.addActionListener(this);
		saveb.addActionListener(this);
		saveasb.addActionListener(this);
		printb.addActionListener(this);
		exitb.addActionListener(this);
		undob.addActionListener(this);
		cutb.addActionListener(this);
		copyb.addActionListener(this);
		searchb.addActionListener(this);
		aboutb.addActionListener(this);
		
		// add the table
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		
	}
	
	// ActionListeners
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == this.importb) {
				JFileChooser fchooser = new JFileChooser();
				
				int openOption = fchooser.showOpenDialog(this);
				
				if (openOption == JFileChooser.APPROVE_OPTION) {
					try {
						String line = "";
						//String dir = fchooser.getCurrentDirectory().toString();
						String full_file_path = fchooser.getSelectedFile().toString();
						
						ExcelHandler eh = new ExcelHandler();
						eh.readExcelFile(full_file_path);
						
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
				if (openOption == JFileChooser.CANCEL_OPTION) {
					//filename = "";
					//dir = "";
				}
			}
			if (evt.getSource() == this.saveasb) {
				// need fix
			} else if (evt.getSource() == this.exitb) {
				System.exit(0);
			}
			
		}
	
}