package Client;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Server.TC_listObject;

public class Frame_Room_BattleList extends JFrame{
	
	private JPanel contentPane;
	private JLabel playerID_input_Label,total_input_Label,win_input_Label,defeat_input_Label;
	private JTextArea textArea;
	public Frame_Room_BattleList() {

		setBounds(470, 370, 380, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Player ID :");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 10, 77, 15);
		contentPane.add(lblNewLabel);
		
		playerID_input_Label = new JLabel("playerID");
		playerID_input_Label.setHorizontalAlignment(SwingConstants.LEFT);
		playerID_input_Label.setBounds(93, 10, 192, 15);
		contentPane.add(playerID_input_Label);
		
		JLabel total_Label = new JLabel("TotalGame");
		total_Label.setFont(new Font("굴림", Font.BOLD, 12));
		total_Label.setBounds(12, 35, 77, 15);
		contentPane.add(total_Label);
		
		total_input_Label = new JLabel("20");
		total_input_Label.setBackground(Color.WHITE);
		total_input_Label.setHorizontalAlignment(SwingConstants.CENTER);
		total_input_Label.setBounds(79, 35, 57, 15);
		contentPane.add(total_input_Label);
		
		JLabel win_Label = new JLabel("Win");
		win_Label.setFont(new Font("굴림", Font.BOLD, 12));
		win_Label.setBounds(158, 35, 25, 15);
		contentPane.add(win_Label);
		
		win_input_Label = new JLabel("5");
		win_input_Label.setHorizontalAlignment(SwingConstants.CENTER);
		win_input_Label.setBounds(184, 35, 57, 15);
		contentPane.add(win_input_Label);
		
		JLabel defeat_Label = new JLabel("Defeat");
		defeat_Label.setFont(new Font("굴림", Font.BOLD, 12));
		defeat_Label.setBounds(270, 35, 50, 15);
		contentPane.add(defeat_Label);
		
		defeat_input_Label = new JLabel("5");
		defeat_input_Label.setHorizontalAlignment(SwingConstants.CENTER);
		defeat_input_Label.setBounds(312, 35, 57, 15);
		contentPane.add(defeat_input_Label);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 60, 340, 199);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		contentPane.add(scrollBar);
		scrollBar.setBounds(335, 60, 17, 199);
	}
	
	public void setting(TC_listObject o) {
		playerID_input_Label.setText(o.getPlayerID());
		int totalGame = o.getWin()+o.getDefeat();
		total_input_Label.setText(String.valueOf(totalGame));
		win_input_Label.setText(String.valueOf(o.getWin()));
		defeat_input_Label.setText(String.valueOf(o.getDefeat()));
		ArrayList<String[]> battleList = o.getBattleList();
		for(String[] s : battleList) {
			String text = "";
			text = "  Battle_opponent ID  :  "+ s[2] + "  Resert  :  "+s[1];
			textArea.append(text);
		}
		this.setVisible(true);
	}
}
