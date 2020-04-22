package Server;

import java.util.ArrayList;
import java.util.Random;

public class S_Analysis_Battle {
	S_Analysis s = null;
	ArrayList<S_Battle> battleList = new ArrayList<>();
	DAO_Monster DAO_sin = null;
	Random r = new Random();

	public void ckMsg(String msg) {
		s = S_Analysis.getInstance();
		int index = 0;
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		String commend = msg.substring(0, index);
		String tail = msg.substring(index + 1);
		switch (commend) {
		case "apply":
			apply(tail);
			break;
		case "applytrue":
			applytrue(tail);
			break;
		case "applyfalse":
			applyfalse(tail);
			break;
		case "In_battle":
			in_battle(tail);
			break;
		}
	}

	private void in_battle(String tail) {
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		String commend = tail.substring(0, index);
		tail = tail.substring(index + 1);
		switch (commend) {
		case "attack":
			attack(tail);
			break;
		case "change":
			change(tail);
			break;
		case "skill":
			skill(tail);
			break;
		}

	}

	private void skill(String tail) {
		int blankIndex = get_blankIndex(tail);
		String skill = tail.substring(0, blankIndex);
		tail = tail.substring(blankIndex + 1);
		blankIndex = get_blankIndex(tail);
		String useID = tail.substring(0, blankIndex);
		String reID = tail.substring(blankIndex + 1);
		S_Battle now_Battle = null;

		for (S_Battle b : battleList) {
			if (b.player1_id.equals(useID) && b.player2_id.equals(reID)
					|| b.player2_id.equals(useID) && b.player1_id.equals(reID)) {
				now_Battle = b;
				break;
			}
		}
		String player1ID = now_Battle.player1_id;
		String player2ID = now_Battle.player2_id;

		int skill_number = 0;

		switch (skill) {
		case "skill_1":
			skill_number = 0;
			break;
		case "skill_2":
			skill_number = 1;
			break;
		case "skill_3":
			skill_number = 2;
			break;
		case "skill_4":
			skill_number = 3;
			break;
		}

		if (player1ID.equals(useID)) {

			int skillPercent = Integer.valueOf(now_Battle.now_player1_Monster_Skill[skill_number][1]);
			String skillName = now_Battle.now_player1_Monster_Skill[skill_number][0];
			boolean Success_ck = skillRandom(skillPercent);

			if (Success_ck) {
				int player1_M_number = 0;
				int player2_M_number = 0;
				for (int i = 0; i < now_Battle.player1_Monster_OriginName.length; i++) {
					if (now_Battle.now_player1_Monster_OriginName.equals(now_Battle.player1_Monster_OriginName[i])) {
						player1_M_number = i;
						break;
					}
				}
				for (int i = 0; i < now_Battle.player2_Monster_OriginName.length; i++) {
					if (now_Battle.now_player2_Monster_OriginName.equals(now_Battle.player2_Monster_OriginName[i])) {
						player2_M_number = i;
						break;
					}
				}
				int player1_M_attack = now_Battle.player1_Monster_attack[player1_M_number];
				int player2_M_armor = now_Battle.player2_Monster_armor[player2_M_number];
				int p1ayer1_M_skill_D = Integer.valueOf(now_Battle.now_player1_Monster_Skill[skill_number][2]);
				int count = player1_M_attack - player2_M_armor;
				String player1_Monster_property = now_Battle.player1_Monster_property[player1_M_number];
				String player2_Monster_property = now_Battle.player2_Monster_property[player2_M_number];
				int property_D = Monster_property(player1_Monster_property, player2_Monster_property);
				int Damage = 0;
				if (property_D > 0) {
					if (count > 0) {
						count = count + p1ayer1_M_skill_D;
						Damage = (count * property_D);
						now_Battle.player2_Monster_nowP[player2_M_number] = now_Battle.player2_Monster_nowP[player2_M_number]
								- Damage;
					} else {
						Damage = ((1 + p1ayer1_M_skill_D) * property_D);
						now_Battle.player2_Monster_nowP[player2_M_number] = now_Battle.player2_Monster_nowP[player2_M_number]
								- Damage;
					}
				} else {
					if (count > 0) {
						count = count + p1ayer1_M_skill_D;
						Damage = (int) (((float) count) * ((float) 2));
						now_Battle.player2_Monster_nowP[player2_M_number] = now_Battle.player2_Monster_nowP[player2_M_number]
								- Damage;
					} else {
						Damage = 1 + p1ayer1_M_skill_D;
						now_Battle.player2_Monster_nowP[player2_M_number] = now_Battle.player2_Monster_nowP[player2_M_number]
								- Damage;
					}
				}
				now_Battle.order = reID;
				now_Battle.player1_msg = now_Battle.now_player1_Monster_NickName + " 가 \n스킬 공격\n" + skillName + " 스킬 \n"
						+ Damage + " 만큼의 데미지를 줬습니다.";
				now_Battle.player2_msg = now_Battle.now_player1_Monster_NickName + " 가 \n스킬 공격\n" + skillName + " 스킬 \n"
						+ Damage + " 만큼의 데미지를 받았습니다.";
			} else {
				now_Battle.order = reID;
				now_Battle.player1_msg = now_Battle.now_player1_Monster_NickName + " 가 \n스킬 공격에 실패하였습니다.";
				now_Battle.player2_msg = now_Battle.now_player1_Monster_NickName + " 가 \n스킬 공격에 실패하였습니다.";

//					now_Battle.order = reID;
//					now_Battle.player1_msg = now_Battle.now_player2_Monster_NickName + " 가 \n스킬 공격에 실패하였습니다.";
//					now_Battle.player2_msg = now_Battle.now_player2_Monster_NickName + " 가 \n스킬 공격에 실패하였습니다.";
//				
			}

		} else {
			// 플레이어2가 스킬

			int skillPercent = Integer.valueOf(now_Battle.now_player2_Monster_Skill[skill_number][1]);
			String skillName = now_Battle.now_player2_Monster_Skill[skill_number][0];
			boolean Success_ck = skillRandom(skillPercent);

			if (Success_ck) {
				int player1_M_number = 0;
				int player2_M_number = 0;
				for (int i = 0; i < now_Battle.player1_Monster_OriginName.length; i++) {
					if (now_Battle.now_player1_Monster_OriginName.equals(now_Battle.player1_Monster_OriginName[i])) {
						player1_M_number = i;
						break;
					}
				}
				for (int i = 0; i < now_Battle.player2_Monster_OriginName.length; i++) {
					if (now_Battle.now_player2_Monster_OriginName.equals(now_Battle.player2_Monster_OriginName[i])) {
						player2_M_number = i;
						break;
					}
				}
				int player2_M_attack = now_Battle.player2_Monster_attack[player2_M_number];
				int player1_M_armor = now_Battle.player1_Monster_armor[player1_M_number];
				int p1ayer2_M_skill_D = Integer.valueOf(now_Battle.now_player2_Monster_Skill[skill_number][2]);
				int count = player2_M_attack - player1_M_armor;
				String player1_Monster_property = now_Battle.player1_Monster_property[player1_M_number];
				String player2_Monster_property = now_Battle.player2_Monster_property[player2_M_number];
				int property_D = Monster_property(player2_Monster_property, player1_Monster_property);
				int Damage = 0;
				if (property_D > 0) {
					if (count > 0) {
						count = count + p1ayer2_M_skill_D;
						Damage = (count * property_D);
						now_Battle.player1_Monster_nowP[player1_M_number] = now_Battle.player1_Monster_nowP[player1_M_number]
								- Damage;
					} else {
						Damage = ((1 + p1ayer2_M_skill_D) * property_D);
						now_Battle.player1_Monster_nowP[player1_M_number] = now_Battle.player1_Monster_nowP[player1_M_number]
								- Damage;
					}
				} else {
					if (count > 0) {
						count = count + p1ayer2_M_skill_D;
						Damage = (int) (((float) count) * ((float) 2));
						now_Battle.player1_Monster_nowP[player1_M_number] = now_Battle.player1_Monster_nowP[player1_M_number]
								- Damage;
					} else {
						Damage = 1 + p1ayer2_M_skill_D;
						now_Battle.player1_Monster_nowP[player1_M_number] = now_Battle.player1_Monster_nowP[player1_M_number]
								- Damage;
					}
				}
				now_Battle.order = reID;
				now_Battle.player1_msg = now_Battle.now_player2_Monster_NickName + " 가 \n스킬 공격\n" + skillName + " 스킬 \n"
						+ Damage + " 만큼의 데미지를 줬습니다.";
				now_Battle.player2_msg = now_Battle.now_player2_Monster_NickName + " 가 \n스킬 공격\n" + skillName + " 스킬 \n"
						+ Damage + " 만큼의 데미지를 받았습니다.";
			} else {
				now_Battle.order = reID;
				now_Battle.player1_msg = now_Battle.now_player2_Monster_NickName + " 가 \n스킬 공격에 실패하였습니다.";
				now_Battle.player2_msg = now_Battle.now_player2_Monster_NickName + " 가 \n스킬 공격에 실패하였습니다.";

			}
		}
		TC_Object object = TC_ObjectSet(now_Battle);
		ArrayList<S_TC> TCList = s.getTCList();
		for (S_TC s : TCList) {
			if (s.getID().equals(useID) || s.getID().equals(reID)) {
				s.O_send(object);
			}
		}
	}

