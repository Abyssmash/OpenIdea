package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.IdeaDAO;
import dto.IdeaDTO;
// 객체, 상속, 인터페이스를 습득하기 위해 swing을 이용해봄
// implements:  ActionListener를 구현했다 
public class MainFrame extends JFrame 
implements ActionListener, MouseListener{
									// 인터페이스 구현: 기능을 처리하기 위해 
	private JLabel title = new JLabel("Ideabank");
	private JTextField input = new JTextField();
	private JButton btn = new JButton("Save");
	private List wordList = new List(5,false);
	private JButton btn1 = new JButton("East");
	private JButton btn2 = new JButton("West");
	private JPanel centerP = new JPanel();
	// panel은 컨테이너이면서 컴포넌트이다. 기본 레이아웃이 flowLayout
	
	private IdeaDAO ideaDao = IdeaDAO.getInstance();
	// private IdeaService is = new IdeaService();
	public MainFrame() {
					// 가로 세로 x축 y축
		this.setBounds(100, 100, 300, 500);
		// 컨테이너는 컴포넌트를 배치시킨다. 컨테이너는 레이아웃이 있다.
		// JFrame은 컨테이너이고, 기본 레이아웃은 border layout이다.
		// border layout은 하나의 공간에 하나의 컴포넌트만 가능하다.
		this.add(title,"North");	// 어디에 배치할 것인지 의미하는 코드
		this.add(btn, "South");
		// 가운데 패널
		centerP.setLayout(new BorderLayout());
		centerP.setBackground(Color.red);
		centerP.add(wordList,"Center");
		centerP.add(input,"South");
		this.add(centerP,"Center");
		//this.add(btn1,"East");
		//this.add(btn2,"West");
		
		// 리스너 등록
		btn.addActionListener(this);
		input.addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this와 super 무엇을 써도 상관없음
		loadDB();
	}
	private void loadDB() {
		ArrayList<IdeaDTO> ideadto = ideaDao.selectAll();
		for(IdeaDTO i : ideadto) {
			wordList.add(i.getNum+" : "+i.getTitle());
		}
	}
	@Override	// 매서드 재정의
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn || e.getSource()==input) {
			//System.out.println("버튼이 클릭되었다.");
			String t = input.getText();
			//System.out.println("입력하신 글은 : "+t);
			input.setText("");
			//wordList.add(t);
			
			IdeaDTO dto = new IdeaDTO();
			dto.setTitle(t);
			ideaDao.insert(dto);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
}
