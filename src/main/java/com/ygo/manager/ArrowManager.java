package com.ygo.manager;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ygo.db.service.HashService;

@Component
public class ArrowManager {

	private static final Map<Integer, Set<Integer>> ARROWS = new ConcurrentHashMap<Integer, Set<Integer>>();

	@Autowired
	private HashService hashService;

	public void addData() {
		hashService.groupByArrow().forEach(data -> {
			ARROWS.put(data.getArrow(), data.getHash());
		});
	}
	
	public Set<Integer> getHash(Integer arrow) {
		return ARROWS.get(arrow);
	}
}
