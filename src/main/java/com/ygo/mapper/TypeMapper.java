package com.ygo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ygo.model.db.Type;
import com.ygo.model.db.TypeHash;

public interface TypeMapper {

	@Insert("INSERT INTO t_type(card_hash,type) VALUES(#{type.cardHash},#{type.type})")
	Integer insertType(@Param("type") Type type);
	
	@Select("SELECT type FROM t_type WHERE card_hash=#{hash}")
	List<Integer> findTypeByHash(@Param("hash") Integer hash);
	
	@Select("SELECT type,GROUP_CONCAT(card_hash) hash FROM t_type GROUP BY type")
	List<TypeHash> groupByType();
}
