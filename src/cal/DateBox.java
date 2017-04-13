//각 날짜를 표현하는 커스터마이즈된 컴포넌트
package cal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DateBox extends JPanel{
	JLabel la;
	MainFrame mainFrame;
	
	public DateBox(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		this.setLayout(new BorderLayout());
		la = new JLabel("");
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pop();
			}
		});
		
		add(la, BorderLayout.NORTH);
		setPreferredSize(new Dimension(120,120));
		setBackground(Color.YELLOW);
	}
	
	public void pop(){
		String date=la.getText();
		for(int i=0;i<mainFrame.box.length;i++){
			if(mainFrame.box[i] != this){
				mainFrame.box[i].setBackground(Color.YELLOW);
			}else{
				setBackground(Color.PINK);
			}
		}
		JOptionPane.showMessageDialog(mainFrame, "오늘은 "+mainFrame.yy+"년 "+(mainFrame.mm+1)+"월 "+date+"일 입니다.");
		
	}
}
