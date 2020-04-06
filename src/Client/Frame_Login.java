package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame_Login extends JFrame{
	JPanel nP,cP,sP;
	JLabel idLable, pwLable;
	JTextField idField, pwdField;
	JButton loginBtn, joinBtn;
	
	
	Frame_Login(){
		this.setLayout(new BorderLayout()); 
		this.setBounds(500, 300, 300, 200);
		
		SetNorth();
		SetCenter();
		SetSouth();
		
		this.add(nP,"North");
		this.add(cP,"Center");
		this.add(sP,"South");
		

		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}



	private void SetSouth() {
		sP = new JPanel();
		loginBtn = new JButton("로그인");
		sP.add(loginBtn);
		joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Frame_Join();
				
			}
		});
		sP.add(joinBtn);
		
	}



	private void SetCenter() {
		cP = new JPanel();
		pwLable = new JLabel("비밀번호");
		cP.add(pwLable);
		pwdField = new JTextField(10);
		cP.add(pwdField);
		
		
		
	}



	private void SetNorth() {
		nP = new JPanel();
		idLable = new JLabel("  아이디  ");
		nP.add(idLable);
		idField = new JTextField(10);
		nP.add(idField);
		
	}
}
