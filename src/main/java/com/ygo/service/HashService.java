package com.ygo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygo.mapper.LinkArrowMapper;
import com.ygo.mapper.TypeMapper;
import com.ygo.model.db.ArrowHash;
import com.ygo.model.db.TypeHash;

@Service
public class HashService {

	@Autowired
	private LinkArrowMapper arrowMapper;
	
	@Autowired
	private TypeMapper typeMapper;
	
	public List<ArrowHash> groupByArrow() {
		return arrowMapper.groupByArrow();
	}
	
	public List<TypeHash> groupByType() {
		return typeMapper.groupByType();
	}
}
