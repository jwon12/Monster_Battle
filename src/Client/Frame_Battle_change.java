package Client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Server.TC_Object;

public class Frame_Battle_change extends JFrame {

	private JPanel contentPane;
	private JLabel m1_nick_Label, m2_nick_Label, m3_nick_Label;
	private JLabel m1_origin_Label, m2_origin_Label, m3_origin_Label;
	private JPanel m1_totalP_bar, m1_nowP_bar, m2_totalP_bar, m2_nowP_bar, m3_totalP_bar, m3_nowP_bar;
	private JLabel m1_Lv, m2_Lv, m3_Lv;
	private JLabel m1_totalP, m1_nowP, m2_totalP, m2_nowP, m3_totalP, m3_nowP;
	private JButton m1_changebtn, m2_changebtn, m3_changebtn;
	private JLabel m1_nowShow, m2_nowShow, m3_nowShow;
	private String myID;
	private String opponectID;
	private C_Analysis s = null;
	private C_TC myTC = null;
	
	public Frame_Battle_change(String playerID) {
		
		this.myID = playerID;
		s = C_Analysis.getInstance();
		myTC = s.getC_TC_mySin();
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		m1_nick_Label = new JLabel("New label");
		m1_nick_Label.setHorizontalAlignment(SwingConstants.CENTER);
		m1_nick_Label.setBounds(33, 10, 57, 15);
		contentPane.add(m1_nick_Label);

		m2_nick_Label = new JLabel("New label");
		m2_nick_Label.setHorizontalAlignment(SwingConstants.CENTER);
		m2_nick_Label.setBounds(33, 70, 57, 15);
		contentPane.add(m2_nick_Label);

		m3_nick_Label = new JLabel("New label");
		m3_nick_Label.setHorizontalAlignment(SwingConstants.CENTER);
		m3_nick_Label.setBounds(33, 130, 57, 15);
		contentPane.add(m3_nick_Label);

		JLabel lblNewLabel = new JLabel("---------");
		lblNewLabel.setBounds(33, 29, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("---------");
		label.setBounds(33, 89, 57, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("---------");
		label_1.setBounds(33, 147, 57, 15);
		contentPane.add(label_1);

		m1_origin_Label = new JLabel("New label");
		m1_origin_Label.setHorizontalAlignment(SwingConstants.CENTER);
		m1_origin_Label.setBounds(33, 45, 57, 15);
		contentPane.add(m1_origin_Label);

		m2_origin_Label = new JLabel("New label");
		m2_origin_Label.setHorizontalAlignment(SwingConstants.CENTER);
		m2_origin_Label.setBounds(33, 105, 57, 15);
		contentPane.add(m2_origin_Label);

		m3_origin_Label = new JLabel("New label");
		m3_origin_Label.setHorizontalAlignment(SwingConstants.CENTER);
		m3_origin_Label.setBounds(33, 160, 57, 15);
		contentPane.add(m3_origin_Label);

		m1_totalP_bar = new JPanel();

		m1_totalP_bar.setBackground(Color.RED);
		m1_totalP_bar.setBounds(102, 10, 230, 20);
		contentPane.add(m1_totalP_bar);
		m1_totalP_bar.setLayout(null);

		m1_nowP_bar = new JPanel();
		m1_nowP_bar.setBackground(Color.GREEN);
		m1_nowP_bar.setBounds(0, 0, 220, 20);
		m1_totalP_bar.add(m1_nowP_bar);

		m2_totalP_bar = new JPanel();
		m2_totalP_bar.setLayout(null);
		m2_totalP_bar.setBackground(Color.RED);
		m2_totalP_bar.setBounds(102, 70, 230, 20);
		contentPane.add(m2_totalP_bar);

		m2_nowP_bar = new JPanel();
		m2_nowP_bar.setBackground(Color.GREEN);
		m2_nowP_bar.setBounds(0, 0, 220, 20);
		m2_totalP_bar.add(m2_nowP_bar);

		m3_totalP_bar = new JPanel();
		m3_totalP_bar.setLayout(null);
		m3_totalP_bar.setBackground(Color.RED);
		m3_totalP_bar.setBounds(102, 130, 230, 20);
		contentPane.add(m3_totalP_bar);

		m3_nowP_bar = new JPanel();
		m3_nowP_bar.setBackground(Color.GREEN);
		m3_nowP_bar.setBounds(0, 0, 220, 20);
		m3_totalP_bar.add(m3_nowP_bar);

		m1_Lv = new JLabel("Lv.");
		m1_Lv.setBounds(102, 40, 57, 15);
		contentPane.add(m1_Lv);

		m2_Lv = new JLabel("Lv.");
		m2_Lv.setBounds(102, 100, 57, 15);
		contentPane.add(m2_Lv);

		m3_Lv = new JLabel("Lv.");
		m3_Lv.setBounds(102, 160, 57, 15);
		contentPane.add(m3_Lv);

		m1_totalP = new JLabel("/100");
		m1_totalP.setBounds(303, 40, 29, 15);
		contentPane.add(m1_totalP);

		m1_nowP = new JLabel("100");
		m1_nowP.setHorizontalAlignment(SwingConstants.RIGHT);
		m1_nowP.setBounds(279, 40, 22, 15);
		contentPane.add(m1_nowP);

		m2_totalP = new JLabel("/100");
		m2_totalP.setBounds(303, 100, 29, 15);
		contentPane.add(m2_totalP);

		m2_nowP = new JLabel("100");
		m2_nowP.setHorizontalAlignment(SwingConstants.RIGHT);
		m2_nowP.setBounds(279, 100, 22, 15);
		contentPane.add(m2_nowP);

		m3_totalP = new JLabel("/100");
		m3_totalP.setBounds(303, 160, 29, 15);
		contentPane.add(m3_totalP);

		m3_nowP = new JLabel("100");
		m3_nowP.setHorizontalAlignment(SwingConstants.RIGHT);
		m3_nowP.setBounds(279, 160, 22, 15);
		contentPane.add(m3_nowP);

		m1_changebtn = new JButton("교체");
		m1_changebtn.setBounds(336, 26, 76, 20);
		m1_changebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mosterChange("m1");

			}
		});
		contentPane.add(m1_changebtn);

