package Client;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Frame_Battle_applySend extends JFrame{
	private JPanel contentPane;
	
	Frame_Battle_applySend(String opponent_id){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 246);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("님에게 BATTLE 신청중....");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(124, 164, 164, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(opponent_id);
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setBounds(59, 164, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 147, 144);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 10, 143, 144);
		contentPane.add(panel_1);
		this.setVisible(true);
	}
	
	public void Frame_close() {
		this.setVisible(false);
	}
}
