package vms.maintananceserver.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "current_maintenence")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RecordJPA {
  @Id
  String id;
  @Column(name = "machine_id")
  int machineId;
  @Column(name = "sensor_id")
  int sensorId;
  @Column(name = "date_open")
  LocalDate date;
  int value;
  @Column(name = "user_id")
  int userId;

  public RecordJPA(int machineId, int sensorId, LocalDate date, int value, int userId) {
    this.id = makeId(machineId, sensorId);
    this.machineId = machineId;
    this.sensorId = sensorId;
    this.date = date;
    this.value = value;
    this.userId = userId;
  }

  public RecordJPA(int machineId, int sensorId, int value, LocalDate date) {
    this.id = makeId(machineId, sensorId);
    this.machineId = machineId;
    this.sensorId = sensorId;
    this.value = value;
    this.date = date;
  }

  public static String makeId(int machineId, int sensorId) {
    return String.format("%d-%s", machineId, sensorId);
  }
}