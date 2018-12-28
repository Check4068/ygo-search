package com.ygo.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ygo.db.mapper.LinkArrowMapper;
import com.ygo.db.mapper.TypeMapper;
import com.ygo.db.model.ArrowHash;
import com.ygo.db.model.TypeHash;

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
