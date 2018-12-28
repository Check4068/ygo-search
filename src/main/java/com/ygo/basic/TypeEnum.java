package com.ygo.basic;

public enum TypeEnum {

	MONSTER(0, "怪兽"),
	MAGIC(1, "魔法"),
	TRAP(2, "陷阱"),
	EQUIP(3, "装备"),
	FIELD(4, "场地"),
	QUICK_PLAY(5, "速攻"),
	RITUAL(6, "仪式"),
	CONTINUOUS(7, "永续"),
	COUNTER(8, "反击"),
	NORMAL(9, "通常"),
	EFFECT(10, "效果"),
	FUSION(11, "融合"),
	SYNCHRO(12, "同调"),
	XYZ(13, "XYZ"),
	TOON(14, "卡通"),
	UNION(15, "同盟"),
	SPIRIT(16, "灵魂"),
	TUNER(17, "调整"),
	GEMINI(18, "二重"),
	PENDULUM(19, "灵摆"),
	FLIP(20, "反转"),
	LINK(21, "连接"),
	SPECIAL_SUMMON(22, "特殊召唤");
	
    private Integer id;
	
	private String name;
	
	private TypeEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static Integer getId(String name) {
		for (int i = 0; i < TypeEnum.values().length; i++) {
			if (!TypeEnum.values()[i].getName().equals(name)) {
				continue;
			}
			
			return TypeEnum.values()[i].getId();
		}
		
		return null;
	}
	
	public static String getName(Integer id) {
		for (int i = 0; i < TypeEnum.values().length; i++) {
			if (!TypeEnum.values()[i].getId().equals(id)) {
				continue;
			}
			
			return TypeEnum.values()[i].getName();
		}
		
		return null;
	}
}
