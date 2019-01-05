package com.ygo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.ygo.model.db.CardPackInfo;

public interface PackageInfoMapper {
	
	@Select("SELECT a.card_hash,a.sell_time,a.card_no,b.name pack,c.short rare FROM t_package_info a, t_package b, t_rare c WHERE a.package_id = b.id AND a.rare = c.id LIMIT #{start},#{row}")
	List<CardPackInfo> findAll(@Param("start") Integer start, @Param("row") Integer row);
}
