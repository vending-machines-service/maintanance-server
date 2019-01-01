package vms.maintananceserver.dto;

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
	
	int machineId;
	int sensorId;
	int value;

	public SensorDTO(int machineId, int sensorId, int count) {
		super();
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.value = count;
	}
}
