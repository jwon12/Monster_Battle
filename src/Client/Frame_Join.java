package Client;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frame_Join extends JFrame{
	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField pwTextField;
	private JTextField NickTextField;
	private JTextField M1_NickTextField;
	private JTextField M2_NickTextField;
	private JTextField M3_NickTextField;
	
	
	Frame_Join(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 329, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(12, 48, 42, 15);
		contentPane.add(idLabel);
		
		JButton ck_IDBttn = new JButton("중복체크");
		ck_IDBttn.setBounds(210, 44, 97, 23);
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
		
		JLabel lblNewLabel_2 = new JLabel("아이디는 10자 이상 특수문자 X");
		lblNewLabel_2.setBounds(22, 76, 229, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel NickLabel = new JLabel("닉네임");
		NickLabel.setBounds(12, 143, 57, 15);
		contentPane.add(NickLabel);
		
		NickTextField = new JTextField();
		NickTextField.setBounds(81, 140, 116, 21);
		contentPane.add(NickTextField);
		NickTextField.setColumns(10);
		
		String[] MonsterList = {"파이리","꼬부기","이상해씨"};

		JComboBox<String> comboBox = new JComboBox<String>(MonsterList);
		comboBox.setBounds(12, 209, 84, 23);
		contentPane.add(comboBox);
		
		M1_NickTextField = new JTextField();
		M1_NickTextField.setBounds(108, 210, 89, 22);
		contentPane.add(M1_NickTextField);
		M1_NickTextField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(210, 309, 97, 23);
		contentPane.add(btnNewButton_1);
		
		M2_NickTextField = new JTextField();
		M2_NickTextField.setColumns(10);
		M2_NickTextField.setBounds(108, 247, 89, 22);
		contentPane.add(M2_NickTextField);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>(MonsterList);
		comboBox_1.setBounds(12, 246, 84, 23);
		contentPane.add(comboBox_1);
		
		M3_NickTextField = new JTextField();
		M3_NickTextField.setColumns(10);
		M3_NickTextField.setBounds(108, 281, 89, 22);
		contentPane.add(M3_NickTextField);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>(MonsterList);
		comboBox_2.setBounds(12, 280, 84, 23);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("Monster");
		lblNewLabel_4.setBounds(26, 185, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Monster 닉네임");
		lblNewLabel_5.setBounds(108, 185, 97, 15);
		contentPane.add(lblNewLabel_5);
		
		this.setVisible(true);
		
	}


	
	
}
