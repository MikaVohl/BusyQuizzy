import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class quiz implements ActionListener {
	
	private JPanel quizPanel;
	private JLabel title;
	private JLabel question;
	private JLabel feedback;
	private JLabel numberDisplay;
	private JFrame homeframe;
	private JButton ansA;
	private JButton ansB;
	private JButton ansC;
	private JButton ansD;
	private JButton next;
	private String answer;
	private int questionCount;
	private int random1;
	private int random2;
	private int random3;
	private int random4;
	private String[][] QArray;
	
	public quiz(JFrame frame, int qCount, String[][] finalArray) {
		
		QArray = finalArray;
		homeframe = frame;
		questionCount = qCount;
		
		numberDisplay = new JLabel("Question "+questionCount+":");
		question = new JLabel(QArray[qCount-1][1]);
		answer = QArray[qCount-1][2];
		quizPanel = new JPanel();
		feedback = new JLabel("");
		title = new JLabel("Buzy Quizzy");
		Random random = new Random();
		random1 = random.nextInt(4) + 2;
		do {
			random2 = random.nextInt(4) + 2;
		}while(random2 == random1);
		do {
			random3 = random.nextInt(4) + 2;
		}while(random3 == random2 || random3 == random1);
		do {
			random4 = random.nextInt(4) + 2;
		}while(random4 == random3 || random4 == random2 || random4 == random1);
		
		ansA = new JButton(QArray[qCount-1][random1]);
		ansB = new JButton(QArray[qCount-1][random2]);
		ansC = new JButton(QArray[qCount-1][random3]);
		ansD = new JButton(QArray[qCount-1][random4]);
		next = new JButton("Next Question");
		
		ansA.addActionListener(this);
		ansB.addActionListener(this);
		ansC.addActionListener(this);
		ansD.addActionListener(this);
		next.addActionListener(this);
		
		ansA.setBounds(115, 450, 350, 200);
		ansB.setBounds(540, 450, 350, 200);
		ansC.setBounds(965, 450, 350, 200);
		ansD.setBounds(1400, 450, 350, 200);
		next.setBounds(520, 430, 800, 300);
		question.setBounds(1920/2-question.getText().length()*16, 300, 1000, 100);
		numberDisplay.setBounds(750, 190, 500, 100);
		title.setBounds(1920/2-300, 50, 700, 120);
		
		ansA.setFont(new Font("Verdana", Font.PLAIN, 80-(ansA.getText().length()*3)));
		ansB.setFont(new Font("Verdana", Font.PLAIN, 80-(ansB.getText().length()*3)));
		ansC.setFont(new Font("Verdana", Font.PLAIN, 80-(ansC.getText().length()*3)));
		ansD.setFont(new Font("Verdana", Font.PLAIN, 80-(ansD.getText().length()*3)));
		next.setFont(new Font("Verdana", Font.PLAIN, 80));
		numberDisplay.setFont(new Font("Verdana", Font.PLAIN, 65));
		question.setFont(new Font(Font.DIALOG,  Font.PLAIN, 70));
		feedback.setFont(new Font(Font.DIALOG,  Font.PLAIN, 70));
		title.setFont(new Font("SansSerif", Font.BOLD, 90));
		
		ansA.setFocusPainted(false);
		ansB.setFocusPainted(false);
		ansC.setFocusPainted(false);
		ansD.setFocusPainted(false);
		next.setFocusPainted(false);
		
		quizPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); // creates a border around the panel. Parameters (top, left, bottom, right)
		quizPanel.setLayout(null);
		
		quizPanel.add(title);
		quizPanel.add(question);
		quizPanel.add(ansA);
		quizPanel.add(ansB);
		quizPanel.add(ansC);
		quizPanel.add(ansD);
		quizPanel.add(feedback);
		quizPanel.add(next);
		quizPanel.add(numberDisplay);
		frame.add(quizPanel, BorderLayout.CENTER);
		next.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == next) {
			quizPanel.setVisible(false);
			questionCount++;
			if(questionCount <= QArray.length) { //masterList.qAndA[questionCount-1][0] != "+questionCount+"
				new quiz(homeframe, questionCount, QArray);
			}
			else {
				new quizFinish(homeframe, QArray);
			}
		}
		
		else if(((AbstractButton) e.getSource()).getText() == answer) {
			feedback.setText("Correct! The answer is "+answer);
			feedback.setBounds(1920/2-feedback.getText().length()*17, 770, 1600, 100);
			ansA.setVisible(false);
			ansB.setVisible(false);
			ansC.setVisible(false);
			ansD.setVisible(false);
			next.setVisible(true);
		}
		else {
			feedback.setText("Incorrect. Try again");
			feedback.setBounds(1920/2-feedback.getText().length()*19, 770, 900, 100);
		}
	}
}
