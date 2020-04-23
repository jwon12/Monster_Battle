package Client;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
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
		setBounds(100, 100, 555, 484);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("님에게 BATTLE 신청이 왔습니다.");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(212, 354, 195, 15);
		contentPane.add(lblNewLabel);
		
		JLabel applyName = new JLabel(sendID);
		applyName.setForeground(new Color(255, 69, 0));
		applyName.setBounds(136, 354, 57, 15);
		contentPane.add(applyName);
		
		String[] imgList = {"D:\\java_src\\Monster_Battle_ver0.0\\battle_apply_img\\꼬부기.JPG",
				"D:\\java_src\\Monster_Battle_ver0.0\\battle_apply_img\\파이리.JPG",
				"D:\\java_src\\Monster_Battle_ver0.0\\battle_apply_img\\이상해씨.JPG",
				"D:\\java_src\\Monster_Battle_ver0.0\\battle_apply_img\\닥트리오.JPG",
				"D:\\java_src\\Monster_Battle_ver0.0\\battle_apply_img\\속성별 상성.JPG"};
		Random r = new Random();
		int Random_number = r.nextInt(imgList.length);
		
		String img = imgList[Random_number];
		ImageIcon g = new ImageIcon(img);
		Image t = g.getImage();
		t = t.getScaledInstance(492, 323, java.awt.Image.SCALE_SMOOTH);
		g = new ImageIcon(t);
		
		JLabel img_Label = new JLabel("");
		img_Label.setIcon(g);
		img_Label.setBounds(22, 10, 492, 323);
		contentPane.add(img_Label);
		
		JButton ok_btn = new JButton("수락");
		ok_btn.setBounds(108, 385, 97, 23);
		ok_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C_sin.send("/battle applytrue "+sendID+" "+myID);
				Frameclose();
			}
		});
		contentPane.add(ok_btn);
		
		JButton no_btn = new JButton("거절");
		no_btn.setBounds(326, 385, 97, 23);
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
