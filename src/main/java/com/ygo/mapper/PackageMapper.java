package com.ygo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.ygo.model.db.Package;

public interface PackageMapper {

	@Insert("INSERT INTO t_package(name,short) VALUES(#{pack.name},#{pack.shortName})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", before = false, keyColumn = "id", keyProperty = "pack.id", resultType = Integer.class)
	Integer insertPackage(@Param("pack") Package pack);
	
	@Select("SELECT COUNT(*) FROM t_package WHERE name=#{name}")
	Boolean exists(@Param("name") String name);
	
	@Select("SELECT id FROM t_package WHERE name=#{name}")
	Integer getIdByName(@Param("name") String name);
	
	@Select("SELECT name,short FROM t_package WHERE id=#{id}")
	Package findById(@Param("id") Integer id);
}