	private int Monster_property(String SkillUse_Monster_property, String recive_Monster_property) {
		int property_D = 0;
		switch (SkillUse_Monster_property) {
		case "graff":
			if (recive_Monster_property.equals("water")) {
				property_D = 2;
			} else if (recive_Monster_property.equals("fire")) {
				property_D = 0;
			} else {
				property_D = 1;
			}
			break;
		case "water":
			if (recive_Monster_property.equals("ground")) {
				property_D = 2;
			} else if (recive_Monster_property.equals("graff")) {
				property_D = 0;
			} else {
				property_D = 1;
			}
			break;
		case "fire":
			if (recive_Monster_property.equals("graff")) {
				property_D = 2;
			} else if (recive_Monster_property.equals("ground")) {
				property_D = 0;
			} else {
				property_D = 1;
			}
			break;
		case "ground":
			if (recive_Monster_property.equals("fire")) {
				property_D = 2;
			} else if (recive_Monster_property.equals("water")) {
				property_D = 0;
			} else {
				property_D = 1;
			}
			break;
		}
		return property_D;
	}

	private boolean skillRandom(int i) {
		int Random_number = r.nextInt(10);
		switch (i) {
		case 70:
			if (Random_number == 1 || Random_number == 3 || Random_number == 5) {
				return false;
			}
			return true;
		case 60:
			if (Random_number == 1 || Random_number == 3 || Random_number == 5 || Random_number == 7) {
				return false;
			}
			return true;
		case 50:
			if (Random_number == 1 || Random_number == 3 || Random_number == 5 || Random_number == 7
					|| Random_number == 9) {
				return false;
			}
			return true;
		case 40:
			if (Random_number == 0 || Random_number == 1 || Random_number == 3 || Random_number == 5
					|| Random_number == 7 || Random_number == 9) {
				return false;
			}
			return true;
		}
		return false;
	}

