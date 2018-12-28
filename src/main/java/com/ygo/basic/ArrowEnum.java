package com.ygo.basic;

public enum ArrowEnum {
	
	ARROW_1(1, "↙"),
	ARROW_2(2, "↓"),
	ARROW_3(3, "↘"),
	ARROW_4(4, "←"),
	ARROW_6(6, "→"),
	ARROW_7(7, "↖"),
	ARROW_8(8, "↑"),
	ARROW_9(9, "↗");

    private Integer id;

	private String name;

	private ArrowEnum(Integer id, String name) {
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
		for (int i = 0; i < ArrowEnum.values().length; i++) {
			if (!ArrowEnum.values()[i].getName().equals(name)) {
				continue;
			}
			
			return ArrowEnum.values()[i].getId();
		}
		
		return null;
	}
	
	public static String getName(Integer id) {
		for (int i = 0; i < ArrowEnum.values().length; i++) {
			if (!ArrowEnum.values()[i].getId().equals(id)) {
				continue;
			}
			
			return ArrowEnum.values()[i].getName();
		}
		
		return null;
	}
}
