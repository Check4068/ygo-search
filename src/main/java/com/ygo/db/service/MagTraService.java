package com.ygo.db.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygo.basic.LimitEnum;
import com.ygo.basic.TypeEnum;
import com.ygo.db.mapper.MagTraMapper;
import com.ygo.db.mapper.PackageInfoMapper;
import com.ygo.db.mapper.PackageMapper;
import com.ygo.db.mapper.RareMapper;
import com.ygo.db.mapper.TypeMapper;
import com.ygo.db.model.MagTra;
import com.ygo.db.model.PackageInfo;
import com.ygo.model.CardVO;
import com.ygo.model.CardVO.PackInfo;

@Service
public class MagTraService {
	
	@Autowired
	private MagTraMapper magTraMapper;
	
	@Autowired
	private TypeMapper typeMapper;
	
	@Autowired
	private PackageInfoMapper infoMapper;
	
	@Autowired
	private PackageMapper packageMapper;
	
	@Autowired
	private RareMapper rareMapper;

	public List<CardVO> searchMagTra() throws Exception {
		MagTra magTra = new MagTra();
		magTra.setBan(1);
		List<MagTra> list = magTraMapper.findMagTra(magTra, 0, 100);
		List<CardVO> vos = new ArrayList<CardVO>();
		for (MagTra mt : list) {
			CardVO vo = new CardVO();
			vo.setcName(mt.getcName());
			vo.setBan(LimitEnum.getName(mt.getBan()));
			vo.setDescNw(mt.getDescNw());
			vo.seteName(mt.geteName());
			vo.setImg(mt.getImg());
			vo.setjName(mt.getjName());
			vo.setNwName(mt.getNwName());
			vo.setProprietary(LimitEnum.getName(mt.getProprietary()));
			vo.setPsd(mt.getPsd());
			for (Integer type : typeMapper.findTypeByHash(mt.getHashCode())) {
				vo.setType(TypeEnum.getName(type));
			}
			
			for (PackageInfo info : infoMapper.findByHash(mt.getHashCode())) {
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
}
