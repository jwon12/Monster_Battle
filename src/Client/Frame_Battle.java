package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Monster.Monster;
import Server.TC_Object;

public class Frame_Battle extends JFrame {
	private JPanel contentPane;
	private JPanel Status_panel, Battle_panel;
	private JPanel opponent_M_totalP_bar, opponent_M_nowP_bar;
	private JPanel my_M_tatalP_bar, my_M_nowP_bar;
	private JLabel my_M_ImageIcon, opponent_M_ImageIcon;
	private JLabel my_M_Lv, my_M_Name, my_M_nowP, my_M_totalP;
	private JLabel opponent_M_Name, opponent_Lv, opponent_M_totalP, opponent_M_nowP;
	private JButton attack_btn,skill_btn,monsterChange_Btn,giveUp_btn;
	private String myID, opponentID;
	private C_TC myTCsin = null;
	private JTextArea msgTextArea;

	Frame_Battle(C_TC sin,String myID ,String opponentID) {
		this.myTCsin = sin;
		this.myID = myID;
		this.opponentID = opponentID;

	}

	public void Startsetting(TC_Object o) {
		
		setBounds(100, 100, 541, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Status_panel = new JPanel();
//		Status_panel.setBackground(new Color(230, 230, 250));
		Status_panel.setBounds(12, 267, 254, 128);
		contentPane.add(Status_panel);
		Status_panel.setLayout(null);
		
		msgTextArea = new JTextArea();
		msgTextArea.setBounds(12, 46, 230, 30);
		Status_panel.add(msgTextArea);
		
		
		attack_btn = new JButton("공격");
		attack_btn.setBounds(292, 289, 97, 23);
		attack_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myTCsin.send("/battle In_battle attack "+myID+" "+opponentID);
				
			}
		});
		contentPane.add(attack_btn);

		skill_btn = new JButton("스킬");
		skill_btn.setBounds(401, 289, 97, 23);
		skill_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		contentPane.add(skill_btn);

		monsterChange_Btn = new JButton("바꾸기");
		monsterChange_Btn.setBounds(292, 359, 97, 23);
		monsterChange_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(monsterChange_Btn);

		giveUp_btn = new JButton("기권");
		giveUp_btn.setBounds(401, 359, 97, 23);
		giveUp_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		contentPane.add(giveUp_btn);
		// my 몬스터 이미지
		ImageIcon g = new ImageIcon("C:\\Users\\jwon\\Desktop\\사본 -11이미지.jpg");
		Image t = g.getImage();
		t = t.getScaledInstance(172, 120, java.awt.Image.SCALE_SMOOTH);
		g = new ImageIcon(t);
		// 상대 몬스터 이미지
		ImageIcon g2 = new ImageIcon("C:\\Users\\jwon\\Desktop\\ddd.jpg");
		Image t2 = g2.getImage();
		t2 = t2.getScaledInstance(172, 120, java.awt.Image.SCALE_SMOOTH);
		g2 = new ImageIcon(t2);

		Battle_panel = new JPanel();
		Battle_panel.setBackground(new Color(255, 228, 225));
		Battle_panel.setBounds(12, 10, 501, 247);
		contentPane.add(Battle_panel);
		Battle_panel.setLayout(null);

		my_M_ImageIcon = new JLabel("New label");
		my_M_ImageIcon.setBounds(35, 130, 172, 107);
		Battle_panel.add(my_M_ImageIcon);
		my_M_ImageIcon.setIcon(g);

		my_M_ImageIcon.setBackground(Color.WHITE);

		opponent_M_ImageIcon = new JLabel("New label");
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
		opponent_M_nowP_bar.setBounds(0, 0, 230, 20);
		opponent_M_totalP_bar.add(opponent_M_nowP_bar);

		opponent_M_Name = new JLabel("파이리/파이리");
		opponent_M_Name.setBounds(12, 32, 99, 15);
		Battle_panel.add(opponent_M_Name);

		opponent_Lv = new JLabel("Lv.1");
		opponent_Lv.setBounds(209, 32, 33, 15);
		Battle_panel.add(opponent_Lv);

		opponent_M_totalP = new JLabel("/ 100");
		opponent_M_totalP.setBounds(209, 74, 33, 21);
		Battle_panel.add(opponent_M_totalP);

		opponent_M_nowP = new JLabel("90");
		opponent_M_nowP.setBounds(184, 77, 23, 15);
		Battle_panel.add(opponent_M_nowP);

		my_M_tatalP_bar = new JPanel();
		my_M_tatalP_bar.setLayout(null);
		my_M_tatalP_bar.setBackground(Color.RED);
		my_M_tatalP_bar.setBounds(260, 174, 230, 20);
		Battle_panel.add(my_M_tatalP_bar);

		my_M_nowP_bar = new JPanel();
		my_M_nowP_bar.setBackground(Color.GREEN);
		my_M_nowP_bar.setBounds(0, 0, 230, 20);
		my_M_tatalP_bar.add(my_M_nowP_bar);

		my_M_Lv = new JLabel("Lv.1");
		my_M_Lv.setBounds(456, 154, 33, 15);
		Battle_panel.add(my_M_Lv);

		my_M_Name = new JLabel("파이리/파이리");
		my_M_Name.setBounds(259, 154, 99, 15);
		Battle_panel.add(my_M_Name);

		my_M_nowP = new JLabel("90");
		my_M_nowP.setBounds(431, 199, 23, 15);
		Battle_panel.add(my_M_nowP);

		my_M_totalP = new JLabel("/ 100");
		my_M_totalP.setBounds(456, 196, 33, 21);
		Battle_panel.add(my_M_totalP);

		if (o.getPlayer1_id().equals(myID)) {
			player1Setting(o);
		} else if (o.getPlayer2_id().equals(myID)) {
			player2Setting(o);
		}
	}

	public void player2Setting(TC_Object o) {
		// player2이 나자신일 경우
		// 몬스터 이미지 세팅
		String my_Img = o.getPlayer2_Monster_img();
		ImageIcon g = new ImageIcon(my_Img);
		Image t = g.getImage();
		t = t.getScaledInstance(172, 120, java.awt.Image.SCALE_SMOOTH);
		g = new ImageIcon(t);
		my_M_ImageIcon.setIcon(g);

		String opponent_Img = o.getPlayer1_Monster_img();
		ImageIcon g2 = new ImageIcon(opponent_Img);
		Image t2 = g2.getImage();
		t2 = t2.getScaledInstance(172, 120, java.awt.Image.SCALE_SMOOTH);
		g2 = new ImageIcon(t2);
		opponent_M_ImageIcon.setIcon(g2);

		// 몬스터 이름 세팅
		String my_MonsterName = o.getPlayer2_Monster_NiceName() + "/" + o.getPlayer2_Monster_OriginName();
		my_M_Name.setText(my_MonsterName);
		String opponent_MonsterName = o.getPlayer1_Monster_NiceName() + "/" + o.getPlayer1_Monster_OriginName();
		opponent_M_Name.setText(opponent_MonsterName);

		// 몬스터 Lv, totalP, nowP 세팅
		// 내 몬스터
		int my_nowM_Lv = o.getPlayer2_Monster_Lv();
		my_M_Lv.setText("Lv." + String.valueOf(my_nowM_Lv));

		int my_nowM_totalP = o.getPlayer2_Monster_totalP();
		my_M_totalP.setText("/ " + String.valueOf(my_nowM_totalP));

		int my_nowM_nowP = o.getPlayer2_Monster_nowP();
		my_M_nowP.setText(String.valueOf(my_nowM_nowP));

		float s = ((float)my_nowM_nowP / (float)my_nowM_totalP);
		int nowP_bar = (int) ((float)230 * s);
		System.out.println(nowP_bar);
		my_M_nowP_bar.setBounds(0, 0, nowP_bar, 20);

		// 상대 몬스터
		int opponent_nowM_Lv = o.getPlayer1_Monster_Lv();
		opponent_Lv.setText("Lv." + String.valueOf(opponent_nowM_Lv));

		int opponent_totalP = o.getPlayer1_Monster_totalP();
		opponent_M_totalP.setText("/ " + String.valueOf(opponent_totalP));

		int opponent_nowP = o.getPlayer1_Monster_nowP();
		opponent_M_nowP.setText(String.valueOf(opponent_nowP));
		
		s = ((float)opponent_nowP / (float)opponent_totalP);
		nowP_bar = (int)((float)230 * s);
		

		opponent_M_nowP_bar.setBounds(0, 0, nowP_bar, 20);
		
		String Server_msg = o.getPlayer2_msg();
		msgTextArea.setText(Server_msg);
		String order = o.getBattle_order();
		if(order.equals(myID)) {
			attack_btn.setEnabled(true);
			skill_btn.setEnabled(true);
			monsterChange_Btn.setEnabled(true);
			giveUp_btn.setEnabled(true);
		}else {
			attack_btn.setEnabled(false);
			skill_btn.setEnabled(false);
			monsterChange_Btn.setEnabled(false);
			giveUp_btn.setEnabled(false);
		}
		
		
		this.setVisible(true);
	}

	public void player1Setting(TC_Object o) {
		// player1 이 나자신일 경우

		// 몬스터 이미지 세팅
		String my_Img = o.getPlayer1_Monster_img();
		ImageIcon g = new ImageIcon(my_Img);
		Image t = g.getImage();
		t = t.getScaledInstance(172, 120, java.awt.Image.SCALE_SMOOTH);
		g = new ImageIcon(t);
		my_M_ImageIcon.setIcon(g);

		String opponent_Img = o.getPlayer2_Monster_img();
		ImageIcon g2 = new ImageIcon(opponent_Img);
		Image t2 = g2.getImage();
		t2 = t2.getScaledInstance(172, 120, java.awt.Image.SCALE_SMOOTH);
		g2 = new ImageIcon(t2);
		opponent_M_ImageIcon.setIcon(g2);

		// 몬스터 이름 세팅
		String my_MonsterName = o.getPlayer1_Monster_NiceName() + "/" + o.getPlayer1_Monster_OriginName();
		my_M_Name.setText(my_MonsterName);
		String opponent_MonsterName = o.getPlayer2_Monster_NiceName() + "/" + o.getPlayer2_Monster_OriginName();
		opponent_M_Name.setText(opponent_MonsterName);

		// 몬스터 Lv, totalP, nowP 세팅
		// 내 몬스터
		int my_nowM_Lv = o.getPlayer1_Monster_Lv();
		my_M_Lv.setText("Lv." + String.valueOf(my_nowM_Lv));

		int my_nowM_totalP = o.getPlayer1_Monster_totalP();
		my_M_totalP.setText("/ " + String.valueOf(my_nowM_totalP));

		int my_nowM_nowP = o.getPlayer1_Monster_nowP();
		my_M_nowP.setText(String.valueOf(my_nowM_nowP));

		float s = ((float)my_nowM_nowP / (float)my_nowM_totalP);
		int nowP_bar = (int) ((float)230 * s);
		my_M_nowP_bar.setBounds(0, 0, nowP_bar, 20);

		// 상대 몬스터
		int opponent_nowM_Lv = o.getPlayer2_Monster_Lv();
		opponent_Lv.setText("Lv." + String.valueOf(opponent_nowM_Lv));

		int opponent_totalP = o.getPlayer2_Monster_totalP();
		opponent_M_totalP.setText("/ " + String.valueOf(opponent_totalP));

		int opponent_nowP = o.getPlayer2_Monster_nowP();
		opponent_M_nowP.setText(String.valueOf(opponent_nowP));

		s = ((float)opponent_nowP / (float)opponent_totalP);
		nowP_bar = (int)((float)230 * s);

		opponent_M_nowP_bar.setBounds(0, 0, nowP_bar, 20);
		String Server_msg = o.getPlayer1_msg();
		msgTextArea.setText(Server_msg);
		String order = o.getBattle_order();
		if(order.equals(myID)) {
			attack_btn.setEnabled(true);
			skill_btn.setEnabled(true);
			monsterChange_Btn.setEnabled(true);
			giveUp_btn.setEnabled(true);
		}else {
			attack_btn.setEnabled(false);
			skill_btn.setEnabled(false);
			monsterChange_Btn.setEnabled(false);
			giveUp_btn.setEnabled(false);
		}
		
		this.setVisible(true);

	}
}
