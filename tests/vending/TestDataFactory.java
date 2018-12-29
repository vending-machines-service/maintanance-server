package vending;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vending.dto.SensorDTO;

public class TestDataFactory {
	private static final String MACHINE_ID_PREFIX = "MACHINE_";
	private static final String SENSOR_ID_PREFIX = "SENSOR_";
	private static final int MIN_BOUND = 0;
	private static final int MAX_BOUND = 100;
	
	public static List<SensorDTO> getSensorsData(int size) {
		List<SensorDTO> res = new ArrayList<SensorDTO>();
		
		for (int i = 0; i < size; i++) {
			int sensorValue = new Random().ints(1, MIN_BOUND, MAX_BOUND).findFirst().orElse(0);
			SensorDTO sensor = new SensorDTO(i, SENSOR_ID_PREFIX + i, sensorValue);
			res.add(sensor);
		}
		return res;
	}
}
