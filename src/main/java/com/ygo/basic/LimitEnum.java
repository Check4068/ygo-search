package com.ygo.basic;

public enum LimitEnum {

	FORBIDDEN(0, "禁止卡"),
	LIMITED(1, "限制卡"),
	SEMI(2, "准限制卡"),
	NONE(3, "无限制"),
	OCG(4, "OCG专有卡"),
	TCG(5, "TCG专有卡"),
	NORMAL(6, "");
	
	private Integer id;
	
	private String name;
	
	private LimitEnum(Integer id, String name) {
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
		for (int i = 0; i < LimitEnum.values().length; i++) {
			if (!LimitEnum.values()[i].getName().equals(name)) {
				continue;
			}
			
			return LimitEnum.values()[i].getId();
		}
		
		return null;
	}
	
	public static String getName(Integer id) {
		for (int i = 0; i < LimitEnum.values().length; i++) {
			if (!LimitEnum.values()[i].getId().equals(id)) {
				continue;
			}
			
			return LimitEnum.values()[i].getName();
		}
		
		return null;
	}
}
