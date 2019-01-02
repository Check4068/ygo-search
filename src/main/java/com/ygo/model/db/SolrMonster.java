package com.ygo.model.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.solr.client.solrj.beans.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ygo.basic.ArrowEnum;
import com.ygo.basic.AttributeEnum;
import com.ygo.basic.LimitEnum;
import com.ygo.basic.RaceEnum;
import com.ygo.basic.TypeEnum;

@JsonInclude(Include.NON_NULL)
public class SolrMonster implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Field
	private Integer id;
	
	@Field
    private Integer hashCode;
	
	@Field
	private String cName;
	
	@Field
	private String jName;
	
	@Field
	private String eName;
	
	@Field
	private String nwName;
	
	@Field
	private String psd;
	
	@Field
	private Integer lev;
	
	@Field
	private String attribute;
	
	@Field
	private String race;
	
	@Field
	private String atk;
	
	@Field
	private String def;
	
	@Field
	private Integer pend;
	
	@Field
	private Integer link;
	
	@Field
	private String img;
	
	@Field
	private String ban;
	
	@Field
	private String proprietary;
	
	@Field
	private String descNw;
	
	@Field
	private Set<String> arrow;
	
	@Field
	private Set<String> type;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setAttribute(Integer attribute) {
		this.attribute = AttributeEnum.getName(attribute);
	}

	public String getRace() {
		return race;
	}

	public void setRace(Integer race) {
		this.race = RaceEnum.getName(race);
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

	public String getProprietary() {
		return proprietary;
	}

	public void setProprietary(Integer proprietary) {
		this.proprietary = LimitEnum.getName(proprietary);
	}

	public String getDescNw() {
		return descNw;
	}

	public void setDescNw(String descNw) {
		this.descNw = descNw;
	}

	public Set<String> getArrow() {
		return arrow;
	}

	public void setArrow(String arrow) {
		if (arrow.trim().equals("")) {
			return;
		}
		
		this.arrow = new HashSet<String>();
	    for (String string : arrow.split(",")) {
			this.arrow.add(ArrowEnum.getName(Integer.parseInt(string)));
		}
	}

	public Set<String> getType() {
		return type;
	}

	public void setType(String type) {
		if (type.trim().equals("")) {
			return;
		}
		
		this.type = new HashSet<String>();
	    for (String string : type.split(",")) {
			this.type.add(TypeEnum.getName(Integer.parseInt(string)));
		}
	}

	@Override
	public String toString() {
		return "SolrMonster [id=" + id + ", hashCode=" + hashCode + ", cName=" + cName + ", jName=" + jName + ", eName="
				+ eName + ", nwName=" + nwName + ", psd=" + psd + ", lev=" + lev + ", attribute=" + attribute
				+ ", race=" + race + ", atk=" + atk + ", def=" + def + ", pend=" + pend + ", link=" + link + ", img="
				+ img + ", ban=" + getBan() + ", proprietary=" + proprietary + ", descNw=" + descNw + ", arrow=" + arrow
				+ ", type=" + type + "]";
	}

	public String getBan() {
		return ban;
	}

	public void setBan(Integer ban) {
		this.ban = LimitEnum.getName(ban);
	}
}
