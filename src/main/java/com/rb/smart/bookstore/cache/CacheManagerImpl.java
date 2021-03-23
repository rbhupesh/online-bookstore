package com.rb.smart.bookstore.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheManagerImpl implements CacheManager {
	Map<String, Object> map = new HashMap<>();
	
	public CacheManagerImpl() {
		Map<String, Integer> discountMap = new HashMap<>();
		discountMap.put("FICTION", 10);
		discountMap.put("COMIC", 0);
		
		map.put("DISCOUNT", discountMap);
	}

	@Override
	public Object getCachedObj(String string) {
		
		return map.get(string);
	}
	
	
	
	

}
