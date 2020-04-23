package Server;

import java.io.Serializable;
import java.util.ArrayList;

public class TC_listObject implements Serializable{
	
	private String playerID;
	private int win = 0;
	private int defeat = 0;
	private ArrayList<String[]> battleList = new ArrayList<>();
	
	private String ServerMsg;
	
	public String getServerMsg() {
		return ServerMsg;
	}
	public void setServerMsg(String serverMsg) {
		ServerMsg = serverMsg;
	}
	public String getPlayerID() {
		return playerID;
	}
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	public int getWin() {
		return win;
	}
	public void setWin() {
		this.win = win+1;
	}
	public int getDefeat() {
		return defeat;
	}
	public void setDefeat() {
		this.defeat = defeat+1;
	}
	public ArrayList<String[]> getBattleList() {
		return battleList;
	}
	public void setBattleList(ArrayList<String[]> battleList) {
		this.battleList = battleList;
	}
	public void setAdd_battleLis(String[] s) {
		this.battleList.add(s);
	}
	
}
