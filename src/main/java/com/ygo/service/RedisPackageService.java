package com.ygo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygo.mapper.PackageInfoMapper;
import com.ygo.model.db.CardPackInfo;

@Service
public class RedisPackageService {

	@Autowired
	private PackageInfoMapper infoMapper;
	
	@Autowired
	private RedisTemplate<String, String> template;
	
	public void pushRedis() throws Exception {
		if (template.keys("*").size() > 0) {
			return;
		}
		
		int start = 0;
		List<CardPackInfo> infos = infoMapper.findAll(start, 5000);
		while(infos != null && infos.size() > 0) {
			for (CardPackInfo cardPackInfo : infos) {
				//template.opsForValue().set(cardPackInfo.getCardHash().toString(), new ObjectMapper().writeValueAsString(cardPackInfo));
				template.opsForSet().add(cardPackInfo.getCardHash().toString(), new ObjectMapper().writeValueAsString(cardPackInfo));
			}
			
			start = start + 5000;
			infos = infoMapper.findAll(start, 5000);
		}
	}
}
