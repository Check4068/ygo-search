package com.ygo.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import com.ygo.db.model.MagTra;

public interface MagTraMapper {

	@Insert("INSERT INTO t_mag_tra(c_name,j_name,e_name,nw_name,psd,img,ban,desc_nw,proprietary,hash_code) VALUES(#{card.cName},#{card.jName},#{card.eName},#{card.nwName},#{card.psd},#{card.img},#{card.ban},#{card.descNw},#{card.proprietary},#{card.hashCode})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", before = false, keyColumn = "id", keyProperty = "card.id", resultType = Integer.class)
	Integer insertCard(@Param("card") MagTra magtTra);
	
	@Select("SELECT COUNT(*) FROM t_mag_tra WHERE hash_code=#{hash}")
	Boolean exists(@Param("hash") Integer hash);
	
	List<MagTra> findMagTra(@Param("mag") MagTra magtTra, @Param("start") Integer start, @Param("row") Integer row);
}
