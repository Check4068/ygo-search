package com.ygo.db.model;

import java.util.HashSet;
import java.util.Set;

public class TypeHash {

	private Integer type;
	
	private Set<Integer> hash;

	public Set<Integer> getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = new HashSet<Integer>();
		for (String card : hash.split(",")) {
			this.hash.add(Integer.parseInt(card));
		}
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
