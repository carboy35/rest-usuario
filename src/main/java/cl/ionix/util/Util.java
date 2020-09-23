package cl.ionix.util;

import java.util.Map;

public final class Util {
	public static void measureTime(Map<String,Long> mapaTiempo) {
		
		if (!mapaTiempo.containsKey("startTime")) {
			mapaTiempo.put("startTime", System.currentTimeMillis());
		}else {
			mapaTiempo.put("endTime", System.currentTimeMillis());
			mapaTiempo.put("executeTime", mapaTiempo.get("endTime")- mapaTiempo.get("startTime"));
		}
		 
	}
}