	private void change(String tail) {
		int blankIndex = get_blankIndex(tail);
		String monster_origin = tail.substring(0, blankIndex);
		tail = tail.substring(blankIndex + 1);

		blankIndex = get_blankIndex(tail);
		String myID = tail.substring(0, blankIndex);
		String opponectID = tail.substring(blankIndex + 1);
		S_Battle now_Battle = null;
		for (S_Battle b : battleList) {
			if (b.player1_id.equals(myID) && b.player2_id.equals(opponectID)) {
				int monster_index = 0;
				for (int i = 0; i < b.player1_Monster_OriginName.length; i++) {
					if (monster_origin.equals(b.player1_Monster_OriginName[i])) {
						monster_index = i;
						break;
					}
				}
				b.now_player1_Monster_OriginName = monster_origin;
				b.now_player1_Monster_NickName = b.player1_Monster_NickName[monster_index];
				b.order = b.player2_id;
				String msg = myID + " 님이 " + b.now_player1_Monster_NickName + " 으로 교체하였습니다.";
				b.player1_msg = msg;
				b.player2_msg = msg;
				now_Battle = b;
				break;
			} else if (b.player1_id.equals(opponectID) && b.player2_id.equals(myID)) {
				int monster_index = 0;
				for (int i = 0; i < b.player2_Monster_OriginName.length; i++) {
					if (monster_origin.equals(b.player2_Monster_OriginName[i])) {
						monster_index = i;
						break;
					}
				}
				b.now_player2_Monster_OriginName = monster_origin;
				b.now_player2_Monster_NickName = b.player2_Monster_NickName[monster_index];
				b.order = b.player1_id;
				String msg = myID + " 님이 " + b.now_player2_Monster_NickName + " 으로 교체하였습니다.";
				b.player1_msg = msg;
				b.player2_msg = msg;
				now_Battle = b;
				break;
			}
		}
		now_Battle.settingSkill();

		TC_Object object = TC_ObjectSet(now_Battle);
		ArrayList<S_TC> TCList = s.getTCList();
		for (S_TC s : TCList) {
			if (s.getID().equals(myID) || s.getID().equals(opponectID)) {
				s.O_send(object);
			}
		}
	}

