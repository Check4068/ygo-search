package com.ygo.model.db;

public class CardPackInfo {

	private Integer cardHash;
	
	private String cardNo;
	
	private String pack;
	
	private String rare;
	
	private String sellTime;

	public Integer getCardHash() {
		return cardHash;
	}

	public void setCardHash(Integer cardHash) {
		this.cardHash = cardHash;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getRare() {
		return rare;
	}

	public void setRare(String rare) {
		this.rare = rare;
	}

	public String getSellTime() {
		return sellTime;
	}

	public void setSellTime(String sellTime) {
		this.sellTime = sellTime;
	}
}
