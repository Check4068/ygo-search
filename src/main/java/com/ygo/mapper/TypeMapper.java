package com.ygo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.ygo.model.db.TypeHash;

public interface TypeMapper {
	
	@Select("SELECT type,GROUP_CONCAT(card_hash) hash FROM t_type GROUP BY type")
	List<TypeHash> groupByType();
}
