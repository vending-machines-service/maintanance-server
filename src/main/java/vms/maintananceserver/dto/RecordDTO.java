package vms.maintananceserver.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vms.maintananceserver.jpa.RecordJPA;


@Getter 
@Setter 
@NoArgsConstructor 
@ToString 
@EqualsAndHashCode
public class RecordDTO {
	
	@Id
	String id;
	LocalDate date;
	int machineId;
	int sensorId;
	int value;
	int userId;
	
	public RecordDTO(int machineId, int sensorId, int value, LocalDate date, int userId) {
		this.id = makeId(machineId, sensorId);
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.date = date;
		this.value = value;
		this.userId = userId;
	}

	public RecordDTO(int machineId, int sensorId,int value, LocalDate date) {
		this.id = makeId(machineId, sensorId);
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.date = date;
		this.value = value;
	}
	
	public static String makeId(int machineId, int sensorId) {
		return String.format("%d-%s", machineId, sensorId);
	}

	public RecordJPA toRecordJPA() {
		return new RecordJPA(this.machineId, this.sensorId, this.date, this.value, this.userId);
	}
}
