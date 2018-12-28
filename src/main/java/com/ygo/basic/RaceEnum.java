package com.ygo.basic;

public enum RaceEnum {

	AQUA(0, "水"),
	BEAST(1, "兽"),
	BEAST_WARRIOR(2, "兽战士"),
	GOD(3, "创造神"),
	DINOSAUR(4, "恐龙"),
	DIVINE_BEAST(5, "幻神兽"),
	DRAGON(6, "龙"),
	FAIRY(7, "天使"),
	FIEND(8, "恶魔"),
	FISH(9, "鱼"),
	INSECT(10, "昆虫"),
	MACHINE(11, "机械"),
	PLANT(12, "植物"),
	PSYCHIC(13, "念动力"),
	PYRO(14, "炎"),
	REPTILE(15, "爬虫类"),
	ROCK(16, "岩石"),
    SEA_SERPENT(17, "海龙"),
    SPELLCASTER(18, "魔法师"),
	THUNDER(19, "雷"),
	WARRIOR(20, "战士"),
	WINGED_BEAST(21, "鸟兽"),
	ZOMBIE(22, "不死"),
	WYRM(23, "幻龙"),
	CYBERSE(24, "电子界");
	
    private Integer id;
	
	private String name;
	
	private RaceEnum(Integer id, String name) {
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
		for (int i = 0; i < RaceEnum.values().length; i++) {
			if (!RaceEnum.values()[i].getName().equals(name)) {
				continue;
			}
			
			return RaceEnum.values()[i].getId();
		}
		
		return null;
	}
	
	public static String getName(Integer id) {
		for (int i = 0; i < RaceEnum.values().length; i++) {
			if (!RaceEnum.values()[i].getId().equals(id)) {
				continue;
			}
			
			return RaceEnum.values()[i].getName();
		}
		
		return null;
	}
}
