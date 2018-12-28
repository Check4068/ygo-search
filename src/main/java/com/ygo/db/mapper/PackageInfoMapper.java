package com.ygo.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ygo.db.model.PackageInfo;

public interface PackageInfoMapper {

	@Insert("INSERT INTO t_package_info(card_hash,package_id,rare,card_no,sell_time) VALUES(#{info.cardHash},#{info.packageId},#{info.rare},#{info.cardNo},#{info.sellTime})")
	Integer insertInfo(@Param("info") PackageInfo info);
	
	@Select("SELECT package_id,rare,card_no,sell_time FROM t_package_info WHERE card_hash=#{hash}")
	List<PackageInfo> findByHash(@Param("hash") Integer hash);
}
