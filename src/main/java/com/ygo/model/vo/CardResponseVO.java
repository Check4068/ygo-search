package com.ygo.model.vo;

import java.util.ArrayList;
import java.util.List;

public class CardResponseVO {
	
	private Integer hashCode;

    private String cName;

    private String jName;

    private String eName;

    private String nwName;

    private String psd;

    private Integer lev;

    private String attribute;

    private String race;

    private String atk;

    private String def;

    private Integer pend;

    private Integer link;

    private String img;

    private String ban;

    private String proprietary;
    
    private List<String> type;
    
    private List<Integer> arrow;

    private String descNw;
    
    private List<PackInfo> infos;
    
    {
    	type = new ArrayList<String>();
    	arrow = new ArrayList<Integer>();
    	infos = new ArrayList<PackInfo>();
    }

	public Integer getHashCode() {
		return hashCode;
	}

	public void setHashCode(Integer hashCode) {
		this.hashCode = hashCode;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getNwName() {
		return nwName;
	}

	public void setNwName(String nwName) {
		this.nwName = nwName;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public Integer getLev() {
		return lev;
	}

	public void setLev(Integer lev) {
		this.lev = lev;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	public String getProprietary() {
		return proprietary;
	}

	public void setProprietary(String proprietary) {
		this.proprietary = proprietary;
	}

	public String getDescNw() {
		return descNw;
	}

	public void setDescNw(String descNw) {
		this.descNw = descNw;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(String type) {
		this.type.add(type);
	}

	public List<Integer> getArrow() {
		return arrow;
	}

	public void setArrow(Integer arrow) {
		this.arrow.add(arrow);
	}
	
	public List<PackInfo> getInfos() {
		return infos;
	}

	public void setInfos(PackInfo infos) {
		this.infos.add(infos);
	}
	

	@Override
	public String toString() {
		return "CardVO [hashCode=" + hashCode + ", cName=" + cName + ", jName=" + jName + ", eName=" + eName
				+ ", nwName=" + nwName + ", psd=" + psd + ", lev=" + lev + ", attribute=" + attribute + ", race=" + race
				+ ", atk=" + atk + ", def=" + def + ", pend=" + pend + ", link=" + link + ", img=" + img + ", ban="
				+ ban + ", proprietary=" + proprietary + ", type=" + type + ", arrow=" + arrow + ", descNw=" + descNw
				+ ", infos=" + infos + "]";
	}


	public static class PackInfo {
		
		private String packName;
		
		private String sellTime;
		
		private String rare;
		
		private String cardNo;

		public String getPackName() {
			return packName;
		}

		public void setPackName(String packName) {
			this.packName = packName;
		}

		public String getSellTime() {
			return sellTime;
		}

		public void setSellTime(String sellTime) {
			this.sellTime = sellTime;
		}

		public String getRare() {
			return rare;
		}

		public void setRare(String rare) {
			this.rare = rare;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		@Override
		public String toString() {
			return "PackInfo [packName=" + packName + ", sellTime=" + sellTime + ", rare=" + rare + ", cardNo=" + cardNo
					+ "]";
		}
		
	}
}
