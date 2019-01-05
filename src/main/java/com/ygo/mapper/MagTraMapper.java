package com.ygo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.ygo.model.db.SolrCard;

public interface MagTraMapper {
	
	List<SolrCard> findAllMagtra(@Param("start") Integer start, @Param("row") Integer row);
	
	@Select("SELECT COUNT(*) FROM t_mag_tra")
    Integer count();
}
