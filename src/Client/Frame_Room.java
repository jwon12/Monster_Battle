package Client;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frame_Room extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String myID = null;
	private String myNickName = null;
	private C_TC ClientSin = null;
	private JList list;
	private JTextArea textArea;
	DefaultListModel<String> lm = new DefaultListModel<String>();

	public Frame_Room(String id, String nickName, C_TC Sin) {
		super("대화방");
		ClientSin = Sin;
		myID = id;
		myNickName = nickName;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("접속자");
		lblNewLabel.setBounds(64, 25, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("채팅");
		lblNewLabel_1.setBounds(306, 25, 57, 15);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(12, 380, 351, 30);
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = textField.getText();
				textField.setText("");
				ClientSin.send("/room chat "+myID+" "+msg);
				
			}
		});
		
		contentPane.add(textField);
		textField.setColumns(10);

		JButton sendButton = new JButton("보내기");
		sendButton.setBounds(375, 383, 97, 23);
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = textField.getText();
				textField.setText("");
				ClientSin.send("/room chat "+myID+" "+msg);
			}
		});
		contentPane.add(sendButton);

		
		list = new JList(lm);
		lm.addElement(myID);
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(12, 50, 146, 320);
		contentPane.add(list);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(list, popupMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("대전 신청");
		popupMenu.add(mntmNewMenuItem);

		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(170, 50, 312, 320);
		contentPane.add(textArea);

		this.setVisible(true);
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
	public String getMyNickName() {
		return myNickName;
	}
	public String getMyID() {
		return myID;
	}

	public void setMyNickName(String myNickName) {
		this.myNickName = myNickName;
	}

	public void setaddId(String id) {
		lm.addElement(id);
		this.setVisible(true);
	}

	public void setChat(String idmsg) {
		textArea.append(idmsg);
	}
}
