package wordlove;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class wordlove extends JFrame implements ActionListener{
	
	private JLabel title = new JLabel("단어장 프로그램");
	private JTextField input = new JTextField();
	private JButton btn1 = new JButton("저장");
	private JButton btn2 = new JButton("선택단어삭제");
	private JButton btn3 = new JButton("수정");
	private List wordList = new List(10,true);
	
	public wordlove() {
		this.setBounds(100, 100, 300, 600);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
