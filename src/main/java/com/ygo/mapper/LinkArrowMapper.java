package com.ygo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ygo.model.db.ArrowHash;
import com.ygo.model.db.LinkArrow;

public interface LinkArrowMapper {

	@Insert("INSERT INTO t_link_arrow(monster_hash,arrow) VALUES(#{arrow.monsterHash},#{arrow.arrow})")
	Integer insertArrow(@Param("arrow") LinkArrow arrow);
	
	@Select("SELECT arrow FROM t_link_arrow WHERE monster_hash=#{hash}")
	List<Integer> findArrowByHash(@Param("hash") Integer hash);
	
	@Select("SELECT arrow,GROUP_CONCAT(monster_hash) hash FROM t_link_arrow GROUP BY arrow")
	List<ArrowHash> groupByArrow();
}
