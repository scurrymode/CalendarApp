package cal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	JPanel p_north, p_center;
	JButton bt_prev, bt_next;
	JLabel la_title;
	DateBox[] box = new DateBox[7*6];
	Calendar cal = Calendar.getInstance();
	//���� ��¥�� ����ϱ� ���� ����
	int yy;
	int mm;
	int dd;
	
	
	public MainFrame() {
		p_north = new JPanel();
		p_center = new JPanel();
		bt_prev = new JButton("��");
		bt_next = new JButton("��");
		la_title = new JLabel("2017�� 4��");
		la_title.setFont(new Font("����", Font.BOLD|Font.ITALIC, 28));
		
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		yy = cal.get(Calendar.YEAR);
		mm = cal.get(Calendar.MONTH);
		dd = cal.get(Calendar.DATE);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		printDate();
		
		setSize((120*7)+60, (120*6)+120);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void printDate(){
		//���� ��¥ �󺧿� ���
		la_title.setText(yy+"��"+(mm+1)+"��");
		
		//������ �簢�� ��� ������
		p_center.removeAll();
		
		//�̹����� ���� ���Ϻ��� �����ϴ��� Ȯ���ϱ�!
		cal.set(yy, mm, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		//�̹� ���� ������ ���� ���߱�!
		cal.set(yy, mm+1, 0);
		int lastDate = cal.get(Calendar.DATE);
		
		System.out.println(mm+"�� ���ۿ����� "+firstDay);
		System.out.println(mm+"�� �� ������ "+lastDate);
		
		int num=1; //���������� ��¥�� ����
		for(int i=0;i<box.length;i++){
			box[i]=new DateBox(this);
			
			if(i>=firstDay-1&&num<=lastDate){
				box[i].la.setText(Integer.toString(num));
				num++;
			}
			p_center.add(box[i]);
		}
	}
	

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt_prev){
			mm--;
			if(mm<1){
				yy--;
				mm=11;
			}
			printDate();
		}else if(obj == bt_next){
			mm++;
			if(mm>11){
				yy++;
				mm=0;
			}
			printDate();
		}	
	}
	
	
	
	

	public static void main(String[] args) {
		new MainFrame();

	}

}
