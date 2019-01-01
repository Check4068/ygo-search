package com.ygo.model.vo;

import java.util.List;

public class CardRequestVO {

	private String atk;
	
	private String def;

	private String name;

	private Integer limit;

	private Integer lev;

	private Integer pend;

	private Integer link;
	
	private Integer type;

	private List<Integer> arrows;

	private List<Integer> others;

	private List<Integer> races;

	private List<Integer> attributes;

	public String getAtk() {
		return atk;
	}

	public void setAtk(String atk) {
		this.atk = atk;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getLev() {
		return lev;
	}

	public void setLev(Integer lev) {
		this.lev = lev;
	}

	public Integer getPend() {
		return pend;
	}

	public void setPend(Integer pend) {
		this.pend = pend;
	}

	public Integer getLink() {
		return link;
	}

	public void setLink(Integer link) {
		this.link = link;
	}

	public List<Integer> getArrows() {
		return arrows;
	}

	public void setArrows(List<Integer> arrows) {
		this.arrows = arrows;
	}

	public List<Integer> getOthers() {
		return others;
	}

	public void setOthers(List<Integer> others) {
		this.others = others;
	}

	public List<Integer> getRaces() {
		return races;
	}

	public void setRaces(List<Integer> races) {
		this.races = races;
	}

	public List<Integer> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Integer> attributes) {
		this.attributes = attributes;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}