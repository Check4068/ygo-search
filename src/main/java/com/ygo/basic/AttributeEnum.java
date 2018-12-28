package com.ygo.basic;

public enum AttributeEnum {

	LIGHT(0, "光"),
	EARTH(1, "地"),
	DARK(2, "暗"),
	WATER(3, "水"),
	FIRE(4, "炎"),
	DIVINE(5, "神"),
	WIND(6, "风");
	
    private Integer id;
	
	private String name;
	
	private AttributeEnum(Integer id, String name) {
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
		for (int i = 0; i < AttributeEnum.values().length; i++) {
			if (!AttributeEnum.values()[i].getName().equals(name)) {
				continue;
			}
			
			return AttributeEnum.values()[i].getId();
		}
		
		return null;
	} 
	
	public static String getName(Integer id) {
		for (int i = 0; i < AttributeEnum.values().length; i++) {
			if (!AttributeEnum.values()[i].getId().equals(id)) {
				continue;
			}
			
			return AttributeEnum.values()[i].getName();
		}
		
		return null;
	}
}
