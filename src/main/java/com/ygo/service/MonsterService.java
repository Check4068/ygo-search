package com.ygo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ygo.basic.AttributeEnum;
import com.ygo.basic.LimitEnum;
import com.ygo.basic.RaceEnum;
import com.ygo.basic.TypeEnum;
import com.ygo.mapper.LinkArrowMapper;
import com.ygo.mapper.MonsterMapper;
import com.ygo.mapper.PackageInfoMapper;
import com.ygo.mapper.PackageMapper;
import com.ygo.mapper.RareMapper;
import com.ygo.mapper.TypeMapper;
import com.ygo.model.db.Monster;
import com.ygo.model.db.PackageInfo;
import com.ygo.model.vo.CardResponseVO;
import com.ygo.model.vo.CardRequestVO;
import com.ygo.model.vo.CardResponseVO.PackInfo;

@Service
public class MonsterService {
	
	@Autowired
	private MonsterMapper monsterMapper;
	
	@Autowired
	private TypeMapper typeMapper;
	
	@Autowired
	private LinkArrowMapper arrowMapper;
	
	@Autowired
	private PackageInfoMapper infoMapper;
	
	@Autowired
	private PackageMapper packageMapper;
	
	@Autowired
	private RareMapper rareMapper;

	public List<CardResponseVO> searchMonster(CardRequestVO monsterVO, Integer start, Integer row) throws Exception {
		Set<Integer> hashs = new HashSet<Integer>();
		if (monsterVO.getArrows() != null) {
			//arrowsHandler(monsterVO.getArrows(), hashs);
		}
		
		if (monsterVO.getOthers() != null) {
			//typeHandler(monsterVO.getOthers(), hashs);
		}
		
		if (hashs.size() <= 0) {
			hashs = null;
		}
		
		List<Monster> list = monsterMapper.findMonster(hashs, monsterVO, (start - 1) * row, row);
		List<CardResponseVO> vos = new ArrayList<CardResponseVO>();
		for (Monster mon : list) {
			CardResponseVO vo = new CardResponseVO();
			vo.setcName(mon.getcName());
			vo.setAtk(mon.getAtk().toString());
			vo.setDef(mon.getDef().toString());
			vo.setAttribute(AttributeEnum.getName(mon.getAttribute()));
			vo.setBan(LimitEnum.getName(mon.getBan()));
			vo.setDescNw(mon.getDescNw());
			vo.seteName(mon.geteName());
			vo.setImg(mon.getImg());
			vo.setjName(mon.getjName());
			vo.setLev(mon.getLev());
			vo.setLink(mon.getLink());
			vo.setNwName(mon.getNwName());
			vo.setPend(mon.getPend());
			vo.setProprietary(LimitEnum.getName(mon.getProprietary()));
			vo.setPsd(mon.getPsd());
			vo.setRace(RaceEnum.getName(mon.getRace()));
			for (Integer type : typeMapper.findTypeByHash(mon.getHashCode())) {
				vo.setType(TypeEnum.getName(type));
			}
			
			for (Integer arrow : arrowMapper.findArrowByHash(mon.getHashCode())) {
				vo.setArrow(arrow);
			}
			
			for (PackageInfo info : infoMapper.findByHash(mon.getHashCode())) {
				PackInfo pinfo = new PackInfo();
				try {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					pinfo.setSellTime(format.format(info.getSellTime()));
				} catch (Exception e) {
				}
				pinfo.setCardNo(info.getCardNo());
				pinfo.setRare(rareMapper.findById(info.getRare()).getShortName());
				pinfo.setPackName(packageMapper.findById(info.getPackageId()).getName());
				vo.setInfos(pinfo);
			}
			
			vos.add(vo);
		}
		
		return vos;
	}
	
	public Integer totalNum(CardRequestVO monsterVO) throws Exception {
		Set<Integer> hashs = new HashSet<Integer>();
		if (monsterVO.getArrows() != null) {
			//arrowsHandler(monsterVO.getArrows(), hashs);
		}
		
		if (monsterVO.getOthers() != null) {
			//typeHandler(monsterVO.getOthers(), hashs);
		}
		
		if (hashs.size() <= 0) {
			hashs = null;
		}
		
		return monsterMapper.totalNum(hashs, monsterVO);
	}
}
