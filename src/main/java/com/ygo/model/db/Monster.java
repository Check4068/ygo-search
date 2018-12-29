package com.ygo.model.db;

import java.util.Date;

public class Monster {
    private Integer id;

    private Integer hashCode;

    private String cName;

    private String jName;

    private String eName;

    private String nwName;

    private String psd;

    private Integer lev;

    private Integer attribute;

    private Integer race;

    private Integer atk;

    private Integer def;

    private Integer pend;

    private Integer link;

    private String img;

    private Integer ban;

    private Integer proprietary;

    private Date modifyTime;

    private Date createTime;

    private String descNw;

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

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
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

    public Integer getBan() {
        return ban;
    }

    public void setBan(Integer ban) {
        this.ban = ban;
    }

    public Integer getProprietary() {
        return proprietary;
    }

    public void setProprietary(Integer proprietary) {
        this.proprietary = proprietary;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescNw() {
        return descNw;
    }

    public void setDescNw(String descNw) {
        this.descNw = descNw;
    }

	@Override
	public String toString() {
		return "Monster [id=" + id + ", hashCode=" + hashCode + ", cName=" + cName + ", jName=" + jName + ", eName="
				+ eName + ", nwName=" + nwName + ", psd=" + psd + ", lev=" + lev + ", attribute=" + attribute
				+ ", race=" + race + ", atk=" + atk + ", def=" + def + ", pend=" + pend + ", link=" + link + ", img="
				+ img + ", ban=" + ban + ", proprietary=" + proprietary + ", modifyTime=" + modifyTime + ", createTime="
				+ createTime + ", descNw=" + descNw + "]";
	}
    
}