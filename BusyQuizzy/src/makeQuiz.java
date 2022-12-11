import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class makeQuiz implements ActionListener {
	
	public String[][] testArray;
	private JPanel makePanel;
	private JPanel mainPanel;
	private JLabel title;
	private JLabel numberDisplay;
	private JLabel q1;
	private JLabel q2;
	private JLabel q3;
	private JLabel q4;
	private int questionCount;
	private JTextField questionField;
	private JTextField qF1;
	private JTextField qF2;
	private JTextField qF3;
	private JTextField qF4;
	private JButton next;
	private JButton finish;
	private JFrame homeframe;
	private ArrayList<String[]> listOfQ;
	
	public makeQuiz(JFrame frame, int qCount, JPanel thePanel, ArrayList<String[]> arraylist) {
		
		listOfQ = arraylist;
		
		questionCount = qCount;
		homeframe = frame;
		mainPanel = thePanel;
		
		questionField = new JTextField("Enter the question");
		qF1 = new JTextField("Enter the solution");
		qF2 = new JTextField("Enter a wrong answer");
		qF3 = new JTextField("Enter a wrong answer");
		qF4 = new JTextField("Enter a wrong answer");
		questionField.setHorizontalAlignment(SwingConstants.CENTER);
		qF1.setHorizontalAlignment(SwingConstants.CENTER);
		qF2.setHorizontalAlignment(SwingConstants.CENTER);
		qF3.setHorizontalAlignment(SwingConstants.CENTER);
		qF4.setHorizontalAlignment(SwingConstants.CENTER);
		numberDisplay = new JLabel("Question "+questionCount+":");
		makePanel = new JPanel();
		title = new JLabel("Buzy Quizzy");
		q1 = new JLabel("Solution:");
		q2 = new JLabel("Wrong answer:");
		q3 = new JLabel("Wrong answer:");
		q4 = new JLabel("Wrong answer:");
		next = new JButton("NEXT");
		finish = new JButton("FINISH");
		
		questionField.setBounds(1920/2-360, 300, 700, 125);
		numberDisplay.setBounds(750, 190, 500, 100);
		title.setBounds(1920/2-300, 50, 700, 120);
		q1.setBounds(465, 415, 700, 150);
		q2.setBounds(1100, 415, 700, 150);
		q3.setBounds(400, 690, 700, 150);
		q4.setBounds(1100, 690, 700, 150);
		qF1.setBounds(350, 590, 500, 100);
		qF2.setBounds(1050, 590, 500, 100);
		qF3.setBounds(350, 890, 500, 100);
		qF4.setBounds(1050, 890, 500, 100);
		next.setBounds(1500, 120, 350, 165);
		finish.setBounds(75, 120, 350, 165);
		
		numberDisplay.setFont(new Font("Verdana", Font.PLAIN, 65));
		title.setFont(new Font("SansSerif", Font.BOLD, 90));
		questionField.setFont(new Font("Verdana", Font.BOLD, 50));
		q1.setFont(new Font("Verdana", Font.BOLD, 45));
		q2.setFont(new Font("Verdana", Font.BOLD, 45));
		q3.setFont(new Font("Verdana", Font.BOLD, 45));
		q4.setFont(new Font("Verdana", Font.BOLD, 45));
		qF1.setFont(new Font("Verdana", Font.PLAIN, 35));
		qF2.setFont(new Font("Verdana", Font.PLAIN, 35));
		qF3.setFont(new Font("Verdana", Font.PLAIN, 35));
		qF4.setFont(new Font("Verdana", Font.PLAIN, 35));
		next.setFont(new Font("Verdana", Font.BOLD, 35));
		finish.setFont(new Font("Verdana", Font.BOLD, 35));
		
		makePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // creates a border around the panel. Parameters (top, left, bottom, right)
		makePanel.setLayout(null);
		next.setFocusPainted(false);
		next.addActionListener(this);
		finish.setFocusPainted(false);
		finish.addActionListener(this);

		makePanel.add(title);
		makePanel.add(numberDisplay);
		makePanel.add(questionField);
		makePanel.add(q1);
		makePanel.add(q2);
		makePanel.add(q3);
		makePanel.add(q4);
		makePanel.add(qF1);
		makePanel.add(qF2);
		makePanel.add(qF3);
		makePanel.add(qF4);
		makePanel.add(next);
		makePanel.add(finish);
		frame.add(makePanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listOfQ.add(new String[] {Integer.toString(questionCount), questionField.getText(), qF1.getText(), qF2.getText(), qF3.getText(), qF4.getText()});

		makePanel.setVisible(false);
		if(e.getSource() == next) {
			questionCount++;
			new makeQuiz(homeframe, questionCount, mainPanel, listOfQ);
		}
		else if (e.getSource() == finish){
			testArray = listOfQ.toArray(new String[0][]);
			new homepage(testArray);
			
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
}
