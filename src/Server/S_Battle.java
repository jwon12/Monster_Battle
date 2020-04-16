package Server;

public class S_Battle {
		// palyer1 몬스터
		String player1_id;

		String player1_Monster1_OriginName;
		String player1_Monster1_NiceName;
		int player1_Monster1_Lv;
		int player1_Monster1_totalP;
		int player1_Monster1_nowP;

		String player1_Monster2_OriginName;
		String player1_Monster2_NiceName;
		int player1_Monster2_Lv;
		int player1_Monster2_totalP;
		int player1_Monster2_nowP;

		String player1_Monster3_OriginName;
		String player1_Monster3_NiceName;
		int player1_Monster3_Lv;
		int player1_Monster3_totalP;
		int player1_Monster3_nowP;

		// palyer2 몬스터
		String player2_id;

		String player2_Monster1_OriginName;
		String player2_Monster1_NiceName;
		int player2_Monster1_Lv;
		int player2_Monster1_totalP;
		int player2_Monster1_nowP;

		String player2_Monster2_OriginName;
		String player2_Monster2_NiceName;
		int player2_Monster2_Lv;
		int player2_Monster2_totalP;
		int player2_Monster2_nowP;

		String player2_Monster3_OriginName;
		String player2_Monster3_NiceName;
		int player2_Monster3_Lv;
		int player2_Monster3_totalP;
		int player2_Monster3_nowP;
		
		S_Battle(String sendID, String reID) {
			this.player1_id = sendID;
			this.player2_id = reID;
		}
	
}
