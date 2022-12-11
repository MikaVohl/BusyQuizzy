import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class quizFinish implements ActionListener {
	
	private JLabel title;
	private JLabel message;
	private JFrame homeframe;
	private JPanel finishPanel;
	private JButton restart;
	private JButton home;
	private String[][] QArray;

	
	public quizFinish(JFrame frame, String[][] array) {
		
		QArray = array;
		homeframe = frame;
		
		title = new JLabel("Busy Quizzy");
		message = new JLabel("You Completed The Quiz!");
		restart = new JButton("RETRY");
		home = new JButton("HOME");
		finishPanel = new JPanel();
		
		restart.addActionListener(this);
		home.addActionListener(this);
		
		title.setBounds(1920/2-300, 50, 700, 120);
		title.setFont(new Font("SansSerif", Font.BOLD, 90));
		message.setBounds(1920/2-500, 300, 1400, 100);
		message.setFont(new Font("Verdana", Font.PLAIN, 75));
		restart.setBounds(200, 650, 600, 275);
		restart.setFont(new Font("Verdana", Font.PLAIN, 70));
		home.setBounds(1050, 650, 600, 275);
		home.setFont(new Font("Verdana", Font.PLAIN, 70));
		
		finishPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // creates a border around the panel. Parameters (top, left, bottom, right)
		finishPanel.setLayout(null);
		
		finishPanel.add(title);
		finishPanel.add(restart);
		finishPanel.add(home);
		finishPanel.add(message);
		homeframe.add(finishPanel, BorderLayout.CENTER);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		finishPanel.setVisible(false);
		if(e.getSource() == restart) {
			new quiz(homeframe, 1, QArray);
		}
		else if(e.getSource() == home) {
			new homepage(QArray);
			
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
}