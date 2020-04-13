package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Frame_Battle extends JFrame{
	private JPanel contentPane;
	private JPanel Status_panel,Battle_panel;
	private JPanel opponent_M_totalP_bar,opponent_M_nowP_bar;
	private JPanel my_M_tatalP_bar,my_M_nowP_bar;
	private String myID,opponentID;
	
	Frame_Battle(String myID ,String opponentID){
		
		this.myID = myID;
		this.opponentID = opponentID;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Status_panel = new JPanel();
		Status_panel.setBackground(new Color(230, 230, 250));
		Status_panel.setBounds(12, 267, 254, 128);
		contentPane.add(Status_panel);
		Status_panel.setLayout(null);
		
		JLabel msg_label = new JLabel("대기중..");
		msg_label.setHorizontalAlignment(SwingConstants.CENTER);
		msg_label.setFont(new Font("굴림", Font.BOLD, 16));
		msg_label.setBounds(12, 46, 230, 30);
		Status_panel.add(msg_label);
		
		JButton attack_btn = new JButton("공격");
		attack_btn.setBounds(292, 289, 97, 23);
		contentPane.add(attack_btn);
		
		JButton skill_btn = new JButton("스킬");
		skill_btn.setBounds(401, 289, 97, 23);
		contentPane.add(skill_btn);
		
		JButton monsterChange_Btn = new JButton("바꾸기");
		monsterChange_Btn.setBounds(292, 359, 97, 23);
		contentPane.add(monsterChange_Btn);
		
		JButton giveUp_btn = new JButton("기권");
		giveUp_btn.setBounds(401, 359, 97, 23);
		contentPane.add(giveUp_btn);
		ImageIcon g = new ImageIcon("C:\\Users\\jwon\\Desktop\\사본 -11이미지.jpg");
		Image t = g.getImage();
		t = t.getScaledInstance(172, 120,java.awt.Image.SCALE_SMOOTH);
		g = new ImageIcon(t);
		ImageIcon g2 = new ImageIcon("C:\\Users\\jwon\\Desktop\\ddd.jpg");
		Image t2 = g2.getImage();
		t2 = t2.getScaledInstance(172, 120, java.awt.Image.SCALE_SMOOTH);
		g2 = new ImageIcon(t2);
		
		Battle_panel = new JPanel();
		Battle_panel.setBackground(new Color(255, 228, 225));
		Battle_panel.setBounds(12, 10, 501, 247);
		contentPane.add(Battle_panel);
		Battle_panel.setLayout(null);
		
		JLabel my_M_ImageIcon = new JLabel("New label");
		my_M_ImageIcon.setBounds(35, 130, 172, 107);
		Battle_panel.add(my_M_ImageIcon);
		my_M_ImageIcon.setIcon(g);
		
		my_M_ImageIcon.setBackground(Color.WHITE);
		
		JLabel opponent_M_ImageIcon = new JLabel("New label");
		opponent_M_ImageIcon.setBounds(295, 10, 172, 107);
		Battle_panel.add(opponent_M_ImageIcon);
		opponent_M_ImageIcon.setIcon(g2);
		opponent_M_ImageIcon.setBackground(Color.WHITE);
		
		opponent_M_totalP_bar = new JPanel();
		opponent_M_totalP_bar.setLayout(null);
		opponent_M_totalP_bar.setBackground(Color.RED);
		opponent_M_totalP_bar.setBounds(13, 52, 230, 20);
		Battle_panel.add(opponent_M_totalP_bar);
		
		opponent_M_nowP_bar = new JPanel();
		opponent_M_nowP_bar.setBackground(Color.GREEN);
		opponent_M_nowP_bar.setBounds(0, 0, 200, 20);
		opponent_M_totalP_bar.add(opponent_M_nowP_bar);
		
		JLabel opponent_M_Name = new JLabel("파이리/파이리");
		opponent_M_Name.setBounds(12, 32, 99, 15);
		Battle_panel.add(opponent_M_Name);
		
		JLabel opponent_Lv = new JLabel("Lv.1");
		opponent_Lv.setBounds(209, 32, 33, 15);
		Battle_panel.add(opponent_Lv);
		
		JLabel opponent_M_totalP = new JLabel("/ 100");
		opponent_M_totalP.setBounds(209, 74, 33, 21);
		Battle_panel.add(opponent_M_totalP);
		
		JLabel opponent_M_nowP = new JLabel("90");
		opponent_M_nowP.setBounds(184, 77, 23, 15);
		Battle_panel.add(opponent_M_nowP);
		
		my_M_tatalP_bar = new JPanel();
		my_M_tatalP_bar.setLayout(null);
		my_M_tatalP_bar.setBackground(Color.RED);
		my_M_tatalP_bar.setBounds(260, 174, 230, 20);
		Battle_panel.add(my_M_tatalP_bar);
		
		my_M_nowP_bar = new JPanel();
		my_M_nowP_bar.setBackground(Color.GREEN);
		my_M_nowP_bar.setBounds(0, 0, 200, 20);
		my_M_tatalP_bar.add(my_M_nowP_bar);
		
		JLabel my_M_Lv = new JLabel("Lv.1");
		my_M_Lv.setBounds(456, 154, 33, 15);
		Battle_panel.add(my_M_Lv);
		
		JLabel my_M_Name = new JLabel("파이리/파이리");
		my_M_Name.setBounds(259, 154, 99, 15);
		Battle_panel.add(my_M_Name);
		
		JLabel my_M_nowP = new JLabel("90");
		my_M_nowP.setBounds(431, 199, 23, 15);
		Battle_panel.add(my_M_nowP);
		
		JLabel my_M_totalP = new JLabel("/ 100");
		my_M_totalP.setBounds(456, 196, 33, 21);
		Battle_panel.add(my_M_totalP);
		
		this.setVisible(true);
	}
}
