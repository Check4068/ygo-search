package com.ygo.manager;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ygo.db.service.HashService;

@Component
public class TypeManager {
	
	@Autowired
	private HashService hashService;
	
	private static final Map<Integer, Set<Integer>> TYPES = new ConcurrentHashMap<Integer, Set<Integer>>();
	
	public void addData() {
		hashService.groupByType().forEach(data -> {
			TYPES.put(data.getType(), data.getHash());
		});
	}
	
	public Set<Integer> getHash(Integer arrow) {
		return TYPES.get(arrow);
	}
}