	private int get_blankIndex(String tail) {
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		return index;
	}

	private void attack(String tail) {
		int blankIndex = get_blankIndex(tail);

		String attackID = tail.substring(0, blankIndex);
		String reID = tail.substring(blankIndex + 1);
		System.out.println("공격자 :" + attackID + "받는자 :" + reID);
		S_Battle nowBattle = null;
		for (S_Battle b : battleList) {
			if ((b.player1_id.equals(attackID) && b.player2_id.equals(reID))
					|| (b.player1_id.equals(reID) && b.player2_id.equals(attackID))) {
				nowBattle = b;
				break;
			}
		}
		int j = r.nextInt(10);
		if (j != 0) {
			if (nowBattle.player1_id.equals(attackID)) {
				int player1_M_number = 0;
				int player2_M_number = 0;
				for (int i = 0; i < nowBattle.player1_Monster_OriginName.length; i++) {
					if (nowBattle.player1_Monster_OriginName[i].equals(nowBattle.now_player1_Monster_OriginName)) {
						player1_M_number = i;
						break;
					}
				}
				for (int i = 0; i < nowBattle.player2_Monster_OriginName.length; i++) {
					if (nowBattle.player2_Monster_OriginName[i].equals(nowBattle.now_player2_Monster_OriginName)) {
						player2_M_number = i;
						break;
					}
				}
				int player1_M_attack = nowBattle.player1_Monster_attack[player1_M_number];
				int player2_M_armor = nowBattle.player2_Monster_armor[player2_M_number];
				int count = player1_M_attack - player2_M_armor;
				if (count > 0) {
					nowBattle.player2_Monster_nowP[player2_M_number] = nowBattle.player2_Monster_nowP[player2_M_number]
							- count;
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(count) + " 만큼의 데미지를 받았습니다.";
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(count) + " 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				} else {
					nowBattle.player2_Monster_nowP[player2_M_number] = nowBattle.player2_Monster_nowP[player2_M_number]
							- 1;
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(1) + " 만큼의 데미지를 받았습니다.";
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(1) + " 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				}
			} else {
				// 플레이어2가 공격 한경우

				int player1_M_number = 0;
				int player2_M_number = 0;
				for (int i = 0; i < nowBattle.player1_Monster_OriginName.length; i++) {
					if (nowBattle.player1_Monster_OriginName[i].equals(nowBattle.now_player1_Monster_OriginName)) {
						player1_M_number = i;
						break;
					}
				}
				for (int i = 0; i < nowBattle.player2_Monster_OriginName.length; i++) {
					if (nowBattle.player2_Monster_OriginName[i].equals(nowBattle.now_player2_Monster_OriginName)) {
						player2_M_number = i;
						break;
					}
				}
				int player2_M_attack = nowBattle.player2_Monster_attack[player2_M_number];
				int player1_M_armor = nowBattle.player1_Monster_armor[player1_M_number];
				int count = player2_M_attack - player1_M_armor;
				if (count > 0) {
					nowBattle.player1_Monster_nowP[player1_M_number] = nowBattle.player1_Monster_nowP[player1_M_number]
							- count;
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(count) + " 만큼의 데미지를 받았습니다.";
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(count) + " 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				} else {
					nowBattle.player1_Monster_nowP[player1_M_number] = nowBattle.player1_Monster_nowP[player1_M_number]
							- 1;
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(1) + " 만큼의 데미지를 받았습니다.";
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName + " 에게 \n" + "공격 "
							+ String.valueOf(1) + " 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				}
			}
		} else {
			if (nowBattle.player1_id.equals(attackID)) {
				nowBattle.order = reID;
				nowBattle.player1_msg = nowBattle.now_player1_Monster_NickName + " 가 \n공격에 실패하였습니다.";
				nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName + " 가 \n공격에 실패하였습니다.";
			} else {
				nowBattle.order = reID;
				nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName + " 가 \n공격에 실패하였습니다.";
				nowBattle.player2_msg = nowBattle.now_player2_Monster_NickName + " 가 \n공격에 실패하였습니다.";
			}

		}
		TC_Object object = TC_ObjectSet(nowBattle);
		ArrayList<S_TC> TCList = s.getTCList();
		for (S_TC s : TCList) {
			if (s.getID().equals(attackID) || s.getID().equals(reID)) {
				s.O_send(object);
			}
		}
	}

	private void applyfalse(String tail) {
		int blankIndex = get_blankIndex(tail);

		String sendID = tail.substring(0, blankIndex);
		String reID = tail.substring(blankIndex + 1);
		ArrayList<S_TC> TCList = s.getTCList();
		for (S_TC tc : TCList) {
			if (tc.getID().equals(sendID)) {
				tc.send("/battle reject " + reID);
			}
		}

	}

	private void applytrue(String tail) {
		DAO_sin = DAO_Monster.getInstance();
		int blankIndex = get_blankIndex(tail);

		String sendID = tail.substring(0, blankIndex);
		String reID = tail.substring(blankIndex + 1);
		S_Battle battle = new S_Battle(sendID, reID);
		battleList.add(battle);

		battleSet(battle); // 배틀 클래스 세팅

		TC_Object object = TC_ObjectSet(battle); // 직력화 개체 세팅

		ArrayList<S_TC> TCList = s.getTCList();
		for (S_TC tc : TCList) {
			if (tc.getID().equals(reID) || tc.getID().equals(sendID)) {
				tc.O_send(object);
			}
		}

	}

	private TC_Object TC_ObjectSet(S_Battle battle) {
		TC_Object object = new TC_Object();
		// 몬스터 전체 셋
		object.setPlayer1_Monster_OriginName_All(battle.player1_Monster_OriginName);
		object.setPlayer1_Monster_NickName_All(battle.player1_Monster_NickName);
		object.setPlayer1_Monster_Lv_All(battle.player1_Monster_Lv);
		object.setPlayer1_Monster_totalP_All(battle.player1_Monster_totalP);
		object.setPlayer1_Monster_nowP_All(battle.player1_Monster_nowP);

		object.setPlayer2_Monster_OriginName_All(battle.player2_Monster_OriginName);
		object.setPlayer2_Monster_NickName_All(battle.player2_Monster_NickName);
		object.setPlayer2_Monster_Lv_All(battle.player2_Monster_Lv);
		object.setPlayer2_Monster_totalP_All(battle.player2_Monster_totalP);
		object.setPlayer2_Monster_nowP_All(battle.player2_Monster_nowP);

		object.setPlayer1_id(battle.player1_id);
		object.setPlayer1_Monster_OriginName(battle.now_player1_Monster_OriginName);
		object.setPlayer1_Monster_NiceName(battle.now_player1_Monster_NickName);

		for (int i = 0; i < battle.player1_Monster_OriginName.length; i++) {
			if (battle.now_player1_Monster_OriginName.equals(battle.player1_Monster_OriginName[i])) {
				object.setPlayer1_Monster_Lv(battle.player1_Monster_Lv[i]);
				object.setPlayer1_Monster_totalP(battle.player1_Monster_totalP[i]);
				object.setPlayer1_Monster_nowP(battle.player1_Monster_nowP[i]);
				object.setPlayer1_Monster_img(battle.player1_Monster_img[i]);
				break;
			}
		}

		object.setPlayer2_id(battle.player2_id);
		object.setPlayer2_Monster_OriginName(battle.now_player2_Monster_OriginName);
		object.setPlayer2_Monster_NiceName(battle.now_player2_Monster_NickName);

		for (int i = 0; i < battle.player2_Monster_OriginName.length; i++) {
			if (battle.now_player2_Monster_OriginName.equals(battle.player2_Monster_OriginName[i])) {
				object.setPlayer2_Monster_Lv(battle.player2_Monster_Lv[i]);
				object.setPlayer2_Monster_totalP(battle.player2_Monster_totalP[i]);
				object.setPlayer2_Monster_nowP(battle.player2_Monster_nowP[i]);
				object.setPlayer2_Monster_img(battle.player2_Monster_img[i]);
				break;
			}
		}

		object.setPlayer1_Monster_Skill(battle.now_player1_Monster_Skill);
		object.setPlayer2_Monster_Skill(battle.now_player2_Monster_Skill);

		object.setBattle_order(battle.order);
		object.setPlayer1_msg(battle.player1_msg);
		object.setPlayer2_msg(battle.player2_msg);

		return object;
	}

	private void battleSet(S_Battle battle) {
		int i = 0;
		int j = 0;
		ArrayList<DTO_Monster> mList = DAO_sin.selAll();
		for (DTO_Monster m : mList) {
			if (m.getId().equals(battle.player1_id)) {
				battle.player1_Monster_OriginName[i] = m.getOrigin();
				battle.player1_Monster_NickName[i] = m.getNickname();
				battle.player1_Monster_Lv[i] = m.getLv();
				i++;
			} else if (m.getId().equals(battle.player2_id)) {
				battle.player2_Monster_OriginName[j] = m.getOrigin();
				battle.player2_Monster_NickName[j] = m.getNickname();
				battle.player2_Monster_Lv[j] = m.getLv();
				j++;
			}
		}
		battle.init();

	}

	private void apply(String tail) {

		int blankIndex = get_blankIndex(tail);

		String sendID = tail.substring(0, blankIndex);
		String reID = tail.substring(blankIndex + 1);
		ArrayList<S_TC> TCList = s.getTCList();
		for (S_TC tc : TCList) {
			if (tc.getID().equals(reID)) {
				tc.send("/battle apply " + sendID + " " + reID);
				break;
			}
		}
	}
}
