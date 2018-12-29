package vending.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@NoArgsConstructor 
@ToString 
@EqualsAndHashCode
public class SensorDTO {
	Integer machineId;
	String sensorId;
	int value;
	
	public SensorDTO(int machineId, String sensorId, int count) {
		super();
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.value = count;
	}
}
