package vending.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="current_maintanance")
@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class RecordJPA {
	@Id
	String id;
	
	@Column(name="machine_id")
	Integer machineId;
	
	@Column(name="sensor_id")
	String sensorId;
	
	LocalDate date;
	
	Integer userId;
	
	public RecordJPA(int machineId, String sensorId, LocalDate date, int userId) {
		this.id = makeId(machineId, sensorId);
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.date = date;
		this.userId = userId;
	}

	public RecordJPA(int machineId, String sensorId, LocalDate date) {
		this.id = makeId(machineId, sensorId);
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.date = date;
	}
	
	public static String makeId(int machineId, String sensorId) {
		return String.format("%d-%s", machineId, sensorId);
	}
}