		m2_changebtn = new JButton("교체");
		m2_changebtn.setBounds(336, 89, 76, 20);
		m2_changebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mosterChange("m2");

			}
		});
		contentPane.add(m2_changebtn);

		m3_changebtn = new JButton("교체");
		m3_changebtn.setBounds(336, 144, 76, 20);
		m3_changebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mosterChange("m3");

			}
		});
		contentPane.add(m3_changebtn);

		m1_nowShow = new JLabel("");
		m1_nowShow.setBounds(12, 29, 12, 15);
		contentPane.add(m1_nowShow);

		m2_nowShow = new JLabel("");
		m2_nowShow.setBounds(12, 89, 12, 15);
		contentPane.add(m2_nowShow);

		m3_nowShow = new JLabel("");
		m3_nowShow.setBounds(12, 148, 12, 15);
		contentPane.add(m3_nowShow);
	}

	protected void mosterChange(String monsterNumber) {
		String msg;
		switch(monsterNumber) {
		case "m1":
			msg ="/battle In_battle change "+m1_origin_Label.getText()+" "+myID+" "+opponectID;
			myTC.send(msg);
			this.setVisible(false);
			break;
		case "m2":
			msg ="/battle In_battle change "+m2_origin_Label.getText()+" "+myID+" "+opponectID;
			myTC.send(msg);
			this.setVisible(false);
			break;
		case "m3":
			msg ="/battle In_battle change "+m3_origin_Label.getText()+" "+myID+" "+opponectID;
			myTC.send(msg);
			this.setVisible(false);
			break;
		}
		
	}

	public void setting(TC_Object o) {
		int totalP = 0;
		int nowP = 0;
		int nowP_bar = 0;

		if (myID.equals(o.getPlayer1_id())) {
			opponectID = o.getPlayer2_id();
			m1_nick_Label.setText(o.getPlayer1_Monster_NickName_All()[0]);
			m1_origin_Label.setText(o.getPlayer1_Monster_OriginName_All()[0]);
			m1_Lv.setText("Lv." + String.valueOf(o.getPlayer1_Monster_Lv_All()[0]));
			totalP = o.getPlayer1_Monster_totalP_All()[0];
			nowP = o.getPlayer1_Monster_nowP_All()[0];
			if(nowP < 0) {
				nowP = 0;
			}
			m1_totalP.setText("/ " + String.valueOf(totalP));
			m1_nowP.setText(String.valueOf(nowP));
			nowP_bar = nowP_bar_location(totalP, nowP);
			m1_nowP_bar.setBounds(0, 0, nowP_bar, 20);

			m2_nick_Label.setText(o.getPlayer1_Monster_NickName_All()[1]);
			m2_origin_Label.setText(o.getPlayer1_Monster_OriginName_All()[1]);
			m2_Lv.setText("Lv." + String.valueOf(o.getPlayer1_Monster_Lv_All()[1]));
			totalP = o.getPlayer1_Monster_totalP_All()[1];
			nowP = o.getPlayer1_Monster_nowP_All()[1];
			if(nowP < 0) {
				nowP = 0;
			}
			m2_totalP.setText("/ " + String.valueOf(totalP));
			m2_nowP.setText(String.valueOf(nowP));
			nowP_bar = nowP_bar_location(totalP, nowP);
			m2_nowP_bar.setBounds(0, 0, nowP_bar, 20);

			m3_nick_Label.setText(o.getPlayer1_Monster_NickName_All()[2]);
			m3_origin_Label.setText(o.getPlayer1_Monster_OriginName_All()[2]);
			m3_Lv.setText("Lv." + String.valueOf(o.getPlayer1_Monster_Lv_All()[2]));
			totalP = o.getPlayer1_Monster_totalP_All()[2];
			nowP = o.getPlayer1_Monster_nowP_All()[2];
			if(nowP < 0) {
				nowP = 0;
			}
			m3_totalP.setText("/ " + String.valueOf(totalP));
			m3_nowP.setText(String.valueOf(nowP));
			nowP_bar = nowP_bar_location(totalP, nowP);
			m3_nowP_bar.setBounds(0, 0, nowP_bar, 20);

			String nowMonster = o.getPlayer1_Monster_OriginName();

			if (m1_origin_Label.getText().equals(nowMonster)) {
				m1_nowShow.setText("▶");
				m1_changebtn.setEnabled(false);
				m2_nowShow.setText("");
				m2_changebtn.setEnabled(true);
				m3_nowShow.setText("");
				m3_changebtn.setEnabled(true);
			} else if (m2_origin_Label.getText().equals(nowMonster)) {
				m1_nowShow.setText("");
				m1_changebtn.setEnabled(true);
				m2_nowShow.setText("▶");
				m2_changebtn.setEnabled(false);
				m3_nowShow.setText("");
				m3_changebtn.setEnabled(true);
			} else {
				m1_nowShow.setText("");
				m1_changebtn.setEnabled(true);
				m2_nowShow.setText("");
				m2_changebtn.setEnabled(true);
				m3_nowShow.setText("▶");
				m3_changebtn.setEnabled(false);
			}
			setbtn();
			

		} else {
			opponectID = o.getPlayer1_id();
			m1_nick_Label.setText(o.getPlayer2_Monster_NickName_All()[0]);
			m1_origin_Label.setText(o.getPlayer2_Monster_OriginName_All()[0]);
			m1_Lv.setText("Lv." + String.valueOf(o.getPlayer2_Monster_Lv_All()[0]));
			totalP = o.getPlayer2_Monster_totalP_All()[0];
			nowP = o.getPlayer2_Monster_nowP_All()[0];
			if(nowP < 0) {
				nowP = 0;
			}
			m1_totalP.setText("/ " + String.valueOf(totalP));
			m1_nowP.setText(String.valueOf(nowP));
			nowP_bar = nowP_bar_location(totalP, nowP);
			m1_nowP_bar.setBounds(0, 0, nowP_bar, 20);

			m2_nick_Label.setText(o.getPlayer2_Monster_NickName_All()[1]);
			m2_origin_Label.setText(o.getPlayer2_Monster_OriginName_All()[1]);
			m2_Lv.setText("Lv." + String.valueOf(o.getPlayer2_Monster_Lv_All()[1]));
			totalP = o.getPlayer2_Monster_totalP_All()[1];
			nowP = o.getPlayer2_Monster_nowP_All()[1];
			if(nowP < 0) {
				nowP = 0;
			}
			m2_totalP.setText("/ " + String.valueOf(totalP));
			m2_nowP.setText(String.valueOf(nowP));
			nowP_bar = nowP_bar_location(totalP, nowP);
			m2_nowP_bar.setBounds(0, 0, nowP_bar, 20);

			m3_nick_Label.setText(o.getPlayer2_Monster_NickName_All()[2]);
			m3_origin_Label.setText(o.getPlayer2_Monster_OriginName_All()[2]);
			m3_Lv.setText("Lv." + String.valueOf(o.getPlayer2_Monster_Lv_All()[2]));
			totalP = o.getPlayer2_Monster_totalP_All()[2];
			nowP = o.getPlayer2_Monster_nowP_All()[2];
			if(nowP < 0) {
				nowP = 0;
			}
			m3_totalP.setText("/ " + String.valueOf(totalP));
			m3_nowP.setText(String.valueOf(nowP));
			nowP_bar = nowP_bar_location(totalP, nowP);
			m3_nowP_bar.setBounds(0, 0, nowP_bar, 20);
			String nowMonster = o.getPlayer2_Monster_OriginName();

			if (m1_origin_Label.getText().equals(nowMonster)) {
				m1_nowShow.setText("▶");
				m1_changebtn.setEnabled(false);
				m2_nowShow.setText("");
				m2_changebtn.setEnabled(true);
				m3_nowShow.setText("");
				m3_changebtn.setEnabled(true);
			} else if (m2_origin_Label.getText().equals(nowMonster)) {
				m1_nowShow.setText("");
				m1_changebtn.setEnabled(true);
				m2_nowShow.setText("▶");
				m2_changebtn.setEnabled(false);
				m3_nowShow.setText("");
				m3_changebtn.setEnabled(true);
			} else {
				m1_nowShow.setText("");
				m1_changebtn.setEnabled(true);
				m2_nowShow.setText("");
				m2_changebtn.setEnabled(true);
				m3_nowShow.setText("▶");
				m3_changebtn.setEnabled(false);
			}
			setbtn();

		}
		this.setVisible(true);
	}

	private void setbtn() { // 피가 0 인경우 버튼 비활성화
		
		int m1 = Integer.valueOf(m1_nowP.getText());
		int m2 = Integer.valueOf(m2_nowP.getText());
		int m3 = Integer.valueOf(m3_nowP.getText());
		if(m1 == 0) {
			m1_changebtn.setEnabled(false);
		}
		if(m2 == 0) {
			m2_changebtn.setEnabled(false);
		}
		if(m3 == 0) {
			m3_changebtn.setEnabled(false);
		}
		
	}

	private int nowP_bar_location(int totalP, int nowP) {
		float s = (float) nowP / (float) totalP;
		int nowP_bar = (int) ((float) 230 * s);
		return nowP_bar;
	}
}
