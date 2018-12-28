package com.ygo.db.model;

import java.util.Date;

public class LinkArrow {
    private Integer id;

    private Integer monsterHash;

    private Integer arrow;

    private Date modifyTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonsterHash() {
        return monsterHash;
    }

    public void setMonsterHash(Integer monsterHash) {
        this.monsterHash = monsterHash;
    }

    public Integer getArrow() {
        return arrow;
    }

    public void setArrow(Integer arrow) {
        this.arrow = arrow;
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
}