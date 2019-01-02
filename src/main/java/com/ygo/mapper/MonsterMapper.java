package com.ygo.mapper;

import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import com.ygo.model.db.Monster;
import com.ygo.model.db.SolrCard;
import com.ygo.model.vo.CardRequestVO;


public interface MonsterMapper {

	@Insert("INSERT INTO t_monster(c_name,j_name,e_name,nw_name,psd,lev,attribute,race,atk,def,pend,link,img,ban,desc_nw,proprietary,hash_code) VALUES(#{card.cName},#{card.jName},#{card.eName},#{card.nwName},#{card.psd},#{card.lev},#{card.attribute},#{card.race},#{card.atk},#{card.def},#{card.pend},#{card.link},#{card.img},#{card.ban},#{card.descNw},#{card.proprietary},#{card.hashCode})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", before = false, keyColumn = "id", keyProperty = "card.id", resultType = Integer.class)
	Integer insertCard(@Param("card") Monster mon);
	
	@Select("SELECT COUNT(*) FROM t_monster WHERE hash_code=#{hash}")
	Boolean exists(@Param("hash") Integer hash);
	
	List<Monster> findMonster(@Param("ids") Set<Integer> ids, @Param("mon") CardRequestVO monster, @Param("start") Integer start, @Param("row") Integer row);
	
	Integer totalNum(@Param("ids") Set<Integer> ids, @Param("mon") CardRequestVO monster);

    List<SolrCard> findAllMonster(@Param("start") Integer start, @Param("row") Integer row);
    
    @Select("SELECT COUNT(*) FROM t_monster")
    Integer count();
}

