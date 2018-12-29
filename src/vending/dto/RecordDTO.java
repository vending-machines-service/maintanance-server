package vending.dto;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class RecordDTO {
	int machineId;
	String sensorId;
	LocalDate date;
	int userId;
	
	public RecordDTO(int machineId, String sensorId, LocalDate date, Integer userId) {
		super();
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.date = date;
		this.userId = userId;
	}
	
	public RecordDTO(int machineId, String sensorId, LocalDate date) {
		super();
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.date = date;
	}
}
