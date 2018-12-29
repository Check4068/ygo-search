package com.ygo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.ygo.model.db.Rare;

public interface RareMapper {

	@Insert("INSERT INTO t_rare(name,short) VALUES(#{rare.name},#{rare.shortName})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", before = false, keyColumn = "id", keyProperty = "rare.id", resultType = Integer.class)
	Integer insertRare(@Param("rare") Rare rare);
	
	@Select("SELECT COUNT(*) FROM t_rare WHERE short=#{name}")
	Boolean exists(@Param("name") String name);
	
	@Select("SELECT id FROM t_rare WHERE short=#{name}")
	Integer getIdByName(@Param("name") String name);
	
	@Select("SELECT name,short FROM t_rare WHERE id=#{id}")
	@Results({@Result(column = "short", property = "shortName")})
	Rare findById(@Param("id") Integer id);
}
