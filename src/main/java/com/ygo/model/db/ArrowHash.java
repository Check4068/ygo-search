package com.ygo.model.db;

import java.util.HashSet;
import java.util.Set;

public class ArrowHash {

	private Integer arrow;
	
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

	public Integer getArrow() {
		return arrow;
	}

	public void setArrow(Integer arrow) {
		this.arrow = arrow;
	}
}
