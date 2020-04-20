package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frame_Join extends JFrame {
	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField pwTextField;
	private JTextField NickTextField;
	private JTextField M1_NickTextField;
	private JTextField M2_NickTextField;
	private JTextField M3_NickTextField;
	private JComboBox<String> comboBox,comboBox_1,comboBox_2;
	private C_TC client_Sin = null;
	private JLabel idCKLabel;
	private JButton ck_IDBttn;

	Frame_Join(C_TC c) {
		this.client_Sin = c;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 329, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(12, 48, 42, 15);
		contentPane.add(idLabel);

		ck_IDBttn = new JButton("중복체크");
		ck_IDBttn.setBounds(210, 44, 97, 23);

		ck_IDBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ckid = idTextField.getText();
				if (ckid.length() <= 10 && S_CharCkid(ckid)) {
					client_Sin.send("/join ckid " + ckid);
				} else {
					JOptionPane.showMessageDialog(null, "사용할수 없는 아이디입니다.");
				}

			}
		});
		contentPane.add(ck_IDBttn);

		idTextField = new JTextField();
		idTextField.setBounds(81, 45, 116, 21);
		contentPane.add(idTextField);
		idTextField.setColumns(10);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(12, 101, 57, 15);
		contentPane.add(pwLabel);

		pwTextField = new JTextField();
		pwTextField.setBounds(81, 98, 116, 21);
		contentPane.add(pwTextField);
		pwTextField.setColumns(10);

		idCKLabel = new JLabel("아이디는 10자 이하 특수문자 X");
		idCKLabel.setBounds(22, 76, 229, 15);
		contentPane.add(idCKLabel);

		JLabel NickLabel = new JLabel("닉네임");
		NickLabel.setBounds(12, 143, 57, 15);
		contentPane.add(NickLabel);

		NickTextField = new JTextField();
		NickTextField.setBounds(81, 140, 116, 21);
		contentPane.add(NickTextField);
		NickTextField.setColumns(10);

		String[] MonsterList = { "이상해씨", "꼬부기", "닥트리오" };

		comboBox = new JComboBox<String>(MonsterList);
		comboBox.setBounds(12, 209, 84, 23);
		contentPane.add(comboBox);

		M1_NickTextField = new JTextField();
		M1_NickTextField.setBounds(108, 210, 89, 22);
		contentPane.add(M1_NickTextField);
		M1_NickTextField.setColumns(10);

		M2_NickTextField = new JTextField();
		M2_NickTextField.setColumns(10);
		M2_NickTextField.setBounds(108, 247, 89, 22);
		contentPane.add(M2_NickTextField);

		comboBox_1 = new JComboBox<String>(MonsterList);
		comboBox_1.setBounds(12, 246, 84, 23);
		contentPane.add(comboBox_1);

		M3_NickTextField = new JTextField();
		M3_NickTextField.setColumns(10);
		M3_NickTextField.setBounds(108, 281, 89, 22);
		contentPane.add(M3_NickTextField);

		comboBox_2 = new JComboBox<String>(MonsterList);
		comboBox_2.setBounds(12, 280, 84, 23);
		contentPane.add(comboBox_2);

		JLabel lblNewLabel_4 = new JLabel("Monster");
		lblNewLabel_4.setBounds(26, 185, 57, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Monster 닉네임");
		lblNewLabel_5.setBounds(108, 185, 97, 15);
		contentPane.add(lblNewLabel_5);

		JButton joinBttn = new JButton("회원가입");
		joinBttn.setBounds(210, 309, 97, 23);
		joinBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idck = idCKLabel.getText();
				if (!idck.equals("사용가능")) {
					JOptionPane.showMessageDialog(null, "중복체크 하셔야 합니다.");
				} else if (idTextField.getText().equals("") || pwTextField.getText().equals("")
						|| NickTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "필수 칸을 채워주세요.");
				} else if(comboBox.getSelectedItem().equals(comboBox_1.getSelectedItem()) || 
						comboBox.getSelectedItem().equals(comboBox_2.getSelectedItem()) ||
						comboBox_1.getSelectedItem().equals(comboBox_2.getSelectedItem())){
					JOptionPane.showMessageDialog(null, "동일 한 몬스터는 선택할수 없습니다.");
				}else {
					ServerSend();					
				}

			}
		});

		contentPane.add(joinBttn);

		this.setVisible(true);

	}

	public void SuccessPopup() {
		String msg = "사용가능한 아이디 입니다.";
		JOptionPane.showMessageDialog(null, msg);
		idCKLabel.setText("사용가능");
		ck_IDBttn.setEnabled(false);
		idTextField.setEnabled(false);
	}

	public boolean S_CharCkid(String nowid) {
		for (int i = 0; i < nowid.length(); i++) {
			char a = nowid.charAt(i);
			if ((a >= 33 && a <= 47) || (a >= 58 && a <= 64) || (a >= 91 && a <= 96) || (a >= 123 && a <= 126)) {
				return false;
			}
		}
		return true;
	}

	public void falsePopup() {
		JOptionPane.showMessageDialog(null, "사용할수 없는 아이디입니다.");

	}

	private void ServerSend() {
		//comboBox,comboBox_1,comboBox_2
		// M1_NickTextField;
		// M2_NickTextField;
		// M3_NickTextField;
		try {
			String SaveId = idTextField.getText();
			String SavePw = pwTextField.getText();
			String SaveNick = NickTextField.getText();
			String SaveMsg = "/join saveId " + SaveId + " " + SavePw + " " + SaveNick;
			client_Sin.send(SaveMsg);
			Thread.sleep(500);
			
			if(M1_NickTextField.getText().equals("")) {
				M1_NickTextField.setText(comboBox.getSelectedItem().toString());
			}
			if(M2_NickTextField.getText().equals("")) {
				M2_NickTextField.setText(comboBox_1.getSelectedItem().toString());
			}
			if(M3_NickTextField.getText().equals("")) {
				M3_NickTextField.setText(comboBox_2.getSelectedItem().toString());
			}
			String m1 = comboBox.getSelectedItem().toString()+"/"+M1_NickTextField.getText();
			String m2 = comboBox_1.getSelectedItem().toString()+"/"+M2_NickTextField.getText();
			String m3 = comboBox_2.getSelectedItem().toString()+"/"+M3_NickTextField.getText();
			SaveMsg = "/join saveMon "+SaveId+" "+m1+" "+m2+" "+m3;
			client_Sin.send(SaveMsg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void end() {
		this.setVisible(false);
	}

}
