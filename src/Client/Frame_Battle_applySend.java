package Client;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Frame_Battle_applySend extends JFrame{
	private JPanel contentPane;
	
	Frame_Battle_applySend(String opponent_id){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 484);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("님에게 BATTLE 신청중....");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(212, 354, 164, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(opponent_id);
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setBounds(136, 354, 57, 15);
		contentPane.add(lblNewLabel_1);
		
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
		
		JLabel img_Label = new JLabel(g);
		img_Label.setIcon(g);
		img_Label.setBounds(22, 10, 492, 323);
		contentPane.add(img_Label);
		
		this.setVisible(true);
	}
	
	public void Frame_close() {
		this.setVisible(false);
	}
}
