package com.ygo.db.service;

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
import com.ygo.db.mapper.LinkArrowMapper;
import com.ygo.db.mapper.MonsterMapper;
import com.ygo.db.mapper.PackageInfoMapper;
import com.ygo.db.mapper.PackageMapper;
import com.ygo.db.mapper.RareMapper;
import com.ygo.db.mapper.TypeMapper;
import com.ygo.db.model.Monster;
import com.ygo.db.model.PackageInfo;
import com.ygo.manager.ArrowManager;
import com.ygo.manager.TypeManager;
import com.ygo.model.CardVO;
import com.ygo.model.CardVO.PackInfo;
import com.ygo.vo.MonsterVO;

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
	
	@Autowired
	private ArrowManager arrowManager;
	
	@Autowired
	private TypeManager typeManager;

	public List<CardVO> searchMonster(MonsterVO monsterVO, Integer start, Integer row) throws Exception {
		Set<Integer> hashs = new HashSet<Integer>();
		if (monsterVO.getArrows() != null) {
			arrowsHandler(monsterVO.getArrows(), hashs);
		}
		
		if (monsterVO.getOthers() != null) {
			typeHandler(monsterVO.getOthers(), hashs);
		}
		
		if (hashs.size() <= 0) {
			hashs = null;
		}
		
		List<Monster> list = monsterMapper.findMonster(hashs, monsterVO, (start - 1) * row, row);
		List<CardVO> vos = new ArrayList<CardVO>();
		for (Monster mon : list) {
			CardVO vo = new CardVO();
			vo.setcName(mon.getcName());
			vo.setAtk(mon.getAtk().toString());
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
	
	private void arrowsHandler(List<Integer> arrows, Set<Integer> hashs) {
		arrows.forEach(arrow -> {
			for (Integer integer : arrowManager.getHash(arrow)) {
				hashs.add(integer);
			}
		});
	}
	
	private void typeHandler(List<Integer> arrows, Set<Integer> hashs) {
		arrows.forEach(arrow -> {
			for (Integer integer : typeManager.getHash(arrow)) {
				hashs.add(integer);
			}
		});
	}
}
