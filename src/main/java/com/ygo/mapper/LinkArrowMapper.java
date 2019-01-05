package com.ygo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.ygo.model.db.ArrowHash;

public interface LinkArrowMapper {
	
	@Select("SELECT arrow,GROUP_CONCAT(monster_hash) hash FROM t_link_arrow GROUP BY arrow")
	List<ArrowHash> groupByArrow();
}
