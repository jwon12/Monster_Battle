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

public class Frame_Battle_applyRecive extends JFrame{
	private JPanel contentPane;
	private C_TC C_sin = null;
	Frame_Battle_applyRecive(C_TC sin , String sendID , String myID){
		C_sin = sin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 258);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("님에게 BATTLE 신청이 왔습니다.");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 164, 195, 15);
		contentPane.add(lblNewLabel);
		
		JLabel applyName = new JLabel(sendID);
		applyName.setForeground(new Color(255, 69, 0));
		applyName.setBounds(39, 164, 57, 15);
		contentPane.add(applyName);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 147, 144);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 10, 143, 144);
		contentPane.add(panel_1);
		
		JButton ok_btn = new JButton("수락");
		ok_btn.setBounds(49, 189, 97, 23);
		ok_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C_sin.send("/battle applytrue "+sendID+" "+myID);
				Frameclose();
			}
		});
		contentPane.add(ok_btn);
		
		JButton no_btn = new JButton("거절");
		no_btn.setBounds(190, 189, 97, 23);
		no_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				C_sin.send("/battle applyfalse "+sendID+" "+myID);
				Frameclose();
			}
		});
		contentPane.add(no_btn);
		this.setVisible(true);
	}
	private void Frameclose() {
		this.setVisible(false);
		
	}
}
