package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Server.TC_Object;

public class Frame_Battle_Skill extends JFrame {
	
	private C_Analysis analysis = null;
	private C_TC myTC = null;
	private JPanel contentPane;
	private JButton Skill_1_btn, Skill_2_btn, Skill_3_btn, Skill_4_btn;
	private String myID;
	private String opponentID;
	private String[][] skill;

	Frame_Battle_Skill(String myID,String opponentID) {
		analysis = C_Analysis.getInstance();
		myTC = analysis.getC_TC_mySin();
		
		this.myID = myID;
		this.opponentID = opponentID;
		
		setBounds(100, 100, 387, 241);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Skill List");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 5, 145, 15);
		contentPane.add(lblNewLabel);

		Skill_1_btn = new JButton("New button");
		Skill_1_btn.setBounds(12, 26, 347, 39);
		contentPane.add(Skill_1_btn);

		Skill_2_btn = new JButton("New button");
		Skill_2_btn.setBounds(12, 68, 347, 39);
		contentPane.add(Skill_2_btn);

		Skill_3_btn = new JButton("New button");
		Skill_3_btn.setBounds(12, 110, 347, 39);
		contentPane.add(Skill_3_btn);

		Skill_4_btn = new JButton("New button");
		Skill_4_btn.setBounds(12, 152, 347, 39);
		contentPane.add(Skill_4_btn);
	}

	// ex) "매력적인 눈빛 / 적중률 70% 대미지 / 공격력+2"
	//     String text = skillName+" / Percent "+Percent+"% Damage / 공격력 +"+damage
	
	public void setting_skill(TC_Object o) {
		if (myID.equals(o.getPlayer1_id())) {
			skill = o.getPlayer1_Monster_Skill();
			for (int i = 0; i < skill.length; i++) {
				String text = "";
				for (int j = 0; j < skill[i].length; j++) {
					if (j == 0) {
						text = text + skill[i][j];
					} else if (j == 1) {
						text = text + " / Percent " + skill[i][j];
					} else if (j == 2) {
						text = text + "% Damage / 공격력 +" + skill[i][j];
						if (i == 0) {
							Skill_1_btn.setText(text);
						} else if (i == 1) {
							Skill_2_btn.setText(text);
						} else if (i == 2) {
							Skill_3_btn.setText(text);
						} else if (i == 3) {
							Skill_4_btn.setText(text);
						}
					}
				}
			}

		} else {
			skill = o.getPlayer2_Monster_Skill();
			for (int i = 0; i < skill.length; i++) {
				String text = "";
				for (int j = 0; j < skill[i].length; j++) {
					if (j == 0) {
						text = text + skill[i][j];
					} else if (j == 1) {
						text = text + " / Percent " + skill[i][j];
					} else if (j == 2) {
						text = text + "% Damage / 공격력 +" + skill[i][j];
						if (i == 0) {
							Skill_1_btn.setText(text);
						} else if (i == 1) {
							Skill_2_btn.setText(text);
						} else if (i == 2) {
							Skill_3_btn.setText(text);
						} else if (i == 3) {
							Skill_4_btn.setText(text);
						}
					}
				}
			}
		}
		btn_Setting();
		this.setVisible(true);
		
	}

	private void btn_Setting() {
		Skill_1_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Use_Skill_1();

			}
		});
		Skill_2_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Use_Skill_2();

			}
		});
		Skill_3_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Use_Skill_3();

			}
		});
		Skill_4_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Use_Skill_4();

			}
		});
	}

	protected void Use_Skill_4() {
		String msg = "/battle In_battle skill skill_4 "+myID+" "+opponentID;
		myTC.send(msg);
		this.setVisible(false);
		
	}

	protected void Use_Skill_3() {
		String msg = "/battle In_battle skill skill_3 "+myID+" "+opponentID;
		myTC.send(msg);
		this.setVisible(false);
		
	}

	protected void Use_Skill_2() {
		String msg = "/battle In_battle skill skill_2 "+myID+" "+opponentID;
		myTC.send(msg);
		this.setVisible(false);

	}

	protected void Use_Skill_1() {

		String msg = "/battle In_battle skill skill_1 "+myID+" "+opponentID;
		myTC.send(msg);
		this.setVisible(false);
	}
}
