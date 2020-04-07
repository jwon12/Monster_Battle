package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame_Login extends JFrame{
	JPanel nP,cP,sP;
	JLabel idLable, pwLable;
	JTextField idField, pwdField;
	JButton loginBtn, joinBtn;
	C_TC client_Sin = null;
	Frame_Room F_Room = null;
	
	Frame_Login(C_TC c){
		client_Sin = c;
		
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

	public void showPopup(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	private void SetSouth() {
		sP = new JPanel();
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String pw = pwdField.getText();
				if(id.equals("") && pw.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디, 패스워드를 입력하세요.");					
				}else if(id.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
				}else if(pw.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
				}else {
					client_Sin.send("/login "+id+" "+pw);					
				}
			}
		});
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
	
	public void createRoom(String id,String nickName) {
		this.setVisible(false);
		F_Room = new Frame_Room(id,nickName,client_Sin);
		C_Analysis a = C_Analysis.getInstance();
		a.setFrame_RoomSin(F_Room);
	}


}
