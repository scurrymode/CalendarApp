//�� ��¥�� ǥ���ϴ� Ŀ���͸������ ������Ʈ
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
		JOptionPane.showMessageDialog(mainFrame, "������ "+mainFrame.yy+"�� "+(mainFrame.mm+1)+"�� "+date+"�� �Դϴ�.");
		
	}
}
