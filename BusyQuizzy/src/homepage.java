import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class homepage implements ActionListener {
	public JFrame homeFrame;
	public int questionCount = 1;
	public JPanel mainPanel;
	private JLabel title;
	private JButton demoQuizButton;
	private JButton makeQuizButton;
	private String[][] keyArray;
	
	public homepage(String[][] finalArray) {
		
		keyArray = finalArray;
		homeFrame = new JFrame();
		
		demoQuizButton = new JButton("Attempt Quiz");
		demoQuizButton.addActionListener(this);
		demoQuizButton.setFont(new Font("Monospaced", Font.BOLD, 90));
		demoQuizButton.setFocusPainted(false);
		makeQuizButton = new JButton("Make Quiz");
		makeQuizButton.addActionListener(this);
		makeQuizButton.setFont(new Font("Monospaced", Font.BOLD, 90));
		makeQuizButton.setFocusPainted(false);

		title = new JLabel("Buzy Quizzy");
		title.setFont(new Font("SansSerif", Font.BOLD, 90));
		
		mainPanel = new JPanel(); // creates panel (container that stores group of components)
		mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // creates a border around the panel. Parameters (top, left, bottom, right)
		mainPanel.setLayout(null);
		mainPanel.add(title);
		mainPanel.add(demoQuizButton);
		mainPanel.add(makeQuizButton);
		
		homeFrame.setPreferredSize(new Dimension(1920,1080));
		homeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		homeFrame.setUndecorated(true);
		homeFrame.add(mainPanel, BorderLayout.CENTER); // adds the panel to the frame, centers it
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ensures the frame exits on close as opposed to hiding or ignoring
		homeFrame.setTitle("Buzy Quizzy"); // title of frame
		homeFrame.pack(); // sizes the frame so that all its contents are at or above their preferred sizes
		homeFrame.setVisible(true); // ensures frame is visible
		
		title.setBounds(1920/2-300, 50, 700, 120);
		demoQuizButton.setBounds(1920/2+70, 1080/2, 800, 300);
		makeQuizButton.setBounds(1920/2-870, 1080/2, 800, 300);
	}

	public static void main(String[] args) {
		new homepage(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == demoQuizButton) {
			if(keyArray != null) {
				mainPanel.setVisible(false);
				new quiz(homeFrame, questionCount, keyArray);
			}
		}
		else if(e.getSource() == makeQuizButton) {
			mainPanel.setVisible(false);
			new makeQuiz(homeFrame, questionCount, mainPanel, new ArrayList<>());
		}
	}
}
