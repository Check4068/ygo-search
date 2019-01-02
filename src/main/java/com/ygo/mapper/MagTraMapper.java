package com.ygo.mapper;

import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import com.ygo.model.db.MagTra;
import com.ygo.model.db.SolrCard;
import com.ygo.model.vo.CardRequestVO;

public interface MagTraMapper {

	@Insert("INSERT INTO t_mag_tra(c_name,j_name,e_name,nw_name,psd,img,ban,desc_nw,proprietary,hash_code) VALUES(#{card.cName},#{card.jName},#{card.eName},#{card.nwName},#{card.psd},#{card.img},#{card.ban},#{card.descNw},#{card.proprietary},#{card.hashCode})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", before = false, keyColumn = "id", keyProperty = "card.id", resultType = Integer.class)
	Integer insertCard(@Param("card") MagTra magtTra);
	
	@Select("SELECT COUNT(*) FROM t_mag_tra WHERE hash_code=#{hash}")
	Boolean exists(@Param("hash") Integer hash);
	
	List<MagTra> findMagTra(@Param("ids") Set<Integer> ids, @Param("mag") CardRequestVO monster, @Param("start") Integer start, @Param("row") Integer row);

	Integer countNum(@Param("ids") Set<Integer> ids, @Param("mag") CardRequestVO monster);
	
	List<SolrCard> findAllMagtra(@Param("start") Integer start, @Param("row") Integer row);
	
	@Select("SELECT COUNT(*) FROM t_mag_tra")
    Integer count();
}
